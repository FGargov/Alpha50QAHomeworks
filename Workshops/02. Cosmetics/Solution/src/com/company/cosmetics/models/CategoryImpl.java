package com.company.cosmetics.models;


import com.company.cosmetics.models.contracts.Category;
import com.company.cosmetics.models.contracts.Product;


import java.util.ArrayList;
import java.util.List;

public class CategoryImpl implements Category {
    //use constants for validations values

    private static final int MIN_CATEGORY_NAME_LENGTH = 2;
    private static final int MAX_CATEGORY_NAME_LENGTH = 15;
    private static final String CATEGORY_NAME_ERROR_MSG = String.format("Category name must be between %d and %d symbols", MIN_CATEGORY_NAME_LENGTH, MAX_CATEGORY_NAME_LENGTH);
    private String name;
    private List<Product> products;

    public CategoryImpl(String name) {
        setName(name);
        products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.length() < MIN_CATEGORY_NAME_LENGTH || name.length() > MAX_CATEGORY_NAME_LENGTH){
            throw new IllegalArgumentException(CATEGORY_NAME_ERROR_MSG);
        }
        this.name = name;
    }

    public List<Product> getProducts() {
        //todo why are we returning a copy? Replace this comment with explanation!
        //Prevent direct modification of the internal list.
        //Returning a copy of the list of products and keep the original products list safe.
        return new ArrayList<>(products);
    }

    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product can't be null.");
        }
        products.add(product);
    }

    public void removeProduct(Product product) {
        if (!products.contains(product)) {
            throw new IllegalArgumentException("This product is missing in this category.");
        }
        products.remove(product);
    }

    //The engine calls this method to print your category! You should not rename it!
    public String print() {
        if (products.size() == 0) {
            return String.format("#Category: %s\n" +
                    " #No product in this category", name);
        }

        //finish ProductBase class before implementing this method
        StringBuilder sb = new StringBuilder(String.format("#Category: %s\n",getName()));
        for (Product elements : products) {
            sb.append(elements.print());
        }
        return sb.toString();
    }

}
