package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class BoardItem {

    private static final int TITLE_MIN_LENGTH = 5;
    private static final int TITLE_MAX_LENGTH = 30;
    private static final Status INITIAL_STATUS = Status.OPEN;
    private static final Status FINAL_STATUS = Status.VERIFIED;

    private String title;
    public Status status;
    private LocalDate dueDate;
    private final List<EventLog> history = new ArrayList<>();

    public BoardItem(String title, LocalDate dueDate) {
        this(title, dueDate, INITIAL_STATUS);
    }

    public BoardItem(String title, LocalDate dueDate, Status status) {
        validateDueDate(dueDate);
        validateTitle(title);

        setTitle(title);
        setStatus(status);
        setDueDate(dueDate);

        this.logEvent(String.format("Item created: %s", this.viewInfo()));
    }

    public Status getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        validateTitle(title);

       // this.logEvent(String.format("Title changed from %s to %s", this.getTitle(), title));

        this.title = title;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        validateDueDate(dueDate);

       // this.logEvent(String.format("DueDate changed from %s to %s", this.getDueDate(), dueDate));

        this.dueDate = dueDate;
    }

    public void setStatus(Status status) {
       // this.logEvent(String.format("Status changed from %s to %s", this.getStatus(), status));
        this.status = status;
    }

    public abstract void advanceStatus();
    public abstract void revertStatus();

    public String viewInfo() {
        return String.format("'%s', [%s | %s]", this.title, this.status, this.dueDate);
    }

    public void displayHistory() {
        for (EventLog log : history) {
            System.out.println(log.viewInfo());
        }
    }

    protected void logEvent(String event) {
        this.history.add(new EventLog(event));
    }

    private void validateTitle(String title) {
        if (title.length() < TITLE_MIN_LENGTH || title.length() > TITLE_MAX_LENGTH) {
            throw new IllegalArgumentException(String.format(
                    "Please provide a title with length between %d and %d chars",
                    TITLE_MIN_LENGTH, TITLE_MAX_LENGTH));
        }
    }

    private void validateDueDate(LocalDate dueDate) {
        if (dueDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("DueDate can't be in the past");
        }
    }

}
