import java.util.Scanner;

public class ConvertDegrees {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] tokens = input.split(" ");
        int[] celsiuses = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            celsiuses[i] = Integer.parseInt(tokens[i]);
        }
        for (int celsius : celsiuses) {
            int fahrenheit = (int) Math.round((celsius * 1.8) + 32);
            System.out.println(fahrenheit);
        }
    }
}
