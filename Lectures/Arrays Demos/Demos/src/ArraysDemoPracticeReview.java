import java.util.Arrays;
import java.util.Scanner;

public class ArraysDemoPracticeReview {
    public static void main(String[] args) {
        int[] array1 = new int[5];

        int[] array2 = {1, 2, 3, 4, 5};
        int[] array123 = array2;

        int[] array3 = new int[5];
        for (int i = 0; i < array3.length; i++) {
            array3[i] = i * 2;
        }


        System.out.println("Enter array size and then each element on a new line:");
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int size = Integer.parseInt(line);
        int[] array4 = new int[size];
        for (int i = 0; i < size; i++) {
           // line = sc.nextLine();
            array4[i] = Integer.parseInt(sc.nextLine());
        }
        System.out.println(Arrays.toString(array4));


        System.out.println("Enter array on a single line using space for delimiter:");
        line = sc.nextLine();
        String[] strArray = line.split(" ");
        int[] array5 = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            array5[i] = Integer.parseInt(strArray[i]);
        }
        // print array on the console
        for (int i = 0; i < array5.length; i++) {
            System.out.printf("%d ", array5[i]);
        }
        System.out.println();

        //print array on the console
        System.out.println(Arrays.toString(array5));
    }
}
