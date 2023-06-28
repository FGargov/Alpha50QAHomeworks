package com.company.oop.constructors;

public class Editor extends Staff {
    private int numberOfArticles;

    public Editor(String name, int staffId, int numberOfArticles) {
        super(name, staffId);
        this.numberOfArticles = numberOfArticles;
        System.out.println("Editor constructor - ready");
    }

    public int getNumberOfArticles() {
        return numberOfArticles;
    }
}
