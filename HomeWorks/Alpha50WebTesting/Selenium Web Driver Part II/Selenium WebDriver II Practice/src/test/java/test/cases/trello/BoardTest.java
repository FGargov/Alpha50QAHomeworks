package test.cases.trello;

import api.BoardModel;
import api.ListModel;
import api.TrelloApi;
import org.junit.*;
import pages.trello.BoardPage;
import pages.trello.BoardsPage;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BoardTest extends BaseTest {
    private TrelloApi trelloApi;
    private BoardModel createdBoard;

    @Before
    public void pagesSetup() {
        trelloApi = new TrelloApi();
        createdBoard = trelloApi.createBoard("Board Name form Automation", "Description");
    }

    @After
    public void afterTest() {
        var deletionResponse = trelloApi.deleteBoard(createdBoard.id);
    }

    @Test
    public void test1_createBoardWhenCreateBoardClicked() {
        //API: Cleanup board

        login();

        BoardsPage boardsPage = new BoardsPage(actions.getDriver());
        boardsPage.createBoard();

        BoardPage boardPage = new BoardPage(actions.getDriver());
        boardPage.assertAddListExists();

 /*       login();

        boardsPage.createBoard();

        boardPage.assertAddListExists();*/
    }

    @Test
    public void test2_createNewCardInExistingBoardWhenCreateCardClicked() {


        //API: Create a board
        //API: Create a list
        //API: Delete board
        //Assert.assertTrue(createdBoardResponse.statusCode() == HttpStatus.SC_OK);





        /*login();

        boardPage.openBoard();
        boardPage.createList();

        String cardName = getUIMappingByKey("trello.cardName");
        boardPage.addCardToList(cardName);

        String firstListName = getUIMappingByKey("trello.listName");
        boardPage.assertCardExistInList(cardName, firstListName);*/
    }
    @Ignore
    @Test
    public void test3_moveCardBetweenStatesWhenDragAndDropIsUsed() {
        ListModel responseListFrom = trelloApi.createList(createdBoard.id, "ListNameAutoFrom");
        ListModel responseListTo = trelloApi.createList(createdBoard.id, "ListNameAutoTo");
        trelloApi.createCard(responseListFrom.id, "CardNameAuto");

        actions.dragAndDropElement("trello.boardPage.cardByName", "trello.boardPage.listByName");
        //API: Create a board
        //API: Create a list
        //API: Create a card
        //API: Cleanup board





    /*    login();

        boardPage.openBoard();
        boardPage.createList();
        String cardName = getUIMappingByKey("trello.cardName");
        boardPage.addCardToList(cardName);

        String targetListName = getUIMappingByKey("trello.targetListName");
        String firstListName = getUIMappingByKey("trello.firstListName");

        boardPage.moveCardToList(cardName, targetListName);

        boardPage.assertCardInList(cardName, targetListName);
        boardPage.assertCardNotInList(firstListName, cardName);*/
    }

    @Test
    public void test4_deleteBoardWhenDeleteButtonIsClicked() {
        // API: Create a board
        ///API: Delete board






   /*     login();

        boardPage.openBoard();
        boardPage.deleteBoard();

        boardPage.assertBoardDeleted();*/
    }
}
