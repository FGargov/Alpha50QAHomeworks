package pages.jira;

import org.openqa.selenium.WebDriver;
import pages.jira.enums.Story;

import static com.telerikacademy.seleniumframework.Utils.getUIMappingByKey;

public class IssuePage extends BaseJiraPage {
    public IssuePage(WebDriver driver) {
        super(driver, "jira.issuesPage");
    }

  /*  public void assertBoardDeleted() {
        String xpath = getUIMappingByKey("trello.boardXpath");
        String boardName = getUIMappingByKey("trello.boardName");

        Assert.assertFalse(String.format("Board %s not deleted", boardName), actions.isElementPresent(xpath, boardName));

    }*/

    public void asserStoryIsCreated() {
        String issueXPath = String.format(getUIMappingByKey("jira.issuesPage.createdStoryName"), Story.TITLE.getString());
        actions.waitForElementPresent(issueXPath);
    }

    public void assertBugIsCreated() {
        String issueXPath = String.format(getUIMappingByKey("jira.issuesPage.createdStoryName"), Story.TITLE.getString());
        actions.waitForElementPresent(issueXPath);
    }
}
