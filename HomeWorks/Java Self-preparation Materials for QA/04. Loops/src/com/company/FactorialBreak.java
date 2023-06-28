package com.company;

import java.util.Scanner;

public class FactorialBreak {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("n = ");
        int number = scanner.nextInt();

        System.out.print("n! = ");

        long factorial = 1;

        // Perform an infinite loop
        while (true) {
            System.out.print(number);
            if (number == 1) {
                break;
            }

            System.out.print(" * ");
            factorial = factorial * number;
            number--;
        }
        System.out.printf(" = %s", factorial);
    }
}
