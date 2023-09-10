package pages.jira;

import org.openqa.selenium.WebDriver;
import pages.jira.enums.Bug;
import pages.jira.enums.Story;

import static com.telerikacademy.seleniumframework.Utils.getUIMappingByKey;

public class IssuesPage extends BaseJiraPage {

    public IssuesPage(WebDriver driver) {
        super(driver, "");
    }

    public void createIssueStory() {
        actions.waitForElementClickable("jira.dashboardPage.jiraSoftware");
        actions.clickElement("jira.dashboardPage.jiraSoftware");

        actions.waitForElementClickable("jira.dashboardPage.projectsButton");
        actions.clickElement("jira.dashboardPage.projectsButton");

        actions.waitForElementClickable("jira.dashboard.recentProject");
        actions.clickElement("jira.dashboard.recentProject");

        actions.clickElement("jira.header.createButton");

        actions.waitForElementClickable("jira.createIssueFormIssueType");
        actions.clickElement("jira.createIssueFormIssueType");
        actions.clickElement("jira.createIssueFormIssueTypeStorySelection");

        actions.waitForElementClickable("jira.createIssueFormSummaryField");
        actions.typeValueInField(Story.TITLE.getString(),"jira.createIssueFormSummaryField");

        actions.typeValueInField(Story.DESCRIPTION.getString(), "jira.createIssueFormDescription");

        actions.clickElement("jira.createIssueFormPriorityType");
        actions.clickElement("jira.createIssueFormPriorityTypeSelection");

        actions.clickElement("jira.createIssueFormCreateButton");

        actions.clickElement("jira.sidebarMenu.issues");
    }

    public void createIssueBug() {
        actions.waitForElementClickable("jira.dashboardPage.jiraSoftware");
        actions.clickElement("jira.dashboardPage.jiraSoftware");

        actions.waitForElementClickable("jira.dashboardPage.projectsButton");
        actions.clickElement("jira.dashboardPage.projectsButton");

        actions.waitForElementClickable("jira.dashboard.recentProject");
        actions.clickElement("jira.dashboard.recentProject");

        actions.clickElement("jira.header.createButton");

        actions.waitForElementClickable("jira.createIssueFormIssueType");
        actions.clickElement("jira.createIssueFormIssueType");
        actions.clickElement("jira.createIssueFormIssueTypeBugSelection");

        actions.waitForElementClickable("jira.createIssueFormSummaryField");
        actions.typeValueInField(Bug.TITLE.getString(),"jira.createIssueFormSummaryField");

        actions.typeValueInField(Bug.DESCRIPTION.getString(), "jira.createIssueFormDescription");

        actions.clickElement("jira.createIssueFormPriorityType");
        actions.clickElement("jira.createIssueFormPriorityTypeSelection");

        actions.clickElement("jira.createIssueFormCreateButton");

        actions.clickElement("jira.sidebarMenu.issues");
    }
}
