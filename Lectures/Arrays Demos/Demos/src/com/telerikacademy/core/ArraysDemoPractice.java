package com.telerikacademy.core;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class ArraysDemoPractice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[5];
        int[] array2 = {1, 2, 3, 4, 5};
        int[] array12 = array2;
        System.out.println(Arrays.toString(array12));


        int[] array3 = new int[5];
        for (int i = 0; i < array3.length; i++) {
            array3[i] = i * 2;
        }
        System.out.println(Arrays.toString(array3));


        /*System.out.println("Enter array size and then each element on a new line:");
        String line = scanner.nextLine();
        int size = Integer.parseInt(line);
        int[] array4 = new int[size];
        for (int i = 0; i < array4.length; i++) {
            line = scanner.nextLine();
            array4[i] = Integer.parseInt(line);
        }
        System.out.println(Arrays.toString(array4));*/


        // initialize array from the console where all elements are entered on a single line e.g.
        System.out.println("Enter array on a single line using space for delimiter:");
        String[] strArray = scanner.nextLine().split(" ");
        int[] array5 = new int[strArray.length];
        for (int i = 0; i < array5.length; i++) {
            array5[i] = Integer.parseInt(strArray[i]);
        }
        // print array on the console
        for (int i = 0; i < array5.length; i++) {
            System.out.printf("%d ", array5[i]);
        }
        System.out.println();
        //print array on the console
        System.out.println(Arrays.toString(array5));

    }
}
