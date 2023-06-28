import java.util.Scanner;

public class SumPositive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int result = n * (n + 1) / 2;
        System.out.println(result);
    }
}
