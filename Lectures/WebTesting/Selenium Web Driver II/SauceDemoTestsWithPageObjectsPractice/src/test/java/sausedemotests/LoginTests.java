package sausedemotests;

import core.BaseTest;
import org.junit.jupiter.api.*;
import pages.InventoryPage;

public class LoginTests extends BaseTest {

    @Test
    public void userAuthenticated_when_validCredentialsProvided() {
        loginPage.navigate();
        loginPage.fillLoginForm("standard_user", "secret_sauce");

        inventoryPage.waitForPageTitle();

        //Assertions.assertEquals(inventoryPage.pageUrl, driver.getCurrentUrl());
        inventoryPage.assertNavigate();
    }
}
