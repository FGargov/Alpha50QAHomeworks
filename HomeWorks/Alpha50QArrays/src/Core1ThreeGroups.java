import java.util.ArrayList;
import java.util.Scanner;

public class Core1ThreeGroups {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        ArrayList<Integer> groupZero = new ArrayList<>();
        ArrayList<Integer> groupOne = new ArrayList<>();
        ArrayList<Integer> groupTwo = new ArrayList<>();

        for (String numberStr : input) {
            int number = Integer.parseInt(numberStr);
            int reminder = number % 3;

            if (reminder == 0) {
                groupZero.add(number);
            } else if (reminder == 1) {
                groupOne.add(number);
            } else {
                groupTwo.add(number);
            }
        }

        printGroupZero(groupZero);
        printGroupOne(groupOne);
        printGroupTwo(groupTwo);

//        System.out.println(String.join(" ", groupZero.toString()));
//        System.out.println(String.join(" ", groupOne.toString()));
//        System.out.println(String.join(" ", groupTwo.toString()));

        /*for (String numberStr : input) {
            int number = Integer.parseInt(numberStr);
            int remainder = number % 3;

            if (remainder == 0) {
                group0.add(number);
            } else if (remainder == 1) {
                group1.add(number);
            } else {
                group2.add(number);
            }
        }*/

        /*System.out.println(String.join(" ", group0.toString().replaceAll("[\\[\\],]", "")));
        System.out.println(String.join(" ", group1.toString().replaceAll("[\\[\\],]", "")));
        System.out.println(String.join(" ", group2.toString().replaceAll("[\\[\\],]", "")));*/
    }

    private static void printGroupTwo(ArrayList<Integer> groupTwo) {
        for (int i = 0; i < groupTwo.size(); i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(groupTwo.get(i));
        }
    }

    private static void printGroupOne(ArrayList<Integer> groupOne) {
        for (int i = 0; i < groupOne.size(); i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(groupOne.get(i));
        }
        System.out.println();
    }

    private static void printGroupZero(ArrayList<Integer> groupZero) {
        for (int i = 0; i < groupZero.size(); i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(groupZero.get(i));
        }
        System.out.println();
    }
}
