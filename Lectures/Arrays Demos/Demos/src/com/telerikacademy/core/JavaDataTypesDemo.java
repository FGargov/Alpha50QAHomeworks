package com.telerikacademy.core;

import java.util.Arrays;

public class JavaDataTypesDemo {
    public static void main(String[] args) {
        // primitive types
        int a = 5;
        int b = a;
        a = 10;

        // b has copy of the value of a
        System.out.println(a);
        System.out.println(b);

        // reference types
        int[] arr1 = {1, 2, 3};
        int[] arr2 = arr1;
        int[] arr3 = Arrays.copyOf(arr1, arr1.length);

        arr1[0] = 10;

        // arr1 and arr2 reference (point) to the same array
        // arr3 points to a copy of the arr1
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
    }
}
