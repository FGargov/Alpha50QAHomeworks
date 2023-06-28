package com.company.oop.finalprimitivevsreference;

public class Main {
    public static void main(String[] args) {
        final int number = 4;
        // number = 5; // Compilation error!

        final Person person = new Person("Gosho");
        person.setName("Misho"); // OK
        //person = new Person("Misho"); // Error!
    }
}
