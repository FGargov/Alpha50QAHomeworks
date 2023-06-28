package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.contracts.Product;
import com.company.oop.cosmetics.models.contracts.Category;
import com.company.oop.cosmetics.models.exceptions.DuplicateNameException;
import com.company.oop.cosmetics.models.exceptions.InvalidInputException;

import java.util.ArrayList;
import java.util.List;

public class CategoryImpl implements Category {
    private List<String> categoryNames;
    private String name;
    private final List<Product> products;

    public CategoryImpl(String name) {
        setName(name);
        products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name.length() < 3 || name.length() > 10) {
            throw new InvalidInputException("Category name should be between 3 and 10 symbols.");
        }
        if (isDuplicateName(name)) {
            throw new DuplicateNameException("Category name already exists in the system.");
        }
        this.name = name;
    }

    private boolean isDuplicateName(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public String print() {
        if (products.size() == 0) {
            return String.format(
                    "#Category: %s%n" +
                    " #No product in this category",
                    name);
        }

        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append(String.format("#Category: %s%n", name));

        for (Product product : products) {
            strBuilder.append(product.print());
            strBuilder.append(String.format(" ===%n"));
        }

        return strBuilder.toString();
    }

}
