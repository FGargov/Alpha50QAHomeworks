package com.company.oop.composition.composition;

public class Main {
    public static void main(String[] args) {
        Address address = new Address("Sofia", "gen. Stefan Toshev");
        Citizen citizen = new Citizen("Pesho", address);

        System.out.println(citizen);
        System.out.println(address);
    }
}
