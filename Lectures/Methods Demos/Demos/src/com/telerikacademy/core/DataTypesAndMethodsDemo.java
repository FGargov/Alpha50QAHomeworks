package com.telerikacademy.core;

import java.util.Arrays;

public class DataTypesAndMethodsDemo {
    public static void main(String[] args) {
        int z = 1;
        // when we pass `z` as argument a copy of `z` is created
        increment(z);
        System.out.println(z);

        int[] arr = {1, 2, 3, 4, 5};
        // when we pass `arr` as argument a copy of the reference is created
        // the copy of the reference points to the same array as `arr`
        update(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void increment(int x) {
        // here we modify the copy of `z` thus we don't affect the value of `z`
        x += 1;
        System.out.println(x);
    }

    static void update(int[] array) {
        for (int i = 0; i < array.length; i++) {
            // here me modify the value of the same array that is pointed by `arr`
            array[i] *= 10;
        }

        // here we modify the array reference to point to a new array
        // thus we don't affect the value of `arr`
        array = new int[]{1, 1, 1, 1, 1};
        array[0] *= 10;

        System.out.println(Arrays.toString(array));
    }
}
