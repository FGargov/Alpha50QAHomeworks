package com.telerikacademy.core;

import java.util.Arrays;

public class DataTypesAndMethodsDemoPractice {
    public static void main(String[] args) {
        int z = 1;
        increment(z);
        System.out.println(z);

        int[] arr = {1, 2, 3, 4, 5};
        update(arr);
    }

    private static void increment(int z) {
        z += 1;
        System.out.println(z);
    }

    private static void update(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= 10;
        }

        arr = new int[]{1, 1, 1, 1, 1};
        arr[0] *= 10;
        System.out.println(Arrays.toString(arr));
    }
}
