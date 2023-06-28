package com.company.cosmetics.models.products;
import com.company.cosmetics.models.contracts.Product;
import com.company.cosmetics.models.common.GenderType;

public class ProductBase implements Product {
    public static final int MIN_NAME_LENGHT = 3;
    public static final int MAX_NAME_LENGHT = 10;
    public static final String SHAMPOO_NAME_LENGHT = String.format("Shampoo name must be between %d and %d symbols.", MIN_NAME_LENGHT, MAX_NAME_LENGHT);
    public static final int MIN_BRAND_LENGHT = 2;
    public static final String BRAND_NAME = String.format("Brand name must be between %d and %d symbols", MIN_BRAND_LENGHT, MAX_NAME_LENGHT);
    public static final double MIN_PRICE = 0.00;
    public static final String PRICE_ERROR_MSG = String.format("Price cannot be less than %.2f", MIN_PRICE);
    private  String name;
    private String brand;
    private  double price;
    public GenderType gender;
    public ProductBase(String name, String brand, double price, GenderType gender) {
        setName(name);
        setBrand(brand);
        setPrice(price);
        this.gender=gender;
    }

    private void setName(String name) {
        nameValidation(name);
        this.name = name;
    }

    private void setBrand(String brand) {
        brandValidation(brand);
        this.brand = brand;
    }
    private void setPrice(double price) {
        priceValidation(price);
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
    public double getPrice() {return price;
    }

    @Override
    public GenderType getGender() {
     return  gender;
    }
    public   void nameValidation(String name) {
        if(name==null||name.length()< MIN_NAME_LENGHT || name.length()>MAX_NAME_LENGHT){
            throw new IllegalArgumentException(SHAMPOO_NAME_LENGHT);
        }
    }
    private static void brandValidation(String brand) {
        if (brand==null||brand.length() < MIN_BRAND_LENGHT || brand.length() > MAX_NAME_LENGHT) {
            throw new IllegalArgumentException(BRAND_NAME);
        }
    }
    protected  void priceValidation(double price) {
        if(price < MIN_PRICE){
            throw new IllegalArgumentException(PRICE_ERROR_MSG);
        }
    }
    @Override
    public String print() {
        return String.format((" #%s %s\n" +
                " #Price: $%.2f\n" +
                " #Gender: %s"), getName(),getBrand(),getPrice(),getGender());
    }




}
