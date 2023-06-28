import java.util.Scanner;

public class CombineLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstListArray = scanner.nextLine().split(",");
        String[] secondListArray = scanner.nextLine().split(",");

        String[] result = new String[firstListArray.length + secondListArray.length];// По условие искат двоен масив.

        int position = 0;

        for (int i = 0; i < firstListArray.length; i++) {
            result[position] = firstListArray[i];
            position++;
            result[position] = secondListArray[i];
            position++;
        }

        //Console.WriteLine(String.Join(",", result));
        System.out.println(String.join(",", result));
    }
}
