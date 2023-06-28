package com.company;

import java.util.Scanner;

public class MathMaxMin {
    public static void main(String[] args) {
        // Read three numbers from the console
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        // Find the biggest of them
        int greatest = Math.max(a, Math.max(b, c));

        // Find the smallest of them
        int smallest = Math.min(a, Math.min(b, c));

        // Print the sum of the biggest and the smallest
        System.out.println(greatest + smallest);
    }
}
