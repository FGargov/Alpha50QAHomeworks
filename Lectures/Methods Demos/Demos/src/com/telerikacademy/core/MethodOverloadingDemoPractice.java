package com.telerikacademy.core;

public class MethodOverloadingDemoPractice {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        printArray(array);
    }

    private static void printArray(int[] array) {
        printArray(array, array.length);
    }

    private static void printArray(int[] array, int n) {
        int boundary = Math.min(array.length, n);
        for (int i = 0; i < boundary; i++) {
            System.out.printf("%d ", array[i]);
        }
        System.out.println();
    }
}
