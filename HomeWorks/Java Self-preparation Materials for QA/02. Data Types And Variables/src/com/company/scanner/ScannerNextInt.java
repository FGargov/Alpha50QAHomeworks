package com.company.scanner;

import java.util.Scanner;

public class ScannerNextInt {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // This function returns the Int scanned from the input.
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();

        // Print the sum of all numbers
        System.out.println(a + b + c);
    }
}
