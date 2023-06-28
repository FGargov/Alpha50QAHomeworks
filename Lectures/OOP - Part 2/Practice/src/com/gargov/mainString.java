package com.gargov;

public class mainString {
    public static void main(String[] args) {
        char[] charArray = new char[]{'H', 'e', 'l', 'l', 'o'};
        String message = String.valueOf(charArray);
        System.out.println(message);

        char[] charArrayTwo = message.toCharArray();
        System.out.println(charArrayTwo);
        System.out.println(charArrayTwo[1]);

        StringBuilder sb = new StringBuilder();
        sb.append("Telerik");
        sb.append(" Academy");
        String output = sb.toString();
        System.out.println(output);

        String str = "Telerik Academy <<Alpha>>";
        String sub = str.substring(18, 23);
        System.out.println(sub);
        String replace = output.replace("Telerik", "Alpha");
        System.out.println(replace);

        String alpha = "AlPha";
        String alpha2 = "Alpha";
        System.out.println(alpha.equals(alpha2)); //false
        System.out.println(alpha.equalsIgnoreCase(alpha2)); // true
    }
}
