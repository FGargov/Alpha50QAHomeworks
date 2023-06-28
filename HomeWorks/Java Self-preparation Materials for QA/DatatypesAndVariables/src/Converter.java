import java.util.Scanner;

public class Converter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();

        double kmPerLitre = 1.6 / (4.54 / m);
        int litersPer100km = (int)Math.floor(100 / kmPerLitre);
        System.out.printf("%d litres per 100 km", litersPer100km);
    }
}
