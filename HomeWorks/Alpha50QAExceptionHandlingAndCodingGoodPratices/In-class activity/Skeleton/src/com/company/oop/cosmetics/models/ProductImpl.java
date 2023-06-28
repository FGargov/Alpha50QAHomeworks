package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.contracts.Product;

public class ProductImpl implements Product {

    private String name;
    private String brand;
    private double price;
    private final GenderType gender;

    public ProductImpl(String name, String brand, double price, GenderType gender) {
        setName(name);
        setBrand(brand);
        setPrice(price);
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name.length() < 3 || name.length() > 10) {
            throw new IllegalArgumentException("Product name should be between 3 and 10 characters.");
        }
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    private void setBrand(String brand) {
        if (brand.length() < 2 || brand.length() > 10) {
            throw new IllegalArgumentException("Product brand should be between 2 and 10 characters.");
        }
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    private void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Product price cannot be negative.");
        }
        this.price = price;
    }

    public GenderType getGender() {
        return gender;
    }

    @Override
    public String print() {
        return String.format(
                "#%s %s%n" +
                " #Price: $%.2f%n" +
                " #Gender: %s%n",
                name,
                brand,
                price,
                gender);
    }

}
