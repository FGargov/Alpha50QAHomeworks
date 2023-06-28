package com.telerikacademy.core;

import java.util.Scanner;

public class JaggedArraysDemo {
    public static void main(String[] args) {
        // initialize jagged array with values
        // 1 2 3
        // 4 5
        // 6 7 8 9
        int[][] jaggedArray1 = {
                {1, 2, 3},
                {4, 5},
                {6, 7, 8, 9}
        };

        // initialize jagged array from the console where rows count is on first line and each row is entered on a new line on the console e.g.
        // 3
        // 1 2 3
        // 4 5
        // 6 7 8 9
        System.out.println("Enter matrix size and then each row on a new line:");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int rows = Integer.parseInt(line);
        int[][] jaggedArray2 = new int[rows][];
        for (int i = 0; i < rows; i++) {
            line = scanner.nextLine();
            String[] strArr = line.split(" ");
            jaggedArray2[i] = new int[strArr.length];
            for (int j = 0; j < strArr.length; j++) {
                jaggedArray2[i][j] = Integer.parseInt(strArr[j]);
            }
        }

        // print jagged array on the console
        for (int i = 0; i < jaggedArray2.length; i++) {
            for (int j = 0; j < jaggedArray2[i].length; j++) {
                System.out.printf("%d ", jaggedArray2[i][j]);
            }
            System.out.println();
        }
    }
}
