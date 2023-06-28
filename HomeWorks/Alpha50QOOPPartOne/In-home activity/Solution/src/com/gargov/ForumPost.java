package com.gargov;

import java.util.ArrayList;

public class ForumPost {
     String author;
     String text;
     int upVotes;

    public ArrayList<String> replies;

    public ForumPost(String author, String text, int upVotes) {
        this.author = author;
        this.text = text;
        this.upVotes = upVotes;
        replies = new ArrayList<String>();
    }

    public ForumPost(String author, String text) {
        this(author, text, 0);
    }

    /*public String format() {
            return String.format("%s / by %s, %d votes. %n", text, author, upVotes);
       }*/

    public String format() {
        String result = String.format("%s / by %s, %d votes. %n", text, author, upVotes);
        for (String reply : replies) {
            result += String.format("- %s%n", reply);
        }
        return result;
    }
}
