package com.company;

import java.util.Scanner;

public class IsPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //The task is to make a program that calculates if a user entered number is a prime number or not
        System.out.print("Enter a positive integer number: ");
        int number = Integer.parseInt(scanner.nextLine());
        int divider = 2;
        int maxDivider = (int) Math.sqrt(number);
        boolean prime = true;

        while (prime && (divider <= maxDivider)) {
            if (number % divider == 0) {
                prime = false;
            }
            divider++;
        }
        System.out.printf("Prime? %s%n", prime);
    }
}
