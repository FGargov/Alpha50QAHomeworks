package com.company;

import java.util.Scanner;

public class PrimesInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //The task is to print all prime number in a given range
        System.out.printf("Enter number greater than 1%nn = ");
        int n = Integer.parseInt(scanner.nextLine());
        System.out.printf("Enter number greater than n%nm = ");
        int m = Integer.parseInt(scanner.nextLine());

        boolean isPrime;
        int divider;
        int maxDivider;
        if ((n > 1) && (m > n)) {
            for (int num = n; num <= m; num++) {
                isPrime = true;
                divider = 2;
                maxDivider = (int) Math.sqrt(num);

                while (divider <= maxDivider) {
                    if (num % divider == 0) {
                        isPrime = false;
                        break;
                    }
                    divider++;
                }

                if (isPrime) {
                    System.out.printf("%d ", num);
                }
            }

            System.out.println();
        } else {
            System.out.println("Invalid range!");
        }
    }
}
