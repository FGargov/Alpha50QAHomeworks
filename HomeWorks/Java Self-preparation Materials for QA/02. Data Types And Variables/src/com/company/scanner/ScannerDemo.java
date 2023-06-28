package com.company.scanner;

import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        System.out.print("Enter a floating-point number: ");
        double doubleNumber = scanner.nextDouble();

        System.out.print("Enter a string: ");
        String str = scanner.next();

        // Print on the console variables you entered
        // Use %d for decimal numbers
        // Use %.f for floating-point numbers
        // Use %s for the text
        // Use %n for new line
        System.out.printf(
                "Number: %d%nFloating-point number: %f%nString: %s",
                number,
                doubleNumber,
                str);
    }
}
