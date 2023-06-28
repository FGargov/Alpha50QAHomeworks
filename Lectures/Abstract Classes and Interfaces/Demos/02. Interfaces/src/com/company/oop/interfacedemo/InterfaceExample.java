package com.company.oop.interfacedemo;

public interface InterfaceExample {
    //Interfaces can have:
    //1. Abstract methods:
    void sayHello(); //most of the time we will have only abstract methods in the interfaces we write

    //2. Constants:
    // (NOTE 'public' AND 'static' AND 'final' are redundant
    public final static int CONSTANT = 1;

    //3. Methods with body - default methods:
    public default void avoid() {
        System.out.println("Please avoid writing default methods in your interfaces");
    }

    //4. Static methods:
    public static int increment(int number) {
        return number + 1;
    }
}
