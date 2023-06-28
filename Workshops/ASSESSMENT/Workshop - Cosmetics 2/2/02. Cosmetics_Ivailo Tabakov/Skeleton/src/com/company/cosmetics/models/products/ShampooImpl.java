package com.company.cosmetics.models.products;
import java.util.Locale;
import com.company.cosmetics.models.contracts.Shampoo;
import com.company.cosmetics.models.common.GenderType;
import com.company.cosmetics.models.common.UsageType;


public class ShampooImpl extends ProductBase implements Shampoo {

    public static final String MILLILITERS_ERROR = "Milliliters cannot be negative number";
    private int milliliters;
    private UsageType usageType;

    public ShampooImpl(String name, String brand, double price, GenderType gender, int milliliters, UsageType usageType) {
        super(name, brand, price, gender);
        setMilliliters(milliliters);
        setUsageType(usageType);
    }

    private void setUsageType(UsageType usageType) {
        this.usageType = usageType;
    }

    private void setMilliliters(int milliliters) {
        if (milliliters < 0) {
            throw new IllegalArgumentException(MILLILITERS_ERROR);
        }
        this.milliliters = milliliters;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getBrand() {
        return super.getBrand();
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    @Override
    public GenderType getGender() {
        return super.getGender();
    }

    @Override
    public String print() {
        return String.format(Locale.US,"""
                        #%s %s
                         #Price: $%.2f
                         #Gender: %s
                         #Milliliters: %d
                         #Usage: %s
                         ===
                         """,
                this.getName(), this.getBrand(), this.getPrice(), this.getGender(), this.milliliters, this.usageType);
    }

    @Override
    public int getMilliliters() {
        return this.milliliters;
    }

    @Override
    public UsageType getUsage() {
        return this.usageType;
    }
}
