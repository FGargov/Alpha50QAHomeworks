package com.company.oop.collections;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //numbers variable contains the address of the array object
        //in this array object are stored the elements: 3, 1, 4
        int[] numbers = {3, 1, 4};

        //new variable containing the same address:
        int[] numbers2 = numbers;

        //as both variables point to the same object if we change the object (via either numbers or numbers2)
        //both variables will still pointing the same object which has new state:
        numbers[0] = 10;
        numbers2[1] = 33;
        System.out.printf("numbers : %s %n", Arrays.toString(numbers));
        System.out.printf("numbers2 : %s %n", Arrays.toString(numbers2));

        System.out.println("~~~");

        //people variable contains the address of the array object
        //this array object contains two addresses
        //first element people[0] contains the address of Jill Person object
        //second element people[1] contains the address of John Person object
        Person[] people = {
                new Person("Jill"),
                new Person("John")
        };
        System.out.printf("First address: %s pointing to Person object with name: %s %n", people[0], people[0].name);
        System.out.printf("Second address: %s pointing to Person object with name: %s %n", people[1], people[1].name);

        //we can change both the address:
        people[0] = new Person("Pesho"); //now first element of the array points to new object (different address)

        //and the object
        people[1].name = "Gosho";//the address remains the same but the object John is changed

        System.out.println(" >>> After the change:");
        System.out.printf("First address: %s pointing to Person object with name: %s %n", people[0], people[0].name);
        System.out.printf("Second address: %s pointing to Person object with name: %s %n", people[1], people[1].name);
    }
}
