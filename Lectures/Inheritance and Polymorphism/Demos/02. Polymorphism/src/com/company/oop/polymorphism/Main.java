package com.company.oop.polymorphism;

public class Main {
    public static void main(String[] args) {
        User[] users = new User[] {
          new User("Ivan"),
          new Staff("Georgi", 1),
          new Editor("Pesho", 2, 23)
        };

        for (User user: users) {
            System.out.println(user);
            System.out.println("###");
        }

        User gosho = new Editor("Gosho", 6, 67);

        for (User user : users) {
            System.out.println(user.identify());
        }
    }
}
