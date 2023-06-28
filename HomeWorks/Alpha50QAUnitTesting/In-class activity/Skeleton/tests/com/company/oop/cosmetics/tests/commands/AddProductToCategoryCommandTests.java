package com.company.oop.cosmetics.tests.commands;

import com.company.oop.cosmetics.commands.AddProductToCategoryCommand;
import com.company.oop.cosmetics.core.ProductRepositoryImpl;
import com.company.oop.cosmetics.core.contracts.ProductRepository;
import com.company.oop.cosmetics.exceptions.InvalidUserInputException;
import com.company.oop.cosmetics.models.CategoryImpl;
import com.company.oop.cosmetics.models.GenderType;
import com.company.oop.cosmetics.models.ProductImpl;
import com.company.oop.cosmetics.models.contracts.Category;
import com.company.oop.cosmetics.models.contracts.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AddProductToCategoryCommandTests {
    private ProductRepository productRepository;
    private AddProductToCategoryCommand command;

    @BeforeEach
    public void before() {
        productRepository = new ProductRepositoryImpl();
        command = new AddProductToCategoryCommand(productRepository);
    }

    @Test
    public void testExecute_Should_AddProductToCategory_When_ValidParameters() {
        //Arrange
        Category category = new CategoryImpl("Test123");
        productRepository.createCategory(category.getName());

        Product product = new ProductImpl("Dove Ultra", "Dove", 10, GenderType.MEN);
        productRepository.createProduct(product.getName(), product.getBrand(), product.getPrice(), product.getGender());

        List<String> parameters = Arrays.asList(category.getName(), product.getName());

        //Act
        String result = command.execute(parameters);

        //Assert
        Assertions.assertEquals(String.format("Product %s added to category %s!", product.getName(), category.getName()), result);
      //  Assertions.assertEquals(String.format("Product %s added to category %s!", parameters.get(1), parameters.get(0)), result);
    }

    @Test
    public void testExecute_Should_ThrowException_When_MissingParameters() {
        Assertions.assertThrows(InvalidUserInputException.class, () -> command.execute(Collections.emptyList()));
    }
}
