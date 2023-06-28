package com.company.cosmetics.models.products;

import com.company.cosmetics.models.contracts.Cream;
import com.company.cosmetics.models.common.GenderType;
import com.company.cosmetics.models.common.ScentType;

import java.util.Locale;


public class CreamImpl extends ProductBase implements Cream {

    private ScentType scent;

    public CreamImpl(String name, String brand, double price, GenderType gender, ScentType scent) {
        super(name, brand, price, gender);
        setScent(scent);
    }

    private void setScent(ScentType scent) {
        this.scent = scent;
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
        return String.format(Locale.US, """
                        #%s %s
                         #Price: $%.2f
                         #Gender: %s
                         #Scent: %s
                         ===
                         """,
                this.getName(), this.getBrand(), this.getPrice(), this.getGender(), this.scent);
    }

    @Override
    public ScentType getScent() {
        return this.scent;
    }
}
