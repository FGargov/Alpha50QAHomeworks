package com.company.oop;

import java.time.LocalDate;
import java.time.Month;

public class Main {

    public static void main(String[] args) {

        Order order1 = new Order("John",
                450,
                "USD",
                LocalDate.of(2020, Month.JULY, 30),
                new String[]{"PC", "Keyboard", "Monitor"});

        Order order2 = new Order("Peter",
                95,
                "BGN",
                LocalDate.of(2020, Month.DECEMBER, 24),
                new String[]{"Sweater", "Jeans"});

        Order[] orders = new Order[]{order1, order2};

        for (Order order : orders) {
            System.out.printf("To be delivered on: %s %n", order.deliveryOn.toString());
            System.out.print("Items: ");
            for (String item : order.items) {
                System.out.printf("%s  ", item);
            }
            System.out.printf("%n------------------------%n");
        }
    }

}
