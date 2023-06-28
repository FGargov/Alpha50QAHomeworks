import java.util.ArrayList;
import java.util.Scanner;

public class ArraysListDemoPracticeReview {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.set(1, 20);
        System.out.println(arrayList); //Print list #1
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.printf("%d ", arrayList.get(i));  //Print list #2
        }
        System.out.println();

        System.out.println("Enter array on a single line using space for delimiter:");
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] strArray = line.split(" ");
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        for (int i = 0; i < strArray.length; i++) {
            arrayList1.add(Integer.parseInt(strArray[i]));
        }
        for (int i = 0; i < arrayList1.size(); i++) {
            System.out.printf("%d ", arrayList1.get(i));
        }
        System.out.println();
        System.out.println(arrayList1);
    }
}
