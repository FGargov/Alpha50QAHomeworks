package com.company.cosmetics.models;


import com.company.cosmetics.models.contracts.Category;
import com.company.cosmetics.models.contracts.Product;


import java.util.ArrayList;
import java.util.List;

public class CategoryImpl implements Category {
    public static final int MIN_NAME_LENGHT = 3;
    public static final int MAX_NAME_LENGHT = 15;
    public static final String NAME_ERROR = "Invalid name.";
    //use constants for validations values

    private String name;
    private List<Product> products=new ArrayList<>();

    public CategoryImpl(String name) {
        setName(name);
    }

    private void setName(String name) {
        nameValidation(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Product> getProducts() {
        //todo why are we returning a copy? Replace this comment with explanation!
        return new ArrayList<>(products);
    }


    public void addProduct(Product product) {
        productValidation(product);
        products.add(product);
    }

    public void removeProduct(Product product) {
        removingProductValidation(product);
        products.remove(product);
    }

    private static void nameValidation(String name) {
        if (name == null || name.length() < MIN_NAME_LENGHT || name.length() > MAX_NAME_LENGHT) {
            throw new IllegalArgumentException(NAME_ERROR);
        }
    }

    private void removingProductValidation(Product product) {
        if (!products.contains(product)) {
            throw new ExceptionInInitializerError("Product is not in this category.");
        }
    }

    private static void productValidation(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product can't be null.");
        }
    }


    //The engine calls this method to print your category! You should not rename it!
    public String print() {
        if (products.size() == 0) {
            return String.format("#Category: %s\n" +
                    " #No product in this category", name);
        }
            StringBuilder output = new StringBuilder(String.format("#Category: %s \n",getName()));
            for (Product elements : products
            ) {
                output.append(elements.print());
            }

            String test=output.toString();
            return  test;  //finish ProductBase class before implementing this method
        }
    }
