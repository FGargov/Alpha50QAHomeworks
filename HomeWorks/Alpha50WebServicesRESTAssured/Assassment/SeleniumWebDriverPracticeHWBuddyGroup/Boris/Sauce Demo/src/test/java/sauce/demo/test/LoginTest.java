package sauce.demo.test;

import core.BaseTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.example.Xpaths.INVERTORY_PAGE_TITTLE;

public class LoginTest extends BaseTest {



    @Test
    public void userAuthenticated_when_validCredentialsProvided(){

        String actualURL=driver.getCurrentUrl();
        String expectedURL="https://www.saucedemo.com/inventory.html";
        String expectedPageTittle="Swag Labs";



        WebElement inventoryPageTitle = driver.findElement(By.xpath(INVERTORY_PAGE_TITTLE));
            wait.until(ExpectedConditions.visibilityOf(inventoryPageTitle));

        // Add Assert
        Assertions.assertEquals(expectedURL,actualURL,"User is not authenticated.");
        Assertions.assertEquals(expectedPageTittle,
                driver.getTitle(),
                "Page tittle is different than expected.");
    }








}
