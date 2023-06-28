package com.company.oop;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    public static final int MIN_RECIPIENT_LENGTH = 3;
    public static final int MAX_RECIPIENT_LENGTH = 35;
    public static final double BGN_USD_CONVERSION_RATE = 1.75;
    private String recipient;
    private LocalDate deliveryOn;
    private Currency currency;
    private List<Product> items;

    public Order(String recipient, Currency currency, LocalDate deliveryOn) {
        setRecipient(recipient);
        setDeliveryOn(deliveryOn);
        setCurrency(currency);
        items = new ArrayList<>();
    }

    public String getRecipient() {
        return recipient;
    }

    private void setRecipient(String recipient) {
        if (recipient == null) {
            throw new IllegalArgumentException("Recpient cannot be empty.");
        }
        if (recipient.length() < MIN_RECIPIENT_LENGTH || recipient.length() > MAX_RECIPIENT_LENGTH)
        {
            throw new IllegalArgumentException("Recipient name must be between 3 and 35 characters");
        }
        this.recipient = recipient;
    }

    public LocalDate getDeliveryOn() {
        return deliveryOn;
    }

    private void setDeliveryOn(LocalDate deliveryOn) {
        this.deliveryOn = deliveryOn;
    }

    public Currency getCurrency() {
        return currency;
    }

    private void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public List<Product> getItems() { // така ще направим копие на листа и няма да пипаме действителната колекция.
        return items;
    }

   /* private void setItems(List<Product> items) {
        this.items = items;
    }*/

    public void addItem(Product item) {
        if (getItems().contains(item)) {    // така ще направим копие на листа и няма да пипаме действителната колекция.
            throw new IllegalArgumentException("This item is already in this order");
        }

        items.add(item);
    }


    public void displayOrderItems() {
        if (items.size() == 0) {
            System.out.println("No items");
        }

        StringBuilder sb = new StringBuilder("Items:");
        for (Product item : items) {
            sb.append(String.format("  %s", item.getDisplayInfo()));
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
        return String.format("%.2f %s", calculateTotalPrice(), currency);
    }

    public double calculateTotalPrice() {
        double total = 0;
        for (Product item : items) {
            total += item.getPrice();
        }

        if (currency == Currency.BGN) {
            total = total * BGN_USD_CONVERSION_RATE;
        }

        return total;
    }

}
