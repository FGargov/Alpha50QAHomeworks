package test.cases.trello;

import api.BoardModel;
import api.ListModel;
import api.TrelloApi;
import org.junit.*;
import pages.trello.BoardPage;
import pages.trello.BoardsPage;

import java.util.List;

import static org.apache.http.HttpStatus.SC_OK;

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
        //става излишен?
        //API: Cleanup board

 /*       login();

        boardsPage.createBoard();

        boardPage.assertAddListExists();*/
    }

    @Test
    public void test2_createNewCardInExistingBoardWhenCreateCardClicked() {
        ListModel responseList = trelloApi.createList(createdBoard.id, "ListNameTest2");
        trelloApi.createCard(responseList.id, "CardNameTest2");

        Assert.assertEquals(responseList.status.toString(), SC_OK, "Incorrect status code");
        Assert.assertEquals("The list name is not the same",responseList.name, "ListNameTest2");
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
        trelloApi.createCard(responseListFrom.id, "CardNameAuto");

        actions.dragAndDropElement("trello.boardPage.cardByName", "trello.boardPage.listByName");
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
