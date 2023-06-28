package com.company.cosmetics.models.products;

import com.company.cosmetics.models.contracts.Cream;
import com.company.cosmetics.models.common.GenderType;
import com.company.cosmetics.models.common.ScentType;


public class CreamImpl extends ProductBase implements Cream {
    public static final IllegalArgumentException INVALID_SCENT =
            new IllegalArgumentException("Scent can not be null");

    ScentType scent;

    public CreamImpl(String name, String brand, double price, GenderType gender, ScentType scent) {
        super(name,brand,price,gender);
        setScent(scent);

    }
    @Override
    public ScentType getScent() {
       return scent;
    }

    public void setScent(ScentType scent) {
        if (scent==null){
            throw INVALID_SCENT;
        }
        this.scent = scent;
    }

    @Override
    public String print() {
        return String.format(
                        "%s " +
                        "#Scent: %s%n"
                                + " ==="
                ,super.print(), getScent());
    }

}
