package com.company.oop.interfacedemo;

public class Main {

    public static void main(String[] args) {

        //we can access the constants in interfaces:
        int number = InterfaceExample.CONSTANT;
        System.out.println(number);

        //and we can use the static methods:
        System.out.println(InterfaceExample.increment(number));

        //In order to access interface (abstract) methods and default methods we need a class that implements the interface
        InterfaceExample example = new InterfaceExampleImpl();
        example.sayHello();
        example.avoid();
        System.out.println(InterfaceExample.increment(number));
    }
}
