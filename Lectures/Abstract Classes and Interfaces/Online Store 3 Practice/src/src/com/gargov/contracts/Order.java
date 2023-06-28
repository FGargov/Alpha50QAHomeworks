package com.gargov.contracts;

import com.gargov.enums.Currency;
import com.gargov.models.Product;

import java.time.LocalDate;
import java.util.List;

public interface Order {
    String getRecipient();

    Currency getCurrency();

    LocalDate getDeliveryOn();

    List<Product> getItems();

    void addItem(Product item);

    String getOrderItemsInfo();

    String getGeneralInfo();
}
