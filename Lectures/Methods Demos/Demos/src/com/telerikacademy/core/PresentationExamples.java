package com.telerikacademy.core;

import java.util.Arrays;

public class PresentationExamples {
    public static void main(String[] args) {
        int a = 1;
        increment(a); // примитивни типове данни живеята само когато ги извикаш и не се запеметяват извън тялото на цикъла.
        System.out.println(a);

        int[] arr = {1,2,3,4,5};
        incremnentRef(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr1 = {1,2,3,4,5};
        initialize(arr1);
        System.out.println(Arrays.toString(arr1));
    } 

    public static void initialize(int[] arr2) {
        arr2[4] = 50;
        arr2 = new int[]{1, 1, 1};
        arr2[0] = 10;
        System.out.println(Arrays.toString(arr2));
    }

    private static void incremnentRef(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= 10;
        }
    }

  public static void increment(int x) {
        x = x + 1;
        System.out.println(x);
    }
}
