package com.company.dsa;

public class QuadraticComplexity {
    public static void main(String[] args) {

    }

    static void findPairs(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i] == array[j] && i != j) {
                    System.out.printf("(%d; %d)%n", i, j);
                }
            }
        }
    }
}
