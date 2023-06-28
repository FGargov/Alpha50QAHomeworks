package com.company.oop;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

    public void displayOrderItems() {
        if (items.length == 0) {
            System.out.println("No items");
        }

        StringBuilder sb = new StringBuilder("Items:");
        for (String item : items) {
            sb.append(String.format("  %s", item));
        }

        System.out.println(sb.toString());
    }

    public void displayGeneralInfo() {
        String dateFormat = deliveryOn.format(DateTimeFormatter.ofPattern("dd MMM yyyy"));

        System.out.printf("Order to %s | Delivery on: %s | Total: %s",
                recipient,
                dateFormat,
                formatPrice());
    }

    public String formatPrice() {
        return String.format("%.2f %s", total, currency);
    }

}
