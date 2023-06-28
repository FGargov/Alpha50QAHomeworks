package com.company.oop.constructors.practice;

import java.util.ArrayList;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*tryConstructorOrder();
        tryAddingDifferentUsersInACollection();
        User fero = new Editor("asd", 5, 123);
        //fero.getNumberOfArticles();
        int number = (int)3.14;
        System.out.println(number);*/

        EmailAdmin admin = new EmailAdmin("Sergo", 3);
        Editor editor = new Editor("Neven", 5, 67);

        ArrayList<User> users = new ArrayList<>();
        users.add(admin);
        users.add(editor);
        users.forEach(user -> {
            System.out.println(user.getName());
        });

      for (User user: users) {
          if (user instanceof Editor) {
              Editor editorTwo = (Editor) editor;
              System.out.printf("Editor with name: %s, workID: %d, and number of articles: %d %n",
                      editorTwo.getName(),
                      editorTwo.getStaffId(),
                      editorTwo.getNumberOfArticles());
          } else if (user instanceof EmailAdmin) {
              EmailAdmin emailAdmin = (EmailAdmin) admin;
              System.out.printf("Admin with name: %s, workID: %d, and emails: %s %n",
                      admin.getName(),
                      admin.getStaffId(),
                      admin.getEmails().toString());
          } else if (user instanceof User) {
              System.out.printf("User with name: %s", user.getName());
          }
      }
    }

    private static void tryConstructorOrder() {
        User pesho = new Editor("Pesho", 1, 23);
        Editor gosho = new Editor("Gosho", 2, 45);

        System.out.printf("%s has workId: %d and wrote %d articles.",
                gosho.getName(), gosho.getStaffId(), gosho.getNumberOfArticles());
        System.out.println();
        System.out.println(pesho.identify());
    }

    private static void tryAddingDifferentUsersInACollection() {
        EmailAdmin admin = new EmailAdmin("Sergo", 3);
        Editor editor = new Editor("Neven", 5, 67);

        ArrayList<User> users = new ArrayList<>();
        users.add(admin);
        users.add(editor);
        users.forEach(user -> {
            System.out.println(user.getName());
        });
    }
}
