import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        BoardItem item = new BoardItem("Registration doesn't work", LocalDate.now().plusDays(2));
        System.out.println(item.title);
        System.out.println(item.dueDate);
        System.out.println(item.status);


       /* BoardItem item = new BoardItem("Registration doesn't work", LocalDate.now().plusDays(2));
        System.out.println(item.status);
        item.advanceStatus();
        System.out.println(item.status);
        item.advanceStatus();
        System.out.println(item.status);
        item.revertStatus();
        System.out.println(item.status);*/


        /*BoardItem item = new BoardItem("Registration doesn't work", LocalDate.now().plusDays(2));
        System.out.println(item.viewInfo());*/


        /*BoardItem item = new BoardItem("Registration doesn't work", LocalDate.now().plusDays(2));
        item.advanceStatus();
        BoardItem anotherItem = new BoardItem("Encrypt user data", LocalDate.now().plusDays(10));

        *//*Board.items.add(item);
        Board.items.add(anotherItem);*//*

        Board.items.add(item);
        Board.items.add(anotherItem);

        for (BoardItem boardItem : Board.items) {
            boardItem.advanceStatus();
        }

        for (BoardItem boardItem : Board.items) {
            System.out.println(boardItem.viewInfo());
        }*/
    }
}