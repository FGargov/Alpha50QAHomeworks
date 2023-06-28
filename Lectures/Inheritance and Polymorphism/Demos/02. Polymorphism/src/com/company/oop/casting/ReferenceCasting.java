package com.company.oop.casting;

import com.company.oop.polymorphism.Editor;
import com.company.oop.polymorphism.Staff;
import com.company.oop.polymorphism.User;

public class ReferenceCasting {
    public static void main(String[] args) {
        //new Staff and Editor objects are implicitly cast to User
        // in order to be added in User array
        User[] users = new User[]{
                new Staff("Georgi", 1),
                new Editor("Pesho", 2, 23)
        };

        //explicit cast to Editor - code will compile but we will get error runtime because first element in the array is not Editor
        for (User user : users) {
            System.out.println(user);
            System.out.println(user.identify());
            //((Editor) user).getNumberOfArticles();
        }
    }
}
