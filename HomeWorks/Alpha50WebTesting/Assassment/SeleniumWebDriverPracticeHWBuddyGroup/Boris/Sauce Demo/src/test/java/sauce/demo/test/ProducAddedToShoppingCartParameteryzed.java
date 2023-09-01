package sauce.demo.test;

import core.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebElement;


import static org.example.Constans.*;

public class ProducAddedToShoppingCartParameteryzed extends BaseTest {

    @ParameterizedTest
    @CsvSource({ "Sauce Labs Backpack,$29.99,carry.allTheThings() with the sleek, " +
            "streamlined Sly Pack that melds uncompromising " +
            "style with unequaled laptop and tablet protection.","Sauce Labs Bolt T-Shirt,$15.99,Get your testing superhero " +
            "on with the Sauce Labs bolt T-shirt. " +
            "From American Apparel, 100% ringspun " +
            "combed cotton, heather gray with red bolt."})
    public void productAddedToShoppingCar_when_addToCart(String tittle,String price,String description) {
        add_Backpack_and_Tshirt_to_shopping_cart();

        WebElement backpack=getProductByTitle(tittle);

        // Assert Items and Totals
        Assertions.assertTrue(backpack.getText().contains(tittle),"Item tittle is not correct.");
        Assertions.assertTrue(backpack.getText().contains(price),"Item price is not correct.");
        Assertions.assertTrue(backpack.getText().contains(description),"Item description is wrong.");




    }

}
