package com.telerikacademy.core;

import java.util.ArrayList;

public class LoopsDemo {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        // for loop
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%d ", matrix[i][j]);
            }
            System.out.println();
        }

        // enhanced for loop
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.printf("%d ", element);
            }
            System.out.println();
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        // for loop
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.printf("%d ", arrayList.get(i));
        }
        System.out.println();

        // enhanced for loop
        for (int element : arrayList) {
            System.out.printf("%d ", element);
        }
        System.out.println();
    }
}
