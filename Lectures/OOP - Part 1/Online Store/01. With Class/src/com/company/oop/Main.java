package com.company.oop;

import java.time.LocalDate;
import java.time.Month;

public class Main {

    public static void main(String[] args) {
        Order order1 = new Order();
        order1.recipient = "John";
        order1.items = new String[]{"PC", "Keyboard", "Monitor"};
        order1.deliveryOn = LocalDate.of(2020, Month.JULY, 30);
        order1.total = 450;
        order1.currency = "USD";

        Order order2 = new Order();
        order2.recipient = "Peter";
        order2.items = new String[]{"Sweater", "Jeans"};
        order2.deliveryOn = LocalDate.of(2020, Month.DECEMBER, 24);
        order2.total = 95;
        order2.currency = "BGN";

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
