package com.company.cosmetics.models.products;

import com.company.cosmetics.models.contracts.Shampoo;
import com.company.cosmetics.models.common.GenderType;
import com.company.cosmetics.models.common.UsageType;


public class ShampooImpl extends ProductBase implements Shampoo {
    public static final double MIN_MILIMITERS = 0.00;
    public static final int MIN_MILLILITERS = 0;
    public static final String MILILITER_ERROR_MSG = "Mililiter cannot be negative number.";
    private  int mililiters;
    protected UsageType usageType;
    public ShampooImpl(String name, String brand, double price, GenderType gender, int milliliters, UsageType usageType) {
        super(name,brand,price,gender);
        setMililiters(milliliters);
        this.usageType=usageType;
    }
    public void setMililiters(int mililiters) {
        mililiterValidation(mililiters);
        this.mililiters = mililiters;
    }

    @Override
    public int getMilliliters() {
        return  mililiters;
    }
    @Override
    public UsageType getUsage() {
        return usageType;
    }
    private static void mililiterValidation(int mililiters) {
        if(mililiters < MIN_MILLILITERS){
            throw  new IllegalArgumentException(MILILITER_ERROR_MSG);
        }
    }
    @Override
    public String print() {
        return String.format("%s\n ##Milliliters: %d \n #Usage: %s\n ===",super.print(),getMilliliters(),getUsage());
    }
}
