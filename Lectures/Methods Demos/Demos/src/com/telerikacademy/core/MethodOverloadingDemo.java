package com.telerikacademy.core;

public class MethodOverloadingDemo {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        printArray(array);

        printArray(array, 5);

        printArray(array, 20);
    }

    public static void printArray(int[] array) {
        printArray(array, array.length);
    }

    public static void printArray(int[] array, int n) {
        int boundary = Math.min(array.length, n);
        for (int i = 0; i < boundary; i++) {
            System.out.printf("%d ", array[i]);
        }
        System.out.println();
    }
}
