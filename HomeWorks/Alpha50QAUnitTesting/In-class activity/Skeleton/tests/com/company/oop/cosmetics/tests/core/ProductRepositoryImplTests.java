package com.company.oop.cosmetics.tests.core;

import com.company.oop.cosmetics.core.ProductRepositoryImpl;
import com.company.oop.cosmetics.core.contracts.ProductRepository;
import com.company.oop.cosmetics.exceptions.InvalidUserInputException;
import com.company.oop.cosmetics.models.GenderType;
import com.company.oop.cosmetics.models.contracts.Category;
import com.company.oop.cosmetics.models.contracts.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ProductRepositoryImplTests {
    private ProductRepository repository;
    @BeforeEach
    public void before() {
        repository = new ProductRepositoryImpl();
    }

    @Test
    public void constructor_Should_InitializeProducts() {
        Assertions.assertEquals(0, repository.getProducts().size());
    }

    @Test
    public void constructor_Should_InitializeCategories() {
        Assertions.assertEquals(0, repository.getCategories().size());
    }

    @Test
    public void getCategories_Should_ReturnCopyOfCollection() {
        repository.createCategory("Test123");
        List<Category> categories = repository.getCategories();
        Assertions.assertEquals(1, categories.size());
        categories.clear();
        Assertions.assertEquals(1, repository.getCategories().size());
    }

    @Test
    public void getProducts_Should_ReturnCopyOfCollection() {
        repository.createProduct("Dove Ultra", "Dove", 10, GenderType.MEN);
        List<Product> products = repository.getProducts();
        Assertions.assertEquals(1, products.size());
        products.clear();
        Assertions.assertEquals(1, repository.getProducts().size());
    }

    @Test
    public void categoryExists_Should_ReturnTrue_When_CategoryExists() {
        repository.createCategory("Test123");
        Assertions.assertTrue(repository.categoryExist("Test123"));
    }

    @Test
    public void categoryExists_Should_ReturnFalse_When_CategoryDoesNotExist() {
        Assertions.assertFalse(repository.categoryExist("Unknown category"));
    }

    @Test
    public void productExists_Should_ReturnTrue_When_ProductExists() {
        repository.createProduct("Dove Ultra", "Dove", 10, GenderType.MEN);
        Assertions.assertTrue(repository.productExist("Dove Ultra"));
    }

    @Test
    public void productExists_Should_ReturnFalse_When_ProductDoesNotExist() {
        Assertions.assertFalse(repository.productExist("Ultra Dove"));
    }

    @Test
    public void createProduct_Should_AddToProducts_When_ArgumentsAreValid() {
        repository.createProduct("Dove Ultra", "Dove", 10, GenderType.MEN);
        Assertions.assertTrue(repository.productExist("Dove Ultra"));
    }

    @Test
    public void createCategory_Should_AddToCategories_When_ArgumentsAreValid() {
        repository.createCategory("Test123");
        Assertions.assertTrue(repository.categoryExist("Test123"));
    }

    @Test
    public void findCategoryByName_Should_ReturnCategory_When_Exists() {
        repository.createCategory("Test123");
        Category category = repository.findCategoryByName("Test123");
        Assertions.assertNotNull(category);
        Assertions.assertEquals("Test123", category.getName());
    }

    @Test
    public void findCategoryByName_Should_ThrowException_When_DoesNotExist() {
        Assertions.assertThrows(InvalidUserInputException.class, () -> repository.findCategoryByName("Unknown category"));
    }

    @Test
    public void findProductByName_Should_ReturnCategory_When_Exists() {
        repository.createProduct("Dove Ultra", "Dove", 10, GenderType.MEN);
        Product product = repository.findProductByName("Dove Ultra");
        Assertions.assertNotNull(product);
        Assertions.assertEquals("Dove Ultra", product.getName());
    }

    @Test
    public void findProductByName_Should_ThrowException_When_DoesNotExist() {
        Assertions.assertThrows(InvalidUserInputException.class, () -> repository.findProductByName("Unknown product"));
    }
}
