package test.cases.trello;

import org.junit.*;
import org.junit.runners.MethodSorters;
import pages.trello.BoardPage;
import pages.trello.BoardsPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BoardTest extends BaseTest {
    private BoardPage boardPage;
    private BoardsPage boardsPage;

    @Before
    public void pagesSetup() {
        boardPage = new BoardPage(actions.getDriver());
        boardsPage = new BoardsPage(actions.getDriver());
    }
    @Test
    public void test1_createBoardWhenCreateBoardClicked() {
        login();

        boardsPage.createBoard();

        boardPage.assertAddListExists();
    }
    @Test
    public void test2_createNewCardInExistingBoardWhenCreateCardClicked() {
        login();

        boardPage.openBoard();
        boardPage.addCardToList();

        boardPage.assertCardExist("My First Card with Selenium Framework");
    }

    @Ignore
    @Test
    public void test3_moveCardBetweenStatesWhenDragAndDropIsUsed() {
        login();

        boardPage.openBoard();
        boardPage.addCardToList();
    }

    @Test
    public void test4_deleteBoardWhenDeleteButtonIsClicked() {
        login();

        boardPage.openBoard();

        boardPage.deleteBoard();

        BoardsPage boardsPage = new BoardsPage(actions.getDriver());
       // boardsPage.assertBoardExist(); - няма да мине защото вече няма такъв борд след като сме изтрили.
    }
}
