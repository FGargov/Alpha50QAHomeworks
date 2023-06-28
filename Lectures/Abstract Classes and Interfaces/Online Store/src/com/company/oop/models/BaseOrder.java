package com.company.oop.models;

import com.company.oop.contracts.Order;
import com.company.oop.enums.Currency;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseOrder implements Order {

    public static final double BGN_USD_CONVERSION_RATE = 1.75;
    public static final int MIN_RECIPIENT_LENGTH = 3;
    public static final int MAX_RECIPIENT_LENGTH = 35;

    private String recipient;
    private Currency currency;
    private LocalDate deliveryOn;
    private final List<Product> items;

    public BaseOrder(String recipient, Currency currency, LocalDate deliveryOn) {
        setRecipient(recipient);
        setCurrency(currency);
        setDeliveryOn(deliveryOn);
        items = new ArrayList<>();
    }

    @Override
    public String getRecipient() {
        return recipient;
    }

    @Override
    public Currency getCurrency() {
        return currency;
    }

    @Override
    public LocalDate getDeliveryOn() {
        return deliveryOn;
    }

    @Override
    public List<Product> getItems() {
        return new ArrayList<>(items);
    }

    private void setRecipient(String recipient) {
        if (recipient == null) {
            throw new IllegalArgumentException("Recipient cannot be empty");
        }
        if (recipient.length() < MIN_RECIPIENT_LENGTH || recipient.length() > MAX_RECIPIENT_LENGTH) {
            throw new IllegalArgumentException("Recipient name must be between 3 and 35 characters");
        }
        this.recipient = recipient;
    }

    private void setCurrency(Currency currency) {
        this.currency = currency;
    }

    private void setDeliveryOn(LocalDate deliveryOn) {
        this.deliveryOn = deliveryOn;
    }

    @Override
    public void addItem(Product item) {
        if (items.contains(item)) {
            throw new IllegalArgumentException("This item is already in this order");
        }
        items.add(item);
    }

    private double calculateTotalPrice() {
        double total = 0;
        for (Product item : items) {
            total += item.getPrice();
        }

        if (currency == Currency.BGN) {
            total = total * BGN_USD_CONVERSION_RATE;
        }
        return total;
    }

    @Override
    public String getOrderItemsInfo() {
        if (items.size() == 0) {
            return "No items";
        }

        StringBuilder builder = new StringBuilder();
        for (Product item : items) {
            builder.append(String.format("  %s%n", item.getDisplayInfo()));
        }

        builder.append("-------------------------------------------------------------");

        return builder.toString();
    }

    @Override
    public String getGeneralInfo() {
        return String.format(
                "%s Order to %s | Delivery on: %s | Total: %s",
                getOrderType(),
                recipient,
                formatDeliveryDate(),
                formatPrice());
    }

    private String formatDeliveryDate() {
        return deliveryOn.format(DateTimeFormatter.ofPattern("dd MMM yyyy"));
    }

    private String formatPrice() {
        return String.format("%.2f %s", calculateTotalPrice(), currency);
    }

    protected abstract String getOrderType();
}
