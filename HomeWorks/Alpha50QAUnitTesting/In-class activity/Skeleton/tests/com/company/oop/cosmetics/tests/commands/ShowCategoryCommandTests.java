package com.company.oop.cosmetics.tests.commands;

import com.company.oop.cosmetics.commands.ShowCategoryCommand;
import com.company.oop.cosmetics.core.ProductRepositoryImpl;
import com.company.oop.cosmetics.core.contracts.ProductRepository;
import com.company.oop.cosmetics.exceptions.InvalidUserInputException;
import com.company.oop.cosmetics.models.CategoryImpl;
import com.company.oop.cosmetics.models.contracts.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class ShowCategoryCommandTests {
    private ProductRepository productRepository;
    private ShowCategoryCommand command;

    @BeforeEach
    public void before() {
        productRepository = new ProductRepositoryImpl();
        command = new ShowCategoryCommand(productRepository);
    }

    @Test
    public void testExecute_Should_ReturnCategoryPrint_When_ValidParameters() {
        Category category = new CategoryImpl("Test123");
        productRepository.createCategory(category.getName());

        List<String> parameters = Arrays.asList(category.getName());
        String result = command.execute(parameters);

        Assertions.assertEquals(category.print(), result);
    }

    @Test
    public void testExecute_Should_ThrowException_When_CategoryDoesNotExist() {
        Assertions.assertThrows(InvalidUserInputException.class, () -> command.execute(Collections.emptyList()));
    }
}
