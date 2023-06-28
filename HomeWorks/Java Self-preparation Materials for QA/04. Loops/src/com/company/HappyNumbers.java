package com.company;

public class HappyNumbers {
    public static void main(String[] args) {

        //Print all 4 digit numbers that are "happy"
        //A four digit number is happy if the sum of first two digits is equal to the sum of last two digits
        //This task as an example of nested for loops
        for (int a = 1; a <= 9; a++) {
            for (int b = 0; b <= 9; b++) {
                for (int c = 0; c <= 9; c++) {
                    for (int d = 0; d <= 9; d++) {
                        if ((a + b) == (c + d)) {
                            System.out.printf("%d%d%d%d%n", a, b, c, d);
                        }
                    }
                }
            }
        }
    }
}
