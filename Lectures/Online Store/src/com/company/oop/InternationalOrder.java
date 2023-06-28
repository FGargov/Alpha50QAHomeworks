package com.company.oop;

import java.time.LocalDate;

public class InternationalOrder extends Order {
    private static final int MAX_PRODUCTS_LIMITS = 15;
    private String carrier;
    private int customPercentage;

    public InternationalOrder(String recipient, Currency currency, LocalDate deliveryOn, String carrier, int customPercentage) {
        super(recipient, currency, deliveryOn);
        setCarrier(carrier);
        setCustomPercentage(customPercentage);
    }

    public String getCarrier() {
        return carrier;
    }

    private void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public int getCustomPercentage() {
        return customPercentage;
    }

    private void setCustomPercentage(int customPercentage) {
        this.customPercentage = customPercentage;
    }

    @Override
    public String getGeneralInfo() {
        return String.format("%s | Carrier: %s | *NOTE* - customs of %d%% expected but to be calculated on arrival.",
                super.getGeneralInfo(),
                getCarrier(),
                getCustomPercentage());
    }
    @Override
    public void addItem(Product item) {

        // First check if the item is already in the collection.
        if (getItems().size() >= MAX_PRODUCTS_LIMITS) {
            throw new IllegalArgumentException("International orders are limited to 5 products");
        }

        super.addItem(item);
    }
}
