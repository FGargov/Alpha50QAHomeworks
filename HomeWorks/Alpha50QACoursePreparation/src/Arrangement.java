import java.util.Scanner;

public class Arrangement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int h1 = scanner.nextInt();
        int h2 = scanner.nextInt();
        int h3 = scanner.nextInt();
        int h4 = scanner.nextInt();

        if (h1 < h2 && h2 < h3 && h3 < h4) {
            System.out.println("Ascending");
        } else if (h1 > h2 && h2 > h3 && h3 > h4) {
            System.out.println("Descending");
        } else {
            System.out.println("Mixed");
        }

    }
}
