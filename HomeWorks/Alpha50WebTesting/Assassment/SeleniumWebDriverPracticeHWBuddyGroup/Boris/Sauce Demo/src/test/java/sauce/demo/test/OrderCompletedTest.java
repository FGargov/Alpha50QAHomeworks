package sauce.demo.test;

import core.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.DecimalFormatSymbols;
import java.util.Locale;

import static org.example.Constans.*;
import static org.example.Xpaths.*;
import static org.example.Xpaths.FINISH_BUTTON;

public class OrderCompletedTest extends BaseTest {

    @Test
    public void orderCompleted_when_addProduct_and_checkout_withConfirm() {
        // Add Backpack and T-shirt to shopping cart


        add_Backpack_and_Tshirt_to_shopping_cart();

//        var items = driver.findElements(By.className("inventory_item_name"));
        basket();

        Assertions.assertEquals(2, basket().size(), "Items count not as expected");



        //Click on checkout button
        WebElement checkoutButton = driver.findElement(By.xpath(CHECKOUT_BUTTON));
        checkoutButton.click();



        // Fill Contact Details
        fillShippingDetails(FIRST_NAME, LAST_NAME, ZIP_CODE);

        // Complete Order
        WebElement continueButton=driver.findElement(By.xpath(CONTINUE_BUTTON));
        continueButton.click();

        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        symbols.setDecimalSeparator('.');
        symbols.setGroupingSeparator(',');
        String total;
        total = (driver.findElement(By.className("summary_total_label")).getText());

        double expectedPrice = 29.99 + 15.99 + 3.68;
        // Define the decimal format pattern

        String expectedTotal = String.format("Total: $%s", expectedPrice);
        Assertions.assertEquals(expectedTotal, total, "Items total price not as expected");

        WebElement finishButton=driver.findElement(By.xpath(FINISH_BUTTON));
        finishButton.click();

        // Assert Items removed from Shopping Cart

        WebElement backToShoppingCart=driver.findElement(By.xpath(BACK_TO_SHOPPING_CART_BUTTON));
        backToShoppingCart.click();

        basket();

        Assertions.assertEquals(0, basket().size(), "Items count not as expected");
    }


}
