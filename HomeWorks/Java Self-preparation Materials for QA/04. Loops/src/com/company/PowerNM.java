package com.company;

import java.util.Scanner;

public class PowerNM {
    public static void main(String[] args) {
        //Task to calculate n^m
        // If n=2 and m=3 we want to calculate result=2*2*2
        System.out.print("n = ");
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        System.out.print("m = ");
        int m = Integer.parseInt(scanner.nextLine());

        long result = 1;
        for (int i = 0; i < m; i++) {
            result = result * n;
        }

        System.out.printf("n^m = %s\n", result);
    }
}
