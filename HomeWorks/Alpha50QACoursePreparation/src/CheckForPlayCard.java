import java.util.Scanner;

public class CheckForPlayCard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String cardFaces = "2 3 4 5 6 7 8 9 10 J Q K A";

        boolean isValidCardFace = cardFaces.contains(input.toUpperCase());

        if (isValidCardFace) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}