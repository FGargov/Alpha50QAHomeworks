package com.company;

public class ForLoops {
    public static void main(String[] args) {

        //Print the numbers from zero to nine
        for (int i = 0; i < 10; ++i) {
            System.out.printf("%d ", i);
        }
        System.out.println();

        //Calculate factorial(5)
        int number = 5;
        long factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial = factorial * i;
        }
        System.out.printf("%d! = %s%n", number, factorial);

        //Sum the numbers 1,2,4,8, ... ,128
        for (int i = 1, sum = 1; i <= 128; i = i * 2, sum += i) {
            System.out.printf("i = %d, sum = %d%n", i, sum);
        }
    }
}
