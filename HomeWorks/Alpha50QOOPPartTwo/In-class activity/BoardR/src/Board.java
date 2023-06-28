import java.util.ArrayList;

public class Board {
    private static ArrayList<BoardItem> items = new ArrayList<>();

    public Board() { // default constructor
    }

    public void addItem(BoardItem item) {
        if (items.contains(item)) {
            int count = 1;
            String output = String.format("item%d already in the list", count++);
            throw new IllegalArgumentException(output);
        }

        items.add(item);
    }

    public int totalItems() {
        return items.size();
    }
}
