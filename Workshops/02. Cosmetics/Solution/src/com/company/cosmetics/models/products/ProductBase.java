package com.company.cosmetics.models.products;

import com.company.cosmetics.models.contracts.Product;
import com.company.cosmetics.models.common.GenderType;

//Finish the class
//What variables, what constants should you write here?
//validate
public class ProductBase implements Product {
    private static final int MIN_NAME_LENGHT = 3;
    private static final int MAX_NAME_LENGHT = 10;
    private static final String SHAMPOO_NAME_LENGHT_MSG = String.format("Shampoo name must be between %d and %d symbols.", MIN_NAME_LENGHT, MAX_NAME_LENGHT);
    private static final int MIN_BRAND_LENGHT = 2;
    private static final int MAX_BRAND_LENGTH = 10;
    private static final String BRAND_NAME_MSG = String.format("Brand name must be between %d and %d symbols", MIN_BRAND_LENGHT, MAX_NAME_LENGHT);
    private static final double MIN_PRICE = 0.00;
    private static final String PRICE_MSG = String.format("Price cannot be less than %.2f", MIN_PRICE);

    private String name;
    private String brand;
    private double price;
    public GenderType gender;

    protected ProductBase(String name, String brand, double price, GenderType gender) {
        setName(name);
        setBrand(brand);
        setPrice(price);
        this.gender = gender;
    }

    private void setName(String name) {
        if(name == null || name.length() < MIN_NAME_LENGHT || name.length() > MAX_NAME_LENGHT) {
            throw new IllegalArgumentException(SHAMPOO_NAME_LENGHT_MSG);
        }
        this.name = name;
    }

    private void setBrand(String brand) {
        if (brand == null || brand.length() < MIN_BRAND_LENGHT || brand.length() > MAX_BRAND_LENGTH) {
            throw new IllegalArgumentException(BRAND_NAME_MSG);
        }
        this.brand = brand;
    }

    private void setPrice(double price) {
        if(price < MIN_PRICE){
            throw new IllegalArgumentException(PRICE_MSG);
        }
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public GenderType getGender() {
        return  gender;
    }

    @Override
    public String print() {
        return String.format(
                (" #%s %s\n" +
                    " #Price: $%.2f\n" +
                    " #Gender: %s"), getName(), getBrand(), getPrice(), getGender());
    }
}
