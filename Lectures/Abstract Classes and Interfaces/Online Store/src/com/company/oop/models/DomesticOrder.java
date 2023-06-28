package com.company.oop.models;

import com.company.oop.enums.Currency;

import java.time.LocalDate;

public class DomesticOrder extends BaseOrder {


    public DomesticOrder(String recipient, Currency currency, LocalDate deliveryOn) {
        super(recipient, currency, deliveryOn);
    }

    @Override
    protected String getOrderType() {
        return "Domestic";
    }
}
