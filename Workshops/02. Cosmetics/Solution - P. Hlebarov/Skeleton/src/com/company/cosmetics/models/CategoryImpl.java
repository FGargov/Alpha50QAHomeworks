package com.company.cosmetics.models;


import com.company.cosmetics.models.contracts.Category;
import com.company.cosmetics.models.contracts.Product;
import com.company.cosmetics.models.products.ProductBase;


import java.util.ArrayList;
import java.util.List;

public class CategoryImpl implements Category {
    private static final int MIN_CATEGORY_NAME_LENGTH = 2;
    private static final int MAX_CATEGORY_NAME_LENGTH = 15;
    private static final String CATEGORY_NAME_ERROR_MESSAGE = String.format("Category name must be between %d and %d symbols", MIN_CATEGORY_NAME_LENGTH, MAX_CATEGORY_NAME_LENGTH);
    //use constants for validations values

    private String name;
    private final List<Product> products;

    public CategoryImpl(String name) {
        setName(name);
        products = new ArrayList<>();    //initialize the collection
    }

    public String getName() {
        return this.name;
    }

    public List<Product> getProducts() {
        //In order to keep the original products list safe, we initiate and return a copy of it.
        return new ArrayList<>(products);
    }

    private void setName(String name) {
        if (name == null || name.length() < MIN_CATEGORY_NAME_LENGTH || name.length() > MAX_CATEGORY_NAME_LENGTH) {
            throw new IllegalArgumentException(CATEGORY_NAME_ERROR_MESSAGE);
        }
        this.name = name;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        if (products.contains(product) || product!= null) {
            products.remove(product);          //validate
        }
    }

    //The engine calls this method to print your category! You should not rename it!
    public String print() {
        if (products.size() == 0) {
            return String.format("#Category: %s\n" +
                    " #No product in this category", name);
        }
        //finish ProductBase class before implementing this method
        StringBuilder sb = new StringBuilder();
        for (Product product : products) {
            sb.append( String.format("#Category: %s\n%s\n===", getName(), product.print()));

        }
        return sb.toString();
    }
}
