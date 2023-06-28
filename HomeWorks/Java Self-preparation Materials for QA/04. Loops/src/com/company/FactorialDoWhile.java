package com.company;

import java.util.Scanner;

public class FactorialDoWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("n = ");
        int number = scanner.nextInt();
        long factorial = 1;

        do {
            factorial = factorial * number;
            number--;
        } while (number > 0);

        System.out.printf("n! = %s%n", factorial);
    }
}
