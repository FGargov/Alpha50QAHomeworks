package test.cases.trello;

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

    @Ignore
    @Test
    public void createNewCardInExistingBoardWhenCreateCardClicked() {
    }

    @Ignore
    @Test
    public void moveCardBetweenStatesWhenDragAndDropIsUsed() {
    }

    @Ignore
    @Test
    public void deleteBoardWhenDeleteButtonIsClicked() {
    }
}
