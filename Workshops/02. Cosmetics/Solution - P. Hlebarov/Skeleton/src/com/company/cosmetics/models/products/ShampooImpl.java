package com.company.cosmetics.models.products;

import com.company.cosmetics.models.contracts.Shampoo;
import com.company.cosmetics.models.common.GenderType;
import com.company.cosmetics.models.common.UsageType;


public class ShampooImpl extends ProductBase implements Shampoo {

    private int milliliters;
    private final UsageType everyDay;
    public ShampooImpl(String name, String brand, double price, GenderType gender, int milliliters, UsageType everyDay) {
        super(name, brand, price, gender);
        this.milliliters = milliliters;
        this.everyDay = everyDay;
    }


    @Override
    public int getMilliliters() {
        return this.milliliters;
    }

    private void setMilliliters(int milliliters) {
        if (milliliters < 0) {
            throw new IllegalArgumentException("Milliliters cannot be a negative number");
        }
        this.milliliters = milliliters;
    }

    @Override
    public UsageType getUsage() {
        return this.everyDay;
    }

    @Override
    public String print() {
        return String.format("%s\n#Milliliters: %d\n#Usage: %s\n", super.print(), getMilliliters(), getUsage());
    }
}
