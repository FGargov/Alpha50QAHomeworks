package com.company;

import java.util.Scanner;

public class Sum1toN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Print the sum of all numbers between 1 and n (entered from the console)
        System.out.print("n = ");
        int n = Integer.parseInt(scanner.nextLine());
        int number = 1;
        int sum = 1;

        System.out.print("The sum 1");
        while (number < n) {
            number++;
            sum += number;
            System.out.printf(" + %d", number);
        }
        System.out.printf(" = %d%n", sum);
    }
}
