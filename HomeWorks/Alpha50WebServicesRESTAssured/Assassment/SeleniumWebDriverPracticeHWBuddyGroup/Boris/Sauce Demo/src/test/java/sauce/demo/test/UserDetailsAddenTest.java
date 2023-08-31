package sauce.demo.test;

import core.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.example.Constans.*;
import static org.example.Xpaths.CHECKOUT_BUTTON;
import static org.example.Xpaths.CONTINUE_BUTTON;
import static org.example.WebElementsIDs.*;

public class UserDetailsAddenTest extends BaseTest {

    @Test
    public void userDetailsAdded_when_checkoutWithValidInformation() {
        add_Backpack_and_Tshirt_to_shopping_cart();

        // Fill Contact Details
        WebElement checkoutButton = driver.findElement(By.xpath(CHECKOUT_BUTTON));
        checkoutButton.click();

        // Fill Contact Details
        fillShippingDetails(FIRST_NAME, LAST_NAME, ZIP_CODE);


        WebElement firstName=driver.findElement(By.id(FIRST_NAME_BOX_ID));
        WebElement lastName=driver.findElement(By.id(LAST_NAME_BOX_ID));
        WebElement postCode=driver.findElement(By.id(POSTAL_CODE_BOX_ID));

        Assertions.assertTrue(firstName.getAttribute("value").equals(FIRST_NAME),"First name is not correct.");
        Assertions.assertTrue(lastName.getAttribute("value").equals(LAST_NAME),"Last name is not correct.");
        Assertions.assertTrue(postCode.getAttribute("value").equals(ZIP_CODE),"Post code name is not correct.");
        // Complete Order
        WebElement continueButton = driver.findElement(By.xpath(CONTINUE_BUTTON));
        continueButton.click();

        // Assert Details in next step
        String expectedURL = "https://www.saucedemo.com/checkout-step-two.html";
        String actualURL = driver.getCurrentUrl();

        Assertions.assertEquals(expectedURL,actualURL,"User wasn't redirected to the correct page.");
    }
}
