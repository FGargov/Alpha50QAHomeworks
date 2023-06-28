package com.company.cosmetics.models.products;

import com.company.cosmetics.models.contracts.Product;
import com.company.cosmetics.models.common.GenderType;

import java.util.Arrays;
import java.util.Locale;


public class ProductBase implements Product {

    private static final int MIN_NAME_LENGTH = 3;
    private static final int MAX_NAME_LENGTH = 10;
    private static final String NAME_LENGTH_ERROR = String.format(
            "Minimum product name’s length is %d symbols and maximum is %d symbols.", MIN_NAME_LENGTH, MAX_NAME_LENGTH);
    private static final int MIN_BRAND_LENGTH = 2;
    private static final int MAX_BRAND_LENGTH = 10;
    private static final String BRAND_LENGTH_ERROR = String.format(
            "Minimum brand name’s length is %d symbols and maximum is %d symbols", MIN_BRAND_LENGTH, MAX_BRAND_LENGTH);
    private static final String PRICE_ERROR = "Price cannot be negative.";

    private String name;
    private String brand;
    private double price;
    private GenderType gender;

    ProductBase(String name, String brand, double price, GenderType gender) {
        setName(name);
        setBrand(brand);
        setPrice(price);
        setGenderType(gender);
    }

    private void setName(String name) {
        if (name == null || (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH)) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR);
        }
        this.name = name;
    }

    private void setBrand(String brand) {
        if (brand == null || (brand.length() < MIN_BRAND_LENGTH || brand.length() > MAX_BRAND_LENGTH)) {
            throw new IllegalArgumentException(BRAND_LENGTH_ERROR);
        }
        this.brand = brand;
    }

    private void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException(PRICE_ERROR);
        }
        this.price = price;
    }

    private void setGenderType(GenderType gender) {
        this.gender = gender;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getBrand() {
        return this.brand;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public GenderType getGender() {
        return this.gender;
    }

    @Override
    public String print() {
        return String.format(Locale.US,"""
                        #%s %s
                         #Price: $%.2f
                         #Gender: %s
                         ===
                         """,
                this.getName(), this.getBrand(), this.getPrice(), this.getGender());
    }
}
