package com.company.oop.constructors.practice;

import java.util.ArrayList;
import java.util.List;

public class EmailAdmin extends Staff {
    private List<String> emails;

    public EmailAdmin(String name, int staffId) {
        super(name, staffId);
        emails = new ArrayList<>();
    }

    public final List<String> getEmails() {
        return new ArrayList<>(emails);
    }

    public void addNewEmail(String email) {
        emails.add(email);
    }
}
