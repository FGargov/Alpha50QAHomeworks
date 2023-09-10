package pages.jira;

import org.openqa.selenium.WebDriver;
import static com.telerikacademy.seleniumframework.Utils.getConfigPropertyByKey;

public class LoginPage extends BaseJiraPage {
    public LoginPage(WebDriver driver) {
        super(driver, "jira.loginPage");
    }

    public void loginUser(String userKey) {
        String username = getConfigPropertyByKey("jira.users." + userKey + ".username");
        String password = getConfigPropertyByKey("jira.users." + userKey + ".password");

        navigateToPage();
        assertPageNavigated();

        actions.waitForElementVisible("jira.loginPage.username");
        actions.typeValueInField(username, "jira.loginPage.username");
        actions.clickElement("jira.loginPage.continueButton");

        actions.waitForElementClickable("jira.loginPage.password");
        actions.waitForElementClickable("jira.loginPage.loginButton");

        actions.typeValueInField(password, "jira.loginPage.password");
        actions.clickElement("jira.loginPage.loginButton");

        actions.waitForElementVisible("jira.dashboardPage.recentWork");
    }
}
