import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();

        int first = Integer.parseInt(Character.toString(number.charAt(0)));
        int second = Integer.parseInt(Character.toString(number.charAt(1)));
        int third = Integer.parseInt(Character.toString(number.charAt(2)));

        int a = first + second + third;
        int b = first * second * third;
        int c = first * second + third;
        int d = first + second * third;

        int max1 = Math.max(a, b);
        int max2 = Math.max(c, d);

        int result = Math.max(max1, max2);

        System.out.println(result);
    }
}

