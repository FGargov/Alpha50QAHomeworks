package com.telerikacademy.core;

import java.util.Arrays;
import java.util.Scanner;

public class PresentationExamplesMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5},
                {6}
        };

       /* printMessage("Hello world!");
        printMatrix(matrix);*/
        int[] array = readArray();
        printArrayIntegers(array);
    }

    private static int[] readArray() {
        Scanner scanner = new Scanner(System.in);
        printMessage("Enter array size:");
        int size = scanner.nextInt();
        printMessage("Enter array elements on new line each: ");
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            String rowString = "";
            for (int cell : row) {
                rowString += cell + " ";
            }
            System.out.println(rowString.trim());
        }
    }

    static void printMessage(String message) {
        System.out.println(message);
    }

    static void printArrayIntegers(int[] array) {
        System.out.println(Arrays.toString(array));
    }
}
