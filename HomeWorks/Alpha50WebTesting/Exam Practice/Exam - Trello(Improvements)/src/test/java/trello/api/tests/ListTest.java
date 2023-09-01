package trello.api.tests;

import base.BaseTestSetup;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.telerikacademy.api.tests.Constants.LIST_NAME;
import static com.telerikacademy.api.tests.Endpoints.BOARD_LISTS_ENDPOINT;
import static io.restassured.RestAssured.basePath;
import static java.lang.String.format;
import static java.util.Objects.isNull;
import static org.apache.http.HttpStatus.SC_OK;
import static org.testng.Assert.assertEquals;

public class ListTest extends BaseTestSetup {

    @BeforeClass
    public void listTestSetup() {
        if (isNull(boardId)) {
            BoardTest boardTest = new BoardTest();
            boardTest.createBoardTest();
        }
    }

    @Test
    public void createListTest() {
        basePath = BOARD_LISTS_ENDPOINT;

        String listNameUnique = format("%s %s", LIST_NAME, uniqueName);

        Response response = getApplicationAuthentication()
                .pathParam("id", boardId)
                .pathParam("lists", "lists")
                .queryParam("name", listNameUnique)
                .when()
                .post();

        int statusCode = response.getStatusCode();
        assertEquals(statusCode, SC_OK, format("Incorrect status code. Expected %s.", SC_OK));
        assertEquals(response.getBody().jsonPath().getString("name"), listNameUnique, "List name don't match");
        assertEquals(response.getBody().jsonPath().getString("idBoard"), boardId, "Board ids don't match");

        toDoListId = response.getBody().jsonPath().getString("id");

        System.out.printf("List with name '%s' and id '%s' was successfully created.%n", listNameUnique, toDoListId);
    }

   /* @Test
    public void correctDataReturned_when_createListOfBoardTest() {
        baseURI = format("%s%s", BASE_URL, LISTS_ENDPOINT);

        String requestBody = format(LIST, LIST_NAME, BOARD_ID, KEY, TOKEN);
        Assert.assertTrue(isValid(requestBody), "Body is not a valid JSON");

        Response response = getApplicationJSONSpecification()
                .body(requestBody)
                .post();

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, SC_OK, "Incorrect status code. Expected 200");
        System.out.printf("A list on a board with key %s was created%n%n", LIST_ID);

        Assert.assertEquals(response.jsonPath().getString("name"), "My first List on an exam board", "List name is not correct");
        Assert.assertFalse(response.jsonPath().getString("id").isEmpty(), "List ID is empty in the response");
    }*/
}
