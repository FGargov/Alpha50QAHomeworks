package core;

import org.example.enums.BrowserType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.example.Credentials.*;
import static org.example.WebElementsIDs.*;
import static org.example.Xpaths.*;

public class BaseTest {

    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeAll
    public static void beforeAllTestes() {
        driver = startBrowser(BrowserType.FIREFOX);

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.saucedemo.com");
        userAuthentication(VALID_USERNAME, VALID_PASSWORD);
    }


    protected static WebDriver startBrowser(BrowserType browserType) {

        switch (browserType) {
            case CHROME:
                ChromeOptions options = new ChromeOptions();
                return new ChromeDriver(options);
            case FIREFOX:
                FirefoxOptions foxOptions = new FirefoxOptions();
                return new FirefoxDriver(foxOptions);
            case EDGE:
                EdgeOptions edgeOptions = new EdgeOptions();
                return new EdgeDriver(edgeOptions);
        }

        return null;
    }


    public static void userAuthentication(String usernameCredential, String passwordCredential) {

        WebElement username = driver.findElement(By.xpath(LOGIN_USERNAME_XPATH));
        username.sendKeys(usernameCredential);

        WebElement password = driver.findElement(By.xpath(LOGIN_USER_PASSWORD));
        password.sendKeys(passwordCredential);

        WebElement loginButton = driver.findElement(By.xpath(LOGIN_LOGINING_BUTTON));
        loginButton.click();

    }

    public static List<WebElement> basket() {
        return driver.findElements(By.xpath(SHOPPING_CART_XPATH));
    }

    protected WebElement getProductByTitle(String title) {
        return driver.findElement(By.xpath(String.format("//div[@class='cart_item_label' and descendant::div[text()='%s']]", title)));
    }

    protected static void fillShippingDetails(String firstName, String lastName, String zip) {
        driver.findElement(By.id(FIRST_NAME_BOX_ID)).sendKeys(firstName);
        driver.findElement(By.id(LAST_NAME_BOX_ID)).sendKeys(lastName);
        driver.findElement(By.id(POSTAL_CODE_BOX_ID)).sendKeys(zip);
    }

    protected static void add_Backpack_and_Tshirt_to_shopping_cart() {
        WebElement addBackPackToCart = driver.findElement(By.xpath(ADD_BACKPACK_TO_CART_BUTTON));
        addBackPackToCart.click();

        WebElement addTShirt = driver.findElement(By.xpath(ADD_TSHIRT_TO_CART_BUTTON));
        addTShirt.click();
        // Click on shopping Cart
        WebElement shoppingCart = driver.findElement(By.xpath(SHOPPING_CART_BUTTON));
        shoppingCart.click();
    }

    @AfterEach
    public void resetState() {
        WebElement burgerButton = driver.findElement(By.xpath(BURGER_BUTTON));
        burgerButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(RESET_APP_STATE_BUTTON)));
        WebElement resetButton = driver.findElement(By.xpath(RESET_APP_STATE_BUTTON));
        resetButton.click();
        driver.get("https://www.saucedemo.com/inventory.html");
    }

    @AfterAll
    public static void afterTest() {
        // close driver
        driver.close();
    }
}

