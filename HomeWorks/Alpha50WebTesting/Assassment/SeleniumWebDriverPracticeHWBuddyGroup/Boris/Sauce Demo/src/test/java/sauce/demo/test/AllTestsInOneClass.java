package sauce.demo.test;

import core.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.example.Constans.*;
import static org.example.WebElementsIDs.*;
import static org.example.Xpaths.*;
import static org.example.Xpaths.FINISH_BUTTON;

public class AllTestsInOneClass extends BaseTest {

    @Test
    public void userAuthenticated_when_validCredentialsProvided() {
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.saucedemo.com/inventory.html";
        String expectedPageTittle = "Swag Labs";

        WebElement inventoryPageTitle = driver.findElement(By.xpath(INVERTORY_PAGE_TITTLE));
        wait.until(ExpectedConditions.visibilityOf(inventoryPageTitle));

        // Add Assert
        Assertions.assertEquals(expectedURL, actualURL, "User is not authenticated.");
        Assertions.assertEquals(expectedPageTittle,
                driver.getTitle(),
                "Page tittle is different than expected.");
    }

    @Test
    public void productAddedToShoppingCar_when_addToCart() {
        add_Backpack_and_Tshirt_to_shopping_cart();

        WebElement backpack = getProductByTitle(BACKPACK_TITTLE);
        WebElement tShirt = getProductByTitle(T_SHIRT_TITTLE);

        // Assert Items and Totals
        Assertions.assertTrue(backpack.getText().contains(BACKPACK_TITTLE), "Item tittle is not correct.");
        Assertions.assertTrue(backpack.getText().contains(BACKPACK_PRICE), "Item price is not correct.");
        Assertions.assertTrue(backpack.getText().contains(BACKPACK_DESCRIPTION), "Item description is wrong.");

        Assertions.assertTrue(tShirt.getText().contains(T_SHIRT_TITTLE), "Item tittle is not correct.");
        Assertions.assertTrue(tShirt.getText().contains(T_SHIRT_VALUE), "Item price is not correct.");
        Assertions.assertTrue(tShirt.getText().contains(T_SHIRT_DESCRIPTION), "Item description is wrong.");
    }

    @Test
    public void orderCompleted_when_addProduct_and_checkout_withConfirm() {
        // Add Backpack and T-shirt to shopping cart
        add_Backpack_and_Tshirt_to_shopping_cart();

        basket();

        Assertions.assertEquals(2, basket().size(), "Items count not as expected");

        //Click on checkout button
        WebElement checkoutButton = driver.findElement(By.xpath(CHECKOUT_BUTTON));
        checkoutButton.click();

        // Fill Contact Details
        fillShippingDetails(FIRST_NAME, LAST_NAME, ZIP_CODE);

        // Complete Order
        WebElement continueButton = driver.findElement(By.xpath(CONTINUE_BUTTON));
        continueButton.click();

//        DecimalFormat decimalFormat = new DecimalFormat("#.##");
//        String total;
//        total = (driver.findElement(By.className("summary_total_label")).getText());
//
//        double expectedPrice = 29.99 + 15.99 + 3.68;
//        // Define the decimal format pattern
//
//        String formatted=decimalFormat.format(expectedPrice);
//        String expectedTotal = String.format("Total: $%s", formatted);
//        Assertions.assertEquals(expectedTotal, total, "Items total price not as expected");


        WebElement finishButton = driver.findElement(By.xpath(FINISH_BUTTON));
        finishButton.click();

        // Assert Items removed from Shopping Cart
        WebElement backToShoppingCart = driver.findElement(By.xpath("//a[@class=\"shopping_cart_link\"]"));
        backToShoppingCart.click();

        basket();

        Assertions.assertEquals(0, basket().size(), "Items count not as expected");
    }

    @Test
    public void userDetailsAdded_when_checkoutWithValidInformation() {

        add_Backpack_and_Tshirt_to_shopping_cart();

        // Fill Contact Details
        WebElement checkoutButton = driver.findElement(By.xpath(CHECKOUT_BUTTON));
        checkoutButton.click();

        // Fill Contact Details
        fillShippingDetails(FIRST_NAME, LAST_NAME, ZIP_CODE);

        WebElement firstName = driver.findElement(By.id(FIRST_NAME_BOX_ID));
        WebElement lastName = driver.findElement(By.id(LAST_NAME_BOX_ID));
        WebElement postCode = driver.findElement(By.id(POSTAL_CODE_BOX_ID));

        Assertions.assertTrue(firstName.getAttribute("value").equals(FIRST_NAME), "First name is not correct.");
        Assertions.assertTrue(lastName.getAttribute("value").equals(LAST_NAME), "Last name is not correct.");
        Assertions.assertTrue(postCode.getAttribute("value").equals(ZIP_CODE), "Post code name is not correct.");
        // Complete Order
        WebElement continueButton = driver.findElement(By.xpath(CONTINUE_BUTTON));
        continueButton.click();

        // Assert Details in next step
        String expectedURL = "https://www.saucedemo.com/checkout-step-two.html";
        String actualURL = driver.getCurrentUrl();

        Assertions.assertEquals(expectedURL, actualURL, "User wasn't redirected to the correct page.");
    }

}
