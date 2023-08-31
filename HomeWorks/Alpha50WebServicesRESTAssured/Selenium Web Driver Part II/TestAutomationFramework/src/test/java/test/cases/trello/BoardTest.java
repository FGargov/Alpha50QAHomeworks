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

        // API: Cleanup board
    }

    @Test
    public void createNewCardInExistingBoardWhenCreateCardClicked() {
        login();

        BoardPage boardPage = new BoardPage(actions.getDriver());
        boardPage.clickOnBoard("My First Board");

        boardPage.addCardToList("New Test Card");

        // API: Create a board
        // API: Create a list

        // API: Cleanup board
    }

    @Ignore
    @Test
    public void moveCardBetweenStatesWhenDragAndDropIsUsed() {

        // API: Create a board
        // API: Create 2 lists
        // API: Create a list

        // API: Cleanup board
    }

    @Ignore
    @Test
    public void deleteBoardWhenDeleteButtonIsClicked() {
        // API: Create a board

        // API: Delete board
    }
}
