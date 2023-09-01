package pages.trello;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.telerikacademy.testframework.Utils.getUIMappingByKey;

public class BoardPage extends BaseTrelloPage {

    public BoardPage(WebDriver driver) {
        super(driver, "trello.boardPage");
    }

    public void addCardToList() {
        String cardName = getUIMappingByKey("trello.cardName");

        actions.waitForElementClickable("trello.boardPage.addNewList");
        actions.clickElement("trello.boardPage.addNewList");

        actions.waitForElementClickable("trello.boardPage.cardTitleInput");
        actions.clickElement("trello.boardPage.cardTitleInput");
        actions.typeValueInField(cardName, "trello.boardPage.cardTitleInput");

        actions.clickElement("trello.createCard.button");
    }

    public void moveCardToList(String cardName, String listName) {
    }

    public void assertListExists(String listName) {
        actions.waitForElementPresent("trello.boardPage.listByName", listName);
    }

    public void assertAddListExists() {
        actions.waitForElementPresent("trello.boardPage.listWrapper");
    }
    public void assertCardExist(String myLastCard) {
        actions.waitForElementPresent("trello.boardPage.lastCreatedCardName", myLastCard);
    }

    public void clickOnBoard(String boardName) {
        actions.waitForElementVisible("trello.boardsPage.boardByTeamAndName", boardName);
        actions.clickElement("trello.boardsPage.boardByTeamAndName", boardName);
    }

    public void openBoard() {
        String boardName = getUIMappingByKey("trello.boardName");

        actions.waitForElementVisible("trello.boardsPage.boardByTeamAndName", boardName);
        actions.waitForElementClickable("trello.boardsPage.boardByTeamAndName", boardName);
        actions.clickElement("trello.boardsPage.boardByTeamAndName", boardName);
    }

    public void deleteBoard() {
        actions.waitForElementPresent("trello.deleteBoard.showBoardMenu");
        actions.clickElement("trello.deleteBoard.showBoardMenu");

        actions.waitForElementVisible("trello.deleteBoard.closeBoardLink");
        actions.clickElement("trello.deleteBoard.closeBoardLink");
        actions.clickElement("trello.deleteBoard.closeBoardConfirmLink");

        actions.waitForElementVisible("trello.deleteBoard.permanentlyDeleteLink");
        actions.clickElement("trello.deleteBoard.permanentlyDeleteLink");
        actions.clickElement("trello.deleteBoard.confirmPermanentlyDeleteButton");
    }
}
