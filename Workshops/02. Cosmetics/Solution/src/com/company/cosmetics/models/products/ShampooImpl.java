package com.company.cosmetics.models.products;

import com.company.cosmetics.models.contracts.Shampoo;
import com.company.cosmetics.models.common.GenderType;
import com.company.cosmetics.models.common.UsageType;


public class ShampooImpl extends ProductBase implements Shampoo {
    private int milliliters;
    protected UsageType usageType;
    
    public ShampooImpl(String name, String brand, double price, GenderType gender, int milliliters, UsageType usageType) {
        super(name, brand, price, gender);
        setMilliliters(milliliters);
        this.usageType = usageType;
    }

    @Override
    public int getMilliliters() {
        return this.milliliters;
    }
    public void setMilliliters(int milliliters) {
        if (milliliters < 0) {
            throw new IllegalArgumentException("Milliliters cannot be negative");
        }
        this.milliliters = milliliters;
    }

    @Override
    public UsageType getUsage() {
        return this.usageType;
    }

    @Override
    public String print() {
        return String.format("%s\n #Milliliters: %d\n #Usage: %s\n ===", super.print(), getMilliliters(), getUsage());
    }
}
