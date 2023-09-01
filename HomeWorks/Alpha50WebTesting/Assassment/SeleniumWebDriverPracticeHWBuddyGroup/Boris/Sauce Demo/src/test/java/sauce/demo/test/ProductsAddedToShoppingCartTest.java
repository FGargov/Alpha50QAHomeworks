package sauce.demo.test;

import core.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.WebElement;

import static org.example.Constans.*;


public class ProductsAddedToShoppingCartTest extends BaseTest {


    @Test
    public void productAddedToShoppingCar_when_addToCart() {
        add_Backpack_and_Tshirt_to_shopping_cart();

        WebElement backpack=getProductByTitle(BACKPACK_TITTLE);
        WebElement tShirt=getProductByTitle(T_SHIRT_TITTLE);


        // Assert Items and Totals
        Assertions.assertTrue(backpack.getText().contains(BACKPACK_TITTLE),"Item tittle is not correct.");
        Assertions.assertTrue(backpack.getText().contains(BACKPACK_PRICE),"Item price is not correct.");
        Assertions.assertTrue(backpack.getText().contains(BACKPACK_DESCRIPTION),"Item description is wrong.");

        Assertions.assertTrue(tShirt.getText().contains(T_SHIRT_TITTLE),"Item tittle is not correct.");
        Assertions.assertTrue(tShirt.getText().contains(T_SHIRT_VALUE),"Item price is not correct.");
        Assertions.assertTrue(tShirt.getText().contains(T_SHIRT_DESCRIPTION),"Item description is wrong.");
    }
}
