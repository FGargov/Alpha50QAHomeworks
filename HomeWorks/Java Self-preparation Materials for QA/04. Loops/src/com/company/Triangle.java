package com.company;

import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Print a triangle from numbers:
        //1
        //1 2
        //1 2 3
        // ... n-th row
        System.out.print("n = ");
        int n = Integer.parseInt(scanner.nextLine());
        System.out.println();

        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.printf("%d ", col);
            }
            System.out.println();
        }
    }
}
