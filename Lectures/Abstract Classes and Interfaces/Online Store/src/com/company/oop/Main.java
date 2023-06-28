package com.company.oop;

import com.company.oop.contracts.Order;
import com.company.oop.enums.Currency;
import com.company.oop.models.DomesticOrder;
import com.company.oop.models.InternationalOrder;
import com.company.oop.models.Product;

import java.time.LocalDate;
import java.time.Month;

public class Main {

    public static void main(String[] args) {
        Order order1 = new DomesticOrder("John", Currency.BGN, LocalDate.of(2022, Month.JANUARY, 15));
        order1.addItem(new Product("Keyboard", 56));
        order1.addItem(new Product("Monitor", 125));

        Order order2 = new DomesticOrder("Peter", Currency.USD, LocalDate.of(2021, Month.AUGUST, 22));
        order2.addItem(new Product("Sweater", 25));
        order2.addItem(new Product("Jeans", 30));

        Order order3 = new InternationalOrder("Roger", Currency.USD, LocalDate.of(2021, Month.MAY, 28),
                "TopHamaliEOOD", 20);
        order3.addItem(new Product("Backpack", 16));
        order3.addItem(new Product("Speakers", 90));

        Order[] orders = new Order[]{order1, order2, order3};
        displayOrders(orders);


        Order[] internationalOrders = new Order[]{order3};
        displayOrders(internationalOrders);
    }

    private static void displayOrders(Order[] orders) {
        for (Order order : orders) {
            System.out.println(order.getGeneralInfo());
            System.out.println(order.getOrderItemsInfo());
        }
    }
}
