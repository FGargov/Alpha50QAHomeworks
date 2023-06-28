package com.company.cosmetics.models;


import com.company.cosmetics.models.contracts.Category;
import com.company.cosmetics.models.contracts.Product;


import java.util.ArrayList;
import java.util.List;

public class CategoryImpl implements Category {

    private static final int MIN_NAME_LENGTH = 2;
    private static final int MAX_NAME_LENGTH = 15;
    public static final String NAME_LENGTH_ERROR = String.format(
            "Minimum category name’s length is %d symbols and maximum is %d symbols.", MIN_NAME_LENGTH, MAX_NAME_LENGTH);
    private String name;
    private final List<Product> products;

    public CategoryImpl(String name) {
        setName(name);
        products = new ArrayList<>();
    }

    private void setName(String name) {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR);
        } else {
            this.name = name;
        }
    }

    public String getName() {
        return name;
    }

    public List<Product> getProducts() {
        //ArrayList is always mutable, so if we need to return an ArrayList, but we don't want our private state to be modified,
        // we'll need a copy of the collection.
        return new ArrayList<>(products);
    }

    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null.");
        }
        this.products.add(product);
    }

    public void removeProduct(Product product) {
        if (!this.products.contains(product)) {
            throw new IllegalArgumentException("No such product.");
        }
        this.products.remove(product);
    }

    public String print() {
        StringBuilder result = new StringBuilder(String.format("#Category: %s\n", this.name));
        if (this.products.size() > 0) {
            for (Product product : this.products) {
                result.append(product.print());
            }
        } else {
            result.append(" #No product in this category");
        }
        return String.valueOf(result).trim();
    }

}
