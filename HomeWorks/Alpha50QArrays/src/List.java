import java.util.ArrayList;

public class List {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }

        list.set(0, 20);

        System.out.println(list.get(2));
        System.out.println(list.size());

        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%d ", list.get(i));
        }

        list.set(5, 10);// Throw IndexOutOfBoundsException
    }
}
