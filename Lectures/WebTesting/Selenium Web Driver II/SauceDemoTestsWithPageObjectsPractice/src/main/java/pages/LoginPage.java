package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.api.*;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver webDriver, WebDriverWait driverWait) {
        super(webDriver, driverWait, "");
    }

    // Locators
    public By usernameLocator = By.xpath("//input[@data-test='username']");
    public By passwordLocator = By.xpath("//input[@data-test='password']");
    public By loginButtonLocator = By.xpath("//input[@data-test='login-button']");

    // Methods
    public void fillLoginForm(String username, String pass) {
        WebElement usernameInput = driver.findElement(usernameLocator);
        usernameInput.sendKeys(username);

        WebElement password = driver.findElement(passwordLocator);
        password.sendKeys(pass);

        WebElement loginButton = driver.findElement(loginButtonLocator);
        loginButton.click();
    }
}
