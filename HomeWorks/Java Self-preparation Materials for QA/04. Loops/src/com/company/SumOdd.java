package com.company;

import java.util.Scanner;

public class SumOdd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("n = ");
        int count = Integer.parseInt(scanner.nextLine());

        int sum = 0;
        for (int i = 1; i <= count; i += 2) {
            if ((i % 7) == 0) {
                continue;
            }

            sum += i;
        }

        System.out.printf("sum = %d%n", sum);
    }
}
