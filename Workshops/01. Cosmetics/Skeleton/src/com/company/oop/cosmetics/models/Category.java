package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.products.Product;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private static final int MIN_CATEGORY_NAME = 2;
    private static final int MAX_CATEGORY_NAME = 15;
    private static final String CATEGORY_NAME_ERROR = String.format("Minimum category name’s length is %d symbols and maximum is %d symbols"
            , MIN_CATEGORY_NAME, MAX_CATEGORY_NAME);
    private String name;
    private List<Product> products;
    
    public Category(String name) {
        this.setName(name);
        products = new ArrayList<>();
    }
    
    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.length() < MIN_CATEGORY_NAME || name.length() > MAX_CATEGORY_NAME) {
            throw new IllegalArgumentException(CATEGORY_NAME_ERROR);
        }
        this.name = name;
    }
    
    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null.");
        }

        this.products.add(product);
    }
    
    public void removeProduct(Product product) {
       if (product == null) {
           throw new IllegalArgumentException("Product cannot be null.");
       }
        if (!this.products.contains(product)){
            throw new IllegalArgumentException("Product not found in this category.");
        }

        this.products.remove(product);
    }
    
    public String print() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("#Category: %s%n", name));
        for (Product product : products) {
            sb.append(product.print());
        }
        if (products.isEmpty()) {
            sb.append("#No product in this category");
        }
        return sb.toString();
    }
}
