package com.company.ifstatement;

import java.util.Scanner;

public class IfStatement {
    public static void main(String[] args) {
        System.out.println("Please enter two numbers (on separate lines).");

        Scanner scanner = new Scanner(System.in);
        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());

        int biggerNumber = firstNumber;
        if (secondNumber > firstNumber) {
            biggerNumber = secondNumber;
        }

        System.out.printf("The bigger number is: %d\n", biggerNumber);
    }
}
