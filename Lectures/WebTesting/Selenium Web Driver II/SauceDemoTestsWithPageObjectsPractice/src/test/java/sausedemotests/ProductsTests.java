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

        shoppingCartPage.assertNavigate();

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

        checkYourInformationPage.assertNavigate();

        // fill form
        checkYourInformationPage.fillShippingDetails("Fname", "lname", "zip");
        checkYourInformationPage.continueButtonClick();

        var items = shoppingCartPage.getItems();
        Assertions.assertEquals(2, items.size(), "Items count not as expected");

        var actualTotalPrice = checkoutOverviewPage.getTotalPriceNumber();
        double expectedTotalPrice = 29.99 + 15.99 + 3.68;

        getDecimalSeparator();

        Assertions.assertEquals(2, items.size(), "Items count not as expected");
        Assertions.assertEquals(backpackTitle, items.get(0).getText(), "Item title not as expected");
        Assertions.assertEquals(shirtTitle, items.get(1).getText(), "Item title not as expected");
        Assertions.assertEquals(expectedTotalPrice, actualTotalPrice, "Items total price not as expected");

        //        refreshSauceDemoWebsite();
    }

    @Test
    public void orderCompleted_when_addProduct_and_checkout_withConfirm() {
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


        checkoutCompletePage.clickFinishButton();
        checkoutCompletePage.assertNavigate();
        Assertions.assertEquals("Checkout: Complete!", checkoutCompletePage.getCheckoutCompleteText(),
                "Checkout is not successful");

        // Assert Items removed from Shopping Cart
        //inventoryPage.clickShoppingCartLink();

        if (inventoryPage.getCardBadge().isEmpty()) {
            Assertions.assertTrue(true, "Shopping cart is empty");
        } else {
            Assertions.fail("Shopping cart is not empty");
        }
    }
}