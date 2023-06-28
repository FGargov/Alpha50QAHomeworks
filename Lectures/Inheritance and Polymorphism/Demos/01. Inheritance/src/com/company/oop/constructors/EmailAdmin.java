package com.company.oop.constructors;

import java.util.ArrayList;
import java.util.List;

public class EmailAdmin extends Staff {
    private List<String> emails;

    public EmailAdmin(String name, int staffId) {
        super(name, staffId);
        emails = new ArrayList<>();
    }

    //there is no reason for derived classes to be able to override this method
    public final List<String> getEmails() {
        //return copy of our collection to prevent outside manipulation
        return new ArrayList<>(emails);
    }

    public void addNewEmail(String email) {
        emails.add(email);
    }
}
