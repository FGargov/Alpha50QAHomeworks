package pages.jira;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.jira.enums.Bug;
import pages.jira.enums.Story;

import static com.telerikacademy.seleniumframework.Utils.getUIMappingByKey;

public class IssuePage extends BaseJiraPage {
    public IssuePage(WebDriver driver) {
        super(driver, "jira.issuesPage");
    }

    public void linkBugToStory() {
        actions.waitForElementClickable("jira.dashboardPage.jiraSoftware");
        actions.clickElement("jira.dashboardPage.jiraSoftware");

        actions.waitForElementClickable("jira.dashboardPage.projectsButton");
        actions.clickElement("jira.dashboardPage.projectsButton");

        actions.waitForElementClickable("jira.dashboard.recentProject");
        actions.clickElement("jira.dashboard.recentProject");

        actions.waitForElementClickable("jira.sidebarMenu.issues");
        actions.clickElement("jira.sidebarMenu.issues");

        actions.waitForElementClickable("jira.issuesPage.lastCreatedBug");
        actions.clickElement("jira.issuesPage.lastCreatedBug");

        actions.waitForElementClickable("jira.createdBug.LinkIssueButton");
        actions.clickElement("jira.createdBug.LinkIssueButton");

        actions.waitForElementClickable("jira.createdBug.searchField");
        actions.typeValueInField("SEL-7", "jira.createdBug.searchField");
        actions.pressKey(Keys.ENTER);

        actions.waitForElementClickable("jira.createdBug.linkButton");
        actions.clickElement("jira.createdBug.linkButton");
    }

    public void asserStoryIsCreated() {
        String issueXPath = String.format(getUIMappingByKey("jira.issuesPage.createdStoryName"), Story.TITLE.getString());
        actions.waitForElementPresent(issueXPath);
    }

    public void assertBugIsCreated() {
        String issueXPath = String.format(getUIMappingByKey("jira.issuesPage.createdBugName"), Bug.TITLE.getString());
        actions.waitForElementPresent(issueXPath);
    }

    public void assertCorrectRelationStatus() {
        String relationStatusName = getUIMappingByKey("jira.relationName");
        String relationStatusXPath = String.format(getUIMappingByKey("jira.relationStatus"), relationStatusName);

        Assert.assertTrue("The relation status is correct", actions.isElementPresent(relationStatusXPath, relationStatusName));
    }
}
