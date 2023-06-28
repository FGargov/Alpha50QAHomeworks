package com.company.oop;

import java.time.LocalDate;
import java.time.Month;

public class Main {

    public static void main(String[] args) {
        Order order1 = new Order(
                "John",
                Currency.BGN,
                LocalDate.of(2022, Month.JANUARY, 15));

        order1.addItem(new Product("Keyboard", 56));
        order1.addItem(new Product("Monitor", 125));

        Order order2 = new Order(
                "Peter",
                Currency.USD,
                LocalDate.of(2021, Month.AUGUST, 22));

        order2.addItem(new Product("Sweater", 25));
        order2.addItem(new Product("Jeans", 30));

        Order[] orders = new Order[]{order1, order2};
        for (var order : orders) {
            System.out.println(order.getGeneralInfo());
            System.out.println(order.getOrderItemsInfo());
        }
    }

}
