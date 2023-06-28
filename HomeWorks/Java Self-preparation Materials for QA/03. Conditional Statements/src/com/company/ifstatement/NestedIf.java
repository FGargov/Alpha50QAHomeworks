package com.company.ifstatement;

import java.util.Scanner;

public class NestedIf {
    public static void main(String[] args) {
        System.out.println("Enter two numbers (on separate lines).");

        Scanner scanner = new Scanner(System.in);
        int first = Integer.parseInt(scanner.nextLine());
        int second = Integer.parseInt(scanner.nextLine());

        if (first == second) {
            System.out.println("These two numbers are equal.");
        } else {
            if (first > second) {
                System.out.println("The first number is greater.");
            } else {
                System.out.println("The second number is greater.");
            }
        }
    }
}
