package com.company.oop.constructors;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        tryConstructorOrder();
        tryAddingDifferentUsersInACollection();
    }

    private static void tryConstructorOrder() {
        User pesho = new Editor("Pesho", 1, 23);
        //first the User constructor is finished - then Staff and at the end - Editor constructor

        Editor gosho = new Editor("Gosho", 2, 45);

        //gosho is an Editor and has numberOfArticles
        //but he is also a Staff and has a workId
        //and he is an User as well and has a name:
        System.out.printf(
                "%s has workId: %d and wrote %d articles.",
                gosho.getName(),
                gosho.getStaffId(),
                gosho.getNumberOfArticles());
    }

    private static void tryAddingDifferentUsersInACollection() {
        EmailAdmin admin = new EmailAdmin("Sergo", 3);
        Editor editor = new Editor("Neven", 5, 67);

        List<User> users = new ArrayList<>();
        // admin IS-A User and editor IS-A User therefore we can add them in a collection of users
        users.add(admin);
        users.add(editor);
    }
}
