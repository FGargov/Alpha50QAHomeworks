package com.company.cosmetics.models.products;

import com.company.cosmetics.models.contracts.Shampoo;
import com.company.cosmetics.models.common.GenderType;
import com.company.cosmetics.models.common.UsageType;


public class ShampooImpl extends ProductBase implements Shampoo {
    public static final String NEGATIVE_NUMBER = "Milliliters are not negative number.";

   private int milliliters;
   private UsageType usage;

    public ShampooImpl(String name, String brand, double price, GenderType gender, int milliliters, UsageType usage) {
        super(name,brand,price,gender);
        setMilliliters(milliliters);
        setUsage(usage);
    }

    @Override
    public int getMilliliters() {
      return milliliters;
    }
   private void setMilliliters(int milliliters) {
        if (milliliters<0){
            throw new IllegalArgumentException(NEGATIVE_NUMBER);
        }
        this.milliliters = milliliters;
    }
    @Override
    public UsageType getUsage() {
       return usage;
    }

    private void setUsage(UsageType usage) {
        if (usage==null){
            throw new IllegalArgumentException("Invalid usage.");
        }
        this.usage = usage;
    }
    @Override
    public String print() {
       return String.format (
               "%s # Milliliters : %d %n" +
                            " #Usage: %s %n " +
                             " ===",super.print(), getMilliliters(),getUsage());
    }

}
