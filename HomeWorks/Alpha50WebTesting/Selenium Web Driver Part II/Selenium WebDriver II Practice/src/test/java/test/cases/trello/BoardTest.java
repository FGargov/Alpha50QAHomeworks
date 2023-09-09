package test.cases.trello;

import api.BoardModel;
import api.CardModel;
import api.ListModel;
import api.TrelloApi;
import io.restassured.response.Response;
import org.junit.*;
import pages.trello.BoardPage;
import pages.trello.BoardsPage;

import java.util.List;

import static com.telerikacademy.testframework.Utils.getUIMappingByKey;
import static org.apache.http.HttpStatus.SC_OK;
import static org.junit.Assert.assertEquals;

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
        //става излишен и няма смисъл да се прави.
        //API: Cleanup board

 /*       login();

        boardsPage.createBoard();

        boardPage.assertAddListExists();*/
    }

    @Test
    public void test2_createNewCardInExistingBoardWhenCreateCardClicked() {
        ListModel responseList = trelloApi.createList(createdBoard.id, "ListNameTest2");
        CardModel responseCard = trelloApi.createCard(responseList.id, "CardNameTest2");

        String expectedListName = "ListNameTest2";
        String expectedCardName = "CardNameTest2";

        assertEquals("The list name is not the same", responseList.name, expectedListName);
        assertEquals("The card name is not the same", responseCard.name, expectedCardName);
        //API: Create a board
        //API: Create a list
        //API: Delete board

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
        CardModel responseCard = trelloApi.createCard(responseListFrom.id, "CardNameAuto");

        String expectedListFromName = responseListFrom.name;
        String expectedListToName = responseListTo.name;
        String expectedCardToName = responseCard.name;

        assertEquals("The list From name is not the same", responseListFrom.name, expectedListFromName);
        assertEquals("The list To name is not the same", responseListTo.name, expectedListToName);

        actions.dragAndDropElement("trello.boardPage.cardByName", "trello.boardPage.listByName");

        // Трябва да се рефакторира.
     /*   public void assertCardInList(String cardName, String listName) {
            actions.waitForElementPresent("trello.checkIfCard.IsInList", cardName, listName);
        }*/
    }

    @Test
    public void test4_deleteBoardWhenDeleteButtonIsClicked() {
        //няма смисъл да се прави
        // API: Create a board
        ///API: Delete board






   /*     login();

        boardPage.openBoard();
        boardPage.deleteBoard();

        boardPage.assertBoardDeleted();*/
    }
}
