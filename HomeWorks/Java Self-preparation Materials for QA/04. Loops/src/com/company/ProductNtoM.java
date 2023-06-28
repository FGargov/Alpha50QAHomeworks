package com.company;

import java.util.Scanner;

public class ProductNtoM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Print the product of all numbers in a given range
        System.out.print("n = ");
        int n = Integer.parseInt(scanner.nextLine());
        System.out.print("m = ");
        int m = Integer.parseInt(scanner.nextLine());

        if (n < m) {
            int num = n;
            long product = 1;
            do {
                product = product * num;
                num++;
            }
            while (num <= m);

            System.out.println("product[n..m] = " + product);
        } else {
            System.out.println("Error: n should be smaller than m.");
        }
    }

}
