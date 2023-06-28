package com.company.oop.cosmetics.models.products;

import com.company.oop.cosmetics.models.common.GenderType;

public class Product {
    private static final int NAME_MIN_LENGTH = 3;
    private static final int NAME_MAX_LENGTH = 10;

    private static final String NAME_LENGTH_ERROR = String.format("Name can not be shorter than %d symbols and longer than %d",
            NAME_MIN_LENGTH, NAME_MAX_LENGTH);
    private static final int BRAND_MIN_LENGTH = 2;
    private static final int BRAND_MAX_LENGTH = 10;

    private static final String BRAND_LENGTH_ERROR = String.format("Brand name's length cannot be shorter than %d or longer %d symbols.",
            BRAND_MIN_LENGTH, BRAND_MAX_LENGTH);
    private double price;
    private String name;
    private String brand;
    private GenderType gender;

    public Product(String name, String brand, double price, GenderType gender) {
        this.setName(name);
        this.setBrand(brand);
        this.setPrice(price);
        this.setGender(gender);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.length() < NAME_MIN_LENGTH || name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("Name must be between 3 and 10 characters long.");
        }

        this.name = name;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        if (brand == null || brand.length() < BRAND_MIN_LENGTH || brand.length() > BRAND_MAX_LENGTH) {
            throw new IllegalArgumentException(BRAND_LENGTH_ERROR);
        }

        this.brand = brand;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("The price cannot be negative!");
        }

        this.price = price;
    }

    public GenderType getGender() {
        return this.gender;
    }

    public void setGender(GenderType gender) {
        if (!gender.equals(GenderType.MEN) && !gender.equals(GenderType.WOMAN) && !gender.equals(GenderType.UNISEX)) {
            throw new IllegalArgumentException("Invalid gender");
        }
        this.gender = gender;
    }

    public String print() {
        return String.format(
                "#%s %s%n#Price: $%.2f%n#Gender: %s%n===", name, brand, price, gender.toString()
        );

//          #MyMan Nivea
//          #Price: $10.99
//          #Gender: MEN
//          ===
    }
}
