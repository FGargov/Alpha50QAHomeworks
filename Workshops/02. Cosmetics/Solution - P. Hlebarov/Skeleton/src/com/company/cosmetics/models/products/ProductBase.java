package com.company.cosmetics.models.products;

import com.company.cosmetics.models.contracts.Product;
import com.company.cosmetics.models.common.GenderType;


public class ProductBase implements Product {
    private static final int MIN_NAME_LENGTH = 3;
    private static final int MAX_NAME_LENGTH = 10;
    private static final String NAME_ERROR_MESSAGE = String.format("Name must be between %d and %d characters", MIN_NAME_LENGTH, MAX_NAME_LENGTH);
    private static final int MIN_BRAND_LENGTH = 2;
    private static final int MAX_BRAND_LENGTH = 10;
    private static final String BRAND_ERROR_MESSAGE = String.format("Brand must be between %d and %d symbols", MIN_BRAND_LENGTH, MAX_BRAND_LENGTH);
    //Finish the class
    //What variables, what constants should you write here?
    //validate

    protected String name;
    protected String brand;
    protected double price;
    protected GenderType gender;

    protected ProductBase(String name, String brand, double price, GenderType gender) {
        setName(name);
        setBrand(brand);
        setPrice(price);
        this.gender = gender;
    }


    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(
                    NAME_ERROR_MESSAGE);
        }
        this.name = name;
    }


    @Override
    public String getBrand() {
        return this.brand;
    }


    private void setBrand(String brand) {
        if (brand == null || brand.length() < MIN_BRAND_LENGTH || brand.length() > MAX_BRAND_LENGTH) {
            throw new IllegalArgumentException(BRAND_ERROR_MESSAGE);
        }
        this.brand = brand;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    private void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
    }

    @Override
    public GenderType getGender() {
        throw new UnsupportedOperationException("Not implemented yet. ProductBase class");
    }

    private void setGender(GenderType gender) {
        this.gender = gender;
    }

    @Override
    public String print() {
    return String.format("#%s %s\n#Price: $%.2f\n#Gender: %s\n", getName(), getBrand(), getPrice(), getGender());
    }
}
