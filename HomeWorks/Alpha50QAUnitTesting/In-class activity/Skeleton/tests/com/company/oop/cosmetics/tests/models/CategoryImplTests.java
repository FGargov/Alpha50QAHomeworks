package com.company.oop.cosmetics.tests.models;

import com.company.oop.cosmetics.exceptions.InvalidUserInputException;
import com.company.oop.cosmetics.models.CategoryImpl;
import com.company.oop.cosmetics.models.GenderType;
import com.company.oop.cosmetics.models.ProductImpl;
import com.company.oop.cosmetics.models.contracts.Category;
import com.company.oop.cosmetics.models.contracts.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CategoryImplTests {

    @Test
    public void constructor_Should_InitializeName_When_ArgumentsAreValid() {
        //Arrange
        Category category = new CategoryImpl("Shampoos");
        //Act & Assert
        Assertions.assertEquals("Shampoos", category.getName());
    }

    @Test
    public void constructor_Should_InitializeProducts_When_ArgumentsAreValid() {
        //Arrange
        Category category = new CategoryImpl("Shampoos");
        //Act & Assert
        Assertions.assertTrue(category.getProducts().isEmpty());
    }

    @Test
    public void constructor_Should_ThrowException_When_NameIsShorterThanExpected() {
        // Arrange, Act & Assert
        Assertions.assertThrows(InvalidUserInputException.class, () -> new CategoryImpl("Sh"));
    }

    @Test
    public void constructor_Should_ThrowException_When_NameIsLongerThanExpected() {
        // Arrange, Act & Assert
        Assertions.assertThrows(InvalidUserInputException.class, () -> new CategoryImpl("ShampooShampoo"));
    }

    @Test
    public void addProduct_Should_AddProductToList() {
        //Arrange
        Category category = new CategoryImpl("Shampoos");
        Product product = new ProductImpl("Dove Ultra", "Dove", 10, GenderType.MEN);

        //Act
        category.addProduct(product);

        //Assert
        Assertions.assertTrue(category.getProducts().contains(product));
    }

    @Test
    public void removeProduct_Should_RemoveProductFromList_When_ProductExist() {
        //Arranges
        Category category = new CategoryImpl("Shampoos");
        Product product = new ProductImpl("Dove Ultra", "Dove", 10, GenderType.MEN);
        category.addProduct(product);

        //Act
        category.removeProduct(product);

        //Assert
        Assertions.assertFalse(category.getProducts().contains(product));
    }

    @Test
    public void removeProduct_should_notRemoveProductFromList_when_productNotExist() {
        //Arranges
        Category category = new CategoryImpl("Shampoos");
        Product product = new ProductImpl("Dove Ultra", "Dove", 10, GenderType.MEN);

        //Act
        category.removeProduct(product);

        //Assert
        Assertions.assertFalse(category.getProducts().contains(product));
    }

    /*@Test
    public void print_Should_ReturnCategoryDetailsInCorrectFormat() {
        Category category = new CategoryImpl("Shampoos");
        StringBuilder stringBuilder = new StringBuilder();

        //sb.append("#Category: Shampoos\n").append(" #No product in this category");
        if (category.getProducts().size() == 0) {
            stringBuilder.append(String.format("#Category: %s\n", category.getName())).append(" #No product in this category");
        }

        Assertions.assertEquals(stringBuilder.toString(), category.print());
    }*/
}
