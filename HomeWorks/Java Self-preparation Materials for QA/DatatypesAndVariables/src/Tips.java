import java.util.Scanner;

public class Tips {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();

        int price = Integer.parseInt(line);
        double tip = 0.1 * price;

        double result = price + tip;

        System.out.printf("%.0f", result);
    }
}
