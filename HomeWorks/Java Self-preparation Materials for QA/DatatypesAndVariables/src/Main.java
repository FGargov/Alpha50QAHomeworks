import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*char letter = 'a';
        char ch = 97;
        System.out.println(ch);
        System.out.println(letter);

        String text = "Hello";
        char firstChar = text.charAt(0);
        System.out.println(firstChar);

        //Parse from string to int

        String numberString = "123";
        int number = Integer.parseInt(numberString);
        System.out.println(number);

        Scanner input = new Scanner(System.in);
        int inputNumber = Integer.parseInt(input.nextLine());
        int square = inputNumber * inputNumber;
        System.out.printf("Square of %d is %d", number, square);*/

        //Exercise
        int n1 = 1;
        int n2 = 2;

        boolean greater = (n1 > n2);
        System.out.println(greater);
        //notice how lowercase L and digit one look the same
        //be careful when naming variables
        boolean equalN1To1 = (n1 == 1);
        System.out.println(equalN1To1);
    }
}