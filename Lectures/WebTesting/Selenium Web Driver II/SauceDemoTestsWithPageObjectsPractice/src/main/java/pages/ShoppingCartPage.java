package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ShoppingCartPage extends BasePage {

    public ShoppingCartPage(WebDriver webDriver, WebDriverWait driverWait) {
        super(webDriver, driverWait, "cart.html");
    }

    private By itemsList = By.className("inventory_item_name");
    private By checkoutButton = By.id("checkout");

    public void checkoutButtonClick() {
        driver.findElement(checkoutButton).click();
    }
    public List<WebElement> getItems() {
        return driver.findElements(itemsList);
    }
}
