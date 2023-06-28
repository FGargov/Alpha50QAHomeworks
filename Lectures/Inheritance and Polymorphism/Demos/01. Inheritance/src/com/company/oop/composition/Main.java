package com.company.oop.composition;

public class Main {
    public static void main(String[] args) {
        Address address = new Address("Sofia", "Alexander Malinov");
        Citizen citizen = new Citizen("Pesho", address);

        System.out.println(citizen);
        System.out.println(address);
    }
}
