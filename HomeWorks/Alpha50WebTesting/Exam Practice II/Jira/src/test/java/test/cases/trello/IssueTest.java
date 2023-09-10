package test.cases.trello;

import org.junit.Before;
import org.junit.Test;
import pages.jira.IssuePage;
import pages.jira.IssuesPage;

public class IssueTest extends BaseTest {
    private IssuesPage issuesPage;
    private  IssuePage issuePage;

    @Before
    public void pageSetup() {
        issuesPage = new IssuesPage(actions.getDriver());
        issuePage = new IssuePage(actions.getDriver());
    }

    @Test
    public void test1_createNewStory_when_CreateButtonClicked() {
        login();

        issuesPage.createIssueStory();

        issuePage.asserStoryIsCreated();
    }

    @Test
    public void test2_createNewBug_when_CreateButtonClicked() {
        login();

        issuesPage.createIssueBug();

        issuePage.assertBugIsCreated();
    }
}
