package test.cases.trello;

import com.telerikacademy.seleniumframework.UserActions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import pages.jira.LoginPage;

public class BaseTest {

    UserActions actions = new UserActions();

    @BeforeClass
    public static void setUp() {

        UserActions.loadBrowser("jira.homePage");
    }

    @AfterClass
    public static void tearDown() {

        UserActions.quitDriver();
    }

    public void login() {
        LoginPage loginPage = new LoginPage(actions.getDriver());
        loginPage.loginUser("user");
    }

}
