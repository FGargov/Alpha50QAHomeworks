package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutCompletePage extends BasePage{
    public CheckoutCompletePage(WebDriver webDriver, WebDriverWait driverWait) {
        super(webDriver, driverWait, "checkout-complete.html");
    }

    public By finishButton = By.id("finish");

    public By checkoutComplete = By.xpath("//span[@class='title']");

    public String getCheckoutCompleteText() {
        return driver.findElement(checkoutComplete).getText();
    }

    public void clickFinishButton() {
        driver.findElement(finishButton).click();
    }
}
