package com.company.oop;

import java.time.LocalDate;

public class Order {

    public String recipient;
    public double total;
    public String currency;
    public LocalDate deliveryOn;
    public String[] items;

    public Order(String recipient, double total, String currency, LocalDate deliveryOn, String[] items) {
        this.recipient = recipient;
        this.total = total;
        this.currency = currency;
        this.deliveryOn = deliveryOn;
        this.items = items;
    }

}
