import java.util.Scanner;

public class TIme {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int d = scanner.nextInt();
        int h = scanner.nextInt();
        int m = scanner.nextInt();
        int s = scanner.nextInt();

        int totalSeconds = (d * 86400) + (h * 3600) + (m * 60) + (s * 1);
        System.out.println(totalSeconds);
    }
}
