package sausedemotests;

import core.BaseTest;
import org.junit.jupiter.api.*;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;


public class ProductsTests extends BaseTest {
    String backpackTitle = "Sauce Labs Backpack";
    String shirtTitle = "Sauce Labs Bolt T-Shirt";

    @BeforeEach
    public void beforeTest() {
        loginPage.navigate();
        loginPage.fillLoginForm("standard_user", "secret_sauce");
    }

    @Test
    public void productAddedToShoppingCart_when_addToCart(){
        inventoryPage.addProductByTitle(backpackTitle);
        inventoryPage.addProductByTitle(shirtTitle);
        inventoryPage.clickShoppingCartLink();


        // Assert Items and Totals
        var items = shoppingCartPage.getItems();

        Assertions.assertEquals(2, items.size(), "Items count not as expected");

        Assertions.assertEquals(backpackTitle, items.get(0).getText(), "Item title not as expected");
        Assertions.assertEquals(shirtTitle, items.get(1).getText(), "Item title not as expected");

        //        refreshSauceDemoWebsite();
    }

    @Test
    public void userDetailsAdded_when_checkoutWithValidInformation(){
        inventoryPage.addProductByTitle(backpackTitle);
        inventoryPage.addProductByTitle(shirtTitle);
        inventoryPage.clickShoppingCartLink();

        // Assert Items and Totals
        shoppingCartPage.checkoutButtonClick();

        // fill form
        checkYourInformationPage.fillShippingDetails("Fname", "lname", "zip");
        checkYourInformationPage.continueButtonClick();

        var items = shoppingCartPage.getItems();
        Assertions.assertEquals(2, items.size(), "Items count not as expected");

        var actualTotalPrice = checkoutOverviewPage.getTotalPriceNumber();
        double expectedTotalPrice = 29.99 + 15.99 + 3.68;

        // Fix a problem with the comma separator in order to compare price correctly
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        symbols.setDecimalSeparator('.');
        symbols.setGroupingSeparator(',');
        DecimalFormat decimalFormat = new DecimalFormat("###,##0.00", symbols);

        Assertions.assertEquals(2, items.size(), "Items count not as expected");
        Assertions.assertEquals(backpackTitle, items.get(0).getText(), "Item title not as expected");
        Assertions.assertEquals(shirtTitle, items.get(1).getText(), "Item title not as expected");
        Assertions.assertEquals(expectedTotalPrice, actualTotalPrice, "Items total price not as expected");

        //        refreshSauceDemoWebsite();
    }

    /*@Test
    public void orderCompleted_when_addProduct_and_checkout_withConfirm(){
        // Add Backpack and T-shirt to shopping cart
        addProductsToShoppingCart(backpackTitle, shirtTitle);

        // Click on shopping Cart
        driver.findElement(By.className("shopping_cart_link")).click();

        // Fill Contact Details
        driver.findElement(By.id("checkout")).click();

        fillShippingDetails("FirstName", "LastName", "zip Code");
        driver.findElement(By.id("continue")).click();

        // Complete Order
        driver.findElement(By.id("finish")).click();

        // Assert Complete Message
        WebElement checkoutCompleteText = driver.findElement(By.xpath("//span[@class='title']"));
        Assertions.assertEquals("Checkout: Complete!", checkoutCompleteText.getText(),
                "Checkout is not successful");

        // Assert Items removed from Shopping Cart
        driver.findElement(By.className("shopping_cart_link")).click();

        List<WebElement> cartBadge = driver.findElements(By.className("shopping_cart_badge"));
        if (cartBadge.isEmpty()) {
            Assertions.assertTrue(true, "Shopping cart is empty");
        } else {
            Assertions.fail("Shopping cart is not empty");
        }

        //        refreshSauceDemoWebsite();
    }*/
}