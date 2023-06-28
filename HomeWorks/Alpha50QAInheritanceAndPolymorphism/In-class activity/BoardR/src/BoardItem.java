import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BoardItem {
    private static final int MIN_TITLE_LENGTH = 5;
    private static final int MAX_TITLE_LENGTH = 30;
    private String title;
    private LocalDate dueDate;
    private Status status;
    private final List<EventLog> history = new ArrayList<>();

    public BoardItem(String title, String status, LocalDate dueDate) {
        setTitle(title);
        setDueDate(dueDate);
        this.status = Status.OPEN;
        history.add(new EventLog("Item created: '" + title + "', [" + status + " | " + dueDate + "]"));
    }

    /*public BoardItem(String title, LocalDate dueDate, Status status) {
        this(title, dueDate);
        setStatus(status);
    }*/

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) { // Правя го public заради примера.
        if (title == null || title.length() < MIN_TITLE_LENGTH || title.length() > MAX_TITLE_LENGTH) {
            System.out.printf("Please provide a title with length between %d and %d chars", MIN_TITLE_LENGTH, MAX_TITLE_LENGTH);
        }

        this.title = title;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        if (dueDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Due date must not be null or in the past");
        }
        LocalDate oldDueDate = this.dueDate;
        this.dueDate = dueDate;
        history.add(new EventLog("DueDate changed from " + oldDueDate + " to " + dueDate));
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void advanceStatus() {
        if (status != Status.VERIFIED) {
            Status oldAdvanceStatus = status;
            status = status.next();
            history.add(new EventLog("Status changed from " + oldAdvanceStatus + " to " + status));
        } else {
            history.add(new EventLog("Can't advance, already at " + status));
        }
    }
    public void revertStatus() {
        if (status != Status.OPEN) {
            Status oldRevertStatus = status;
            status = status.previous();
            history.add(new EventLog("Status changed from " + oldRevertStatus + " to " + status));
        } else {
            history.add(new EventLog("Can't revert, already at " + status));
        }
    }

    public String viewInfo() {
        return "'" + title + "', " + "[" + status + " | " + dueDate + "]";
    }

    public String displayHistory(){
        StringBuilder sb = new StringBuilder();
        for (EventLog event: history) {
             sb.append(event.viewInfo()).append("\n");
        }

        return sb.toString();
    }

    public void addEventToHistory(String description) {
        this.history.add(new EventLog(description));
    }

}
