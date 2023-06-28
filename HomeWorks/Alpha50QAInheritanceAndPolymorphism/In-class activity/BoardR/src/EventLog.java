import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EventLog {
    public static final String INVALID_DESCRIPTION = "Description cannot be empty";
    private final String description;
    private final LocalDateTime timestamp;

    public EventLog(String description) {
        validateDescriptionLength(description);
        this.description = description;
        this.timestamp = LocalDateTime.now();
    }

    public EventLog() {
        throw new IllegalArgumentException(INVALID_DESCRIPTION);
    }
//Note: Since description and timestamp are final, they cannot be changed, i.e. they do not need setters.
    public String getDescription() {
        return description;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public static void validateDescriptionLength(String description) {
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException(INVALID_DESCRIPTION);
        }
    }
    public String viewInfo() {
        /*DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy HH:mm:ss");
        return "[" + timestamp.format(formatter) + "] " + description;*/
        return String.format("[%d-%s-%d %d:%d:%d] %s",
                timestamp.getDayOfMonth(),
                timestamp.getMonth(),
                timestamp.getYear(),
                timestamp.getHour(),
                timestamp.getMinute(),
                timestamp.getSecond(),
                description);
    }
}
