package com.company.oop.cosmetics.tests.models;

import com.company.oop.cosmetics.exceptions.InvalidUserInputException;
import com.company.oop.cosmetics.models.GenderType;
import com.company.oop.cosmetics.models.ProductImpl;
import com.company.oop.cosmetics.models.contracts.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductImplTests {
    @Test
    public void constructor_Should_InitializeName_When_ArgumentsAreValid() {
        String name = "Dove Ultra";

        Product product = new ProductImpl("Dove Ultra", "Dove", 10, GenderType.MEN);

        Assertions.assertEquals(name, product.getName());
    }

    @Test
    public void constructor_Should_InitializeBrand_When_ArgumentsAreValid() {
        String brand = "Dove";

        Product product = new ProductImpl("Dove Ultra", "Dove", 10, GenderType.MEN);

        Assertions.assertEquals(brand, product.getBrand());
    }

    @Test
    public void constructor_Should_InitializePrice_When_ArgumentsAreValid() {
        double price = 10;

        Product product = new ProductImpl("Dove Ultra", "Dove", 10, GenderType.MEN);

        Assertions.assertEquals(price, product.getPrice());
    }

    @Test
    public void constrictor_Should_InitializeGender_When_ArgumentsAreValid() {
        GenderType gender = GenderType.MEN;

        Product product = new ProductImpl("Dove Ultra", "Dove", 10, GenderType.MEN);

        Assertions.assertEquals(gender, product.getGender());
    }

    @Test
    public void constructor_Should_ThrowException_When_NameIsShorterThanExpected() {
        Assertions.assertThrows(InvalidUserInputException.class, () -> new ProductImpl("DU", "Dove", 10, GenderType.MEN));
    }

    @Test
    public void constructor_Should_ThrowException_When_NameIsLongerThanExpected() {
        Assertions.assertThrows(InvalidUserInputException.class, () -> new ProductImpl("Dove Ultra Dove Ultra", "Dove", 10, GenderType.MEN));
    }

    @Test
    public void constructor_Should_ThrowException_When_BrandIsShorterThanExpected() {
        Assertions.assertThrows(InvalidUserInputException.class, () -> new ProductImpl("Dove Ultra", "D", 10, GenderType.MEN));
    }
    @Test
    public void constructor_Should_ThrowException_When_BrandIsLongerThanExpected() {
        Assertions.assertThrows(InvalidUserInputException.class, () -> new ProductImpl("Dove Ultra", "Dove Dove Dove", 10, GenderType.MEN));
    }

    @Test
    public void constructor_Should_ThrowException_When_PriceIsNegative() {
        Assertions.assertThrows(InvalidUserInputException.class, () ->  new ProductImpl("Dove Ultra", "Dove Dove Dove", -1, GenderType.MEN));
    }

    @Test
    public void print_Should_ReturnProductDetailsInCorrectFormat() {
        Product product = new ProductImpl("Dove Ultra", "Dove", 10, GenderType.MEN);

        String expected = String.format(
                "#%s %s%n" +
                        " #Price: $%.2f%n" +
                        " #Gender: %s%n",
                product.getName(),
                product.getBrand(),
                product.getPrice(),
                product.getGender());

        Assertions.assertEquals(expected, product.print());
    }
}
