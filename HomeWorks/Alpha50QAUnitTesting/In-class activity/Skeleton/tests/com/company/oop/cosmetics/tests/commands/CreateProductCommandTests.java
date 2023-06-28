package com.company.oop.cosmetics.tests.commands;

import com.company.oop.cosmetics.commands.CreateProductCommand;
import com.company.oop.cosmetics.core.ProductRepositoryImpl;
import com.company.oop.cosmetics.core.contracts.ProductRepository;
import com.company.oop.cosmetics.exceptions.DuplicateEntityException;
import com.company.oop.cosmetics.exceptions.InvalidUserInputException;
import com.company.oop.cosmetics.models.GenderType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class CreateProductCommandTests {
    private ProductRepository productRepository;
    private CreateProductCommand command;

    @BeforeEach
    public void before() {
        productRepository = new ProductRepositoryImpl();
        command = new CreateProductCommand(productRepository);
    }

    @Test
    public void execute_Should_ThrowException_When_LessParametersArePassed() {
        Assertions.assertThrows(InvalidUserInputException.class, () -> command.execute(Arrays.asList("one", "two", "three", "four")));
    }

    @Test
    public void execute_Should_ThrowException_When_MoreParametersArePassed() {
        Assertions.assertThrows(InvalidUserInputException.class, () -> command.execute(Collections.emptyList()));
    }

    @Test
    public void execute_Should_ThrowException_When_ProductAlreadyExists() {
        productRepository.createProduct("Dove Ultra", "Dove", 10, GenderType.MEN);
        Assertions.assertThrows(DuplicateEntityException.class, () -> command.execute(Arrays.asList("Dove Ultra", "Dove", "10", "Men")));
    }

    @Test
    public void execute_Should_ThrowException_When_PriceIsNotNumber() {
        Assertions.assertThrows(InvalidUserInputException.class, () -> command.execute(Arrays.asList("Dove Ultra", "Dove", "Invalid", "Men")));
    }

    @Test
    public void execute_Should_ThrowException_When_GenderIsNotValid() {
        Assertions.assertThrows(InvalidUserInputException.class, () -> command.execute(Arrays.asList("Dove Ultra", "Dove", "10", "Invalid")));
    }

    @Test
    public void execute_Should_CreateProduct_When_ValidArgumentsArePassed() {
        String productName = "Dove Ultra";

        Assertions.assertEquals(String.format("Product with name %s was created!", productName),
                command.execute(Arrays.asList("Dove Ultra", "Dove", "10", "Men")));
        Assertions.assertTrue(productRepository.productExist(productName));
    }
}
