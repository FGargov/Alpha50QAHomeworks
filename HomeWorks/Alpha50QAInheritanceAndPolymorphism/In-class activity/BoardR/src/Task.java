import java.time.LocalDate;

public class Task extends BoardItem {
    public static final int MIN_ASSIGNEE_LENGTH = 5;
    public static final int MAX_ASSIGNEE_LENGTH = 30;
    private String assignee;

    public Task(String title, String assignee, LocalDate dueDate) {
        super(title, Status.TODO.toString(), dueDate);
        setAssignee(assignee);
        super.advanceStatus();
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        if (assignee == null || assignee.isEmpty()) {
            throw new IllegalArgumentException("Assignee cannot be empty");
        }

        if (assignee.length() < MIN_ASSIGNEE_LENGTH || assignee.length() > MAX_ASSIGNEE_LENGTH){
            System.out.printf("Assignee should be between %d adn %d symbols.", MIN_ASSIGNEE_LENGTH, MAX_ASSIGNEE_LENGTH);
        }
        this.assignee = assignee;
    }
}

