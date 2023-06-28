import java.time.LocalDate;

public class Issue extends BoardItem {
    private final String description;

    public Issue(String title, String description, LocalDate dueDate) {
        super(title, Status.OPEN.toString(), dueDate);
        this.description = description.isEmpty() ? "No description" : description;
    }

    public String getDescription() {
        return this.description;
    }

    @Override
    public void setDueDate(LocalDate newDueDate) {
        super.setDueDate(newDueDate);
    }
}