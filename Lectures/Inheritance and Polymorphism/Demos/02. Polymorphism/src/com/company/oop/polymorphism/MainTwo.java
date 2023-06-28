package com.company.oop.polymorphism;

public class MainTwo {
    public static void main(String[] args) {

        User[] users = new User[]{
                new User("Ivan"),
                new Staff("Georgi", 1),
                new Editor("Pesho", 2, 23)
        };

        //1. Print different users (toString() is called):
        for (User user : users) {
            System.out.println(user);
            System.out.println("###");
        }

        //2. When object is created via base class reference we can use only the methods from the base class:
        User gosho = new Editor("Gosho", 6, 67);
        // user.getNumberOfArticles(); // error - there is no such method in User

        //3. Call identify() from different users - most specific version of the method is invoked:
        for (User user : users) {
            System.out.println(user.identify());
        }

        //3. Bad practice of using instanceof - we should use proper methods and override them (in this case - toString())
        badPracticeDemo();

    }

    private static void badPracticeDemo() {
        User[] users = generateListOfUsers();

        for (User user : users) {
            if (user instanceof Editor) {
                Editor editor = (Editor) user;
                System.out.printf(
                        "Editor with name: %s, workID: %d and number of published articles: %d %n",
                        editor.getName(),
                        editor.getStaffId(),
                        editor.getNumberOfArticles());

            } else if (user instanceof Staff) {
                Staff staff = (Staff) user;
                System.out.printf(
                        "Staff member with name: %s and workID: %d %n",
                        staff.getName(),
                        staff.getStaffId());

            } else if (user instanceof User) {
                System.out.println("User with name: " + user.getName());

            }
        }
    }

    private static User[] generateListOfUsers() {
        return new User[]{
                new User("Ivan"),
                new Staff("Georgi", 1),
                new Editor("Pesho", 2, 23)
        };
    }
}
