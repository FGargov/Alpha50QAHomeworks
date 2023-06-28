import java.util.Scanner;
public class RotateList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int n = scanner.nextInt();

        String[] numbers = input.split(",");
        int length = numbers.length;
        int rotations = n % length;

        for (int i = 0; i < rotations; i++) {
            String first = numbers[0];
            for (int j = 1; j < length; j++) {
                numbers[j - 1] = numbers[j];
            }
            numbers[length - 1] = first;
        }

        //Console.WriteLine(String.Join(",", numbers));
        System.out.println(String.join(",", numbers));
    }
}
