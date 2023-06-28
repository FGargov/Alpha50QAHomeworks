import java.text.DateFormat;
import java.time.LocalDate;

public class BoardItem {
    public String title;
    public LocalDate dueDate;
    public Status status;

    public BoardItem(String title, LocalDate dueDate) {
        if (title == null || title == "" || title.length() < 5 || title.length() > 30) {
            System.out.println("Title must not be null, empty and length should be between [5, 30]");
        }
        if (dueDate.isBefore(LocalDate.now())) {
            System.out.println("Due date must not be null or in the past");
        }
        this.title = title;
        this.dueDate = dueDate;
        this.status = Status.OPEN;
    }

    public void revertStatus() {
        if (status != Status.OPEN) {
            status = status.previous();
        }
    }

    public void advanceStatus() {
        if (status != Status.VERIFIED) {
            status = status.next();
        }
    }

    public String viewInfo() {
        return "'" + title + "', " + "[" + status + " | " + dueDate + "]";
    }
}
