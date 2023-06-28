package com.company.oop;

import java.time.LocalDate;
import java.time.Month;

public class Main {

    public static void main(String[] args) {
        Order order1 = new Order("John",
                Currency.BGN,
                LocalDate.of(2020, Month.JULY, 30));

        order1.addItem(new Product("Keyboard", 56));
        order1.addItem(new Product("Monitor", 125));


        Order order2 = new Order("Peter",
                Currency.BGN,
                LocalDate.of(2020, Month.DECEMBER, 24));

        order2.addItem(new Product("Sweater", 25));
        order2.addItem(new Product("Jeans", 30));

        Order[] orders = new Order[]{order1, order2};

        for (Order order : orders) {
            order.displayGeneralInfo();
            System.out.println();
            order.displayOrderItems();
            System.out.printf("------------------------%n");
        }
    }

}
