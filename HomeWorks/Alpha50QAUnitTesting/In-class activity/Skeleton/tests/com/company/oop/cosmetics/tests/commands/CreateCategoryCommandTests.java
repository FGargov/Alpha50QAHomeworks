package com.company.oop.cosmetics.tests.commands;

import com.company.oop.cosmetics.commands.CreateCategoryCommand;
import com.company.oop.cosmetics.core.ProductRepositoryImpl;
import com.company.oop.cosmetics.core.contracts.ProductRepository;
import com.company.oop.cosmetics.exceptions.DuplicateEntityException;
import com.company.oop.cosmetics.exceptions.InvalidUserInputException;
import com.company.oop.cosmetics.models.GenderType;
import com.company.oop.cosmetics.models.contracts.Category;
import com.company.oop.cosmetics.models.contracts.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CreateCategoryCommandTests {
    private ProductRepository productRepository;
    private CreateCategoryCommand createCategoryCommand;

    @BeforeEach
    public void before() {
        productRepository = new ProductRepositoryImpl();
        createCategoryCommand = new CreateCategoryCommand(productRepository);
    }

    @Test
    public void execute_Should_AddNewCategoryToRepository_When_ValidParameters() {
        String categoryName = "Test123";

        String result = createCategoryCommand.execute(Arrays.asList(categoryName));

        Assertions.assertTrue(productRepository.categoryExist(categoryName));
        Assertions.assertEquals(String.format("Category with name %s was created!", categoryName), result);
    }

    @Test
    public void execute_Should_ThrowException_When_MissingParameters() {
        Assertions.assertThrows(InvalidUserInputException.class, () -> createCategoryCommand.execute(Collections.emptyList()));
    }

    @Test
    public void execute_Should_ThrowException_When_DuplicateCategoryName() {
        String categoryName = "Test123";

        productRepository.createCategory(categoryName);

        Assertions.assertThrows(DuplicateEntityException.class, () -> createCategoryCommand.execute(Arrays.asList(categoryName)));
    }

}
