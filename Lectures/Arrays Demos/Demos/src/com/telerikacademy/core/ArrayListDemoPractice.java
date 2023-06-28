package com.telerikacademy.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayListDemoPractice {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        // change element at index
        arrayList.set(2, 20);


        // initialize array list with 5 elements and values {0, 2, 4, 6, 8}
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            arrayList1.add(i * 2);
        }
        System.out.println(arrayList1);


        // initialize array list from the console where all elements are entered on a single line e.g.
        System.out.println("Enter array on a single line using space for delimiter:");
        Scanner scanner = new Scanner(System.in);
        String[] strArray = scanner.nextLine().split(" ");
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        for (int i = 0; i < strArray.length; i++) {
            arrayList2.add(Integer.parseInt(strArray[i]));
        }
        // print array on the console
        for (int i = 0; i < arrayList2.size(); i++) {
            System.out.printf("%d ", arrayList2.get(i));
        }
        System.out.println();
        //print array on the console
        System.out.println(arrayList2);
    }
}
