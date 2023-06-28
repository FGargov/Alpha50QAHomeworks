package com.company.ifstatement;

import java.util.Scanner;

public class IfElseStatement {
    public static void main(String[] args) {
        System.out.print("Please enter a number: ");

        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        if (number % 2 == 0) {
            System.out.println("This number is even.");
        } else {
            System.out.println("This number is odd.");
        }
    }
}
