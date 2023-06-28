import java.util.Scanner;

public class MirrorCodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        /*int mirrorA = ((a % 10) * 100) + (((a / 10) % 10) * 10) + (a / 100);
        int mirrorB = ((b % 10) * 100) + (((b / 10) % 10) * 10) + (b / 100);*/

        int ones = a % 10; // Extract the ones digit
        int tens = (a / 10) % 10; // Extract the tens digit
        int hundreds = a / 100; // Extract the hundreds digit
        int mirrorA = (ones * 100) + (tens * 10) + hundreds;

        int onesB = b % 10; // Extract the ones digit
        int tensB = (b / 10) % 10; // Extract the tens digit
        int hundredsB = b / 100; // Extract the hundreds digit
        int mirrorB = (onesB * 100) + (tensB * 10) + hundredsB;

        int pinCode = Math.max(mirrorA, mirrorB);
        System.out.println(pinCode);
    }
}
