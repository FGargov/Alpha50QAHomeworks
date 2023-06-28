package com.company.cosmetics.models.products;

import com.company.cosmetics.models.contracts.Product;
import com.company.cosmetics.models.common.GenderType;

public class ProductBase implements Product {
    private static final int MIN_NAME_LENGTH = 3;
    private static final int MAX_NAME_LENGTH = 10;
    private static final String NAME_LENGTH_ERROR = String.format(
            "Name can not be shorter than %d symbols and longer than %d",
            MIN_NAME_LENGTH, MAX_NAME_LENGTH);
    public static final String PRICE_ERROR = "Price cannot be negative";
    public static final int MIN_BRAND_LENGTH = 2;
    public static final int MAX_BRAND_LENGTH = 10;
    public static final String BRAND_LENGHT_ERROR =
            String.format("Brand name's length cannot be shorter than %d or longer %d symbols.",
            MIN_BRAND_LENGTH, MAX_BRAND_LENGTH);

    //Finish the class
    //What variables, what constants should you write here?
    //validate
   private String name;
   private String brand;
   private Double price;
   private GenderType gender;

    
    ProductBase(String name,String brand,Double price,GenderType gender) {
        setGender(gender);
        setName(name);
        setBrand(brand);
        setPrice(price);
    }

    @Override
    public String getName() {
        return name;
    }
    private void setName(String name) {
        if (name==null|| name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR);
        }
        this.name = name;
    }

    @Override
    public String getBrand() {
       return brand;
    }
    private void setBrand(String brand) {
        if (brand==null|| brand.length() < MIN_BRAND_LENGTH || brand.length() > MAX_BRAND_LENGTH) {
            throw new IllegalArgumentException(
                    BRAND_LENGHT_ERROR);
        }
        this.brand = brand;
    }

    @Override
    public double getPrice() {
       return price;
    }
    private void setPrice(double price) {
        if (price < 0.00) {
            throw new IllegalArgumentException(PRICE_ERROR);
        }
        this.price = price;
    }

    @Override
    public GenderType getGender() {
        return gender;
    }
    private void setGender(GenderType gender) {
        if (gender == null) {
            throw new IllegalArgumentException("Gender is not correct");
        }
        this.gender = gender;
    }

    @Override
    public String print() {
        return String.format(
               " #%s %s%n"+
               " #Price: %.2f%n"+
               " #Gender: %s%n"
                , getName(), getBrand(), getPrice(), getGender());
    }
    }

