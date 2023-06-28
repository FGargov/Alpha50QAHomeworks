import java.util.Scanner;

public class RectangleArea {
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line1 = scanner.nextLine();
        String line2 = scanner.nextLine();

        int width = Integer.parseInt(line1);
        int height = Integer.parseInt(line2);

        int area = width * height;

        System.out.println(area);
    }
}