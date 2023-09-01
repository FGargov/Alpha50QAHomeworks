package test.cases.trello;

import org.junit.Assert;
import pages.trello.BoardPage;
import pages.trello.BoardsPage;

import org.junit.Ignore;
import org.junit.Test;

public class BoardTest extends BaseTest {

    @Test
    public void createBoardWhenCreateBoardClicked() {
        login();

        BoardsPage boardsPage = new BoardsPage(actions.getDriver());
        boardsPage.createBoard();

        BoardPage boardPage = new BoardPage(actions.getDriver());
        boardPage.assertAddListExists();
    }
    @Test
    public void createNewCardInExistingBoardWhenCreateCardClicked() {
        login();

        BoardPage boardPage = new BoardPage(actions.getDriver());
        boardPage.openBoard();
        boardPage.addCardToList();

        boardPage.assertCardExist("My First Card with Selenium Framework");
    }

    @Ignore
    @Test
    public void moveCardBetweenStatesWhenDragAndDropIsUsed() {
        login();

        BoardPage boardPage = new BoardPage(actions.getDriver());
        boardPage.openBoard();
        boardPage.addCardToList();
    }

    @Test
    public void deleteBoardWhenDeleteButtonIsClicked() {
        login();

        BoardPage boardPage = new BoardPage(actions.getDriver());
        boardPage.openBoard();

        boardPage.deleteBoard();


        BoardsPage boardsPage = new BoardsPage(actions.getDriver());
    }
}
