const kinveyServiceBaseUrl = "https://baas.kinvey.com";
const kinveyAppId = "kid_ryk6gqz8";
const kinveyAppSecret = "f2bc38602ce8453dbc953d885c80878b";

function showView(viewId) {
    $("main>section").hide()
    $('#'+viewId).show()
}

function showHideNavigationLinks() {
    let loggedIn = sessionStorage.authToken != null
    if (loggedIn) {
        $("#linkLogin").hide()
        $("#linkRegister").hide()
        $("#linkListBooks").show()
        $("#linkCreateBook").show()
        $("#linkLogout").show()
    } else {
        $("#linkLogin").show()
        $("#linkRegister").show()
        $("#linkListBooks").hide()
        $("#linkCreateBook").hide()
        $("#linkLogout").hide()
    }
}

function showHomeView() {
    showView('viewHome')
}

function showLoginView() {
    showView('viewLogin')
}

function login() {
    let authBase64 = btoa(kinveyAppId + ":" + kinveyAppSecret)
    let loginData =  {
        username: $('#loginUser').val(),
        password: $('#loginPass').val()
    }
    $.ajax({
        method: 'POST',
        url: kinveyServiseBaseUrl + "user/" + kinveyAppId + "/login",
        data:loginData,
        headers: { "Authorization": "Basic "+ authBase64 },
        success: loginSucces,
        error: showAjaxError
    })
    function loginSucces(data, status) {
        sessionStorage.authToken = data._kmd.authtoken
        showListBooksView()
        showHideNavigationLinks()
        showInfo('Login successful')
    }
}

function showInfo(messageText) {
    $('#infoBox').text(messageText).show().delay(3000).fadeOut()
}

function showAjaxError(data, status) {
    let errorMsg = 'Error: ' + JSON.stringify(data)
    $('#errorBox').text(errorMsg).show()
}

function showRegisterView() {
    showView('viewRegister')

}

function register() {

}

function showListBooksView() {
    showView('viewListBooks')

    $.ajax({
        method: "GET",
        url: kinveyServiseBaseUrl + "appdata/" + kinveyAppId + "/books",
        headers: { "Authorization": "Kinvey " + sessionStorage.authToken },
        success: booksLoaded,
        error: showAjaxError
    })
    function booksLoaded(books, status) {

        showInfo('Books loaded.')
        let booksTable = $("<table>")
            .append($("<tr>")
                .append($('<th>Title</th>'))
                .append($('<th>Author</th>'))
                .append($('<th>Description</th>'))
            )
        for (let book of books) {
            booksTable.append($("<tr>")
                .append($("<td></td>").text(book.title))
                .append($("<td></td>").text(book.author))
                .append($("<td></td>").text(book.description))
            )
        }
        $('#books').append(booksTable)
    }
}

function showCreateBookView() {
    showView('viewCreateBook')
}

function createBook() {

}

function logout() {
    sessionStorage.clear()
    showHomeView()
    showHideNavigationLinks()
}

$(function(){
    $("#linkHome").click(showHomeView)
    $("#linkLogin").click(showLoginView)
    $("#linkRegister").click(showRegisterView)
    $("#linkListBooks").click(showListBooksView)
    $("#linkCreateBook").click(showCreateBookView)
    $("#linkLogout").click(logout)

    $('#buttonLogin').click(login)
    $('#buttonRegister').click(register)
    $('#buttonCreateBook').click(createBook)

    showHomeView()
    showHideNavigationLinks()
})

