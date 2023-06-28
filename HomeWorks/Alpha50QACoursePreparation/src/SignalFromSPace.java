import java.util.Scanner;

public class SignalFromSPace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();

        StringBuilder decodedMessage = new StringBuilder();
        char prevChar = message.charAt(0);
        decodedMessage.append(prevChar);

        for (int i = 1; i < message.length(); i++) {
            char currentChar = message.charAt(i);
            if (currentChar != prevChar) {
                decodedMessage.append(currentChar);
                prevChar = currentChar;
            }
        }

        System.out.println(decodedMessage);
    }
}
