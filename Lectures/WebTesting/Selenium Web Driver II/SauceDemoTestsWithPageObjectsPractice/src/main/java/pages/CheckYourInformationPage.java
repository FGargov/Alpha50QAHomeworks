package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckYourInformationPage extends BasePage {
    public CheckYourInformationPage(WebDriver webDriver, WebDriverWait driverWait) {
        super(webDriver, driverWait, "checkout-step-one.html");
    }

    public By firstNameLoc = By.id("first-name");
    public By lastNameLoc = By.id("last-name");
    public By postCodeLoc = By.id("postal-code");
    public By continueButton = By.id("continue");

    public void fillShippingDetails(String firstName, String lastName, String zip) {
        driver.findElement(firstNameLoc).sendKeys(firstName);
        driver.findElement(lastNameLoc).sendKeys(lastName);
        driver.findElement(postCodeLoc).sendKeys(zip);
    }

    public void continueButtonClick() {
        driver.findElement(continueButton).click();
    }
}
