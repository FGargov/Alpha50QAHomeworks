package com.company.dsa;

public class LinearComplexity {
    public static void main(String[] args) {

    }

    static int sum(int[] array) {
        int sum = 0;
        for (int element : array) {
            sum += element;
        }
        return sum;
    }

    static int sumEvenIndexes(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i += 2) {
            sum += array[i];
        }
        return sum;
    }

    static int sumEvenNumbers(int[] array) {
        int sum = 0;
        for (int element : array) {
            if (element % 2 == 0) {
                sum += element;
            }
        }
        return sum;
    }

    static int max(int[] array) {
        int max = array[0];
        for (int element : array) {
            max = Math.max(max, element);
        }
        return max;
    }
}
