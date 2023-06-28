import java.util.Scanner;

public class ElectronicMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int maxLength = 0;
        int currentLength = 0;

        for (char c : input.toCharArray()) {
            if (c == '.') {
                break;
            } else if (Character.isLetter(c) || Character.isDigit(c) || c == ' ') {
                currentLength = 0;
            } else {
                currentLength++;
                maxLength = Math.max(maxLength, currentLength);
            }
        }

        System.out.println(maxLength);
    }
}
