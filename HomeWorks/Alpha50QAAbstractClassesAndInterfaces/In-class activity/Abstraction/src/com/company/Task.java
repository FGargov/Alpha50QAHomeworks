package com.company;

import java.time.LocalDate;

public class Task extends BoardItem {

    private static final int ASSIGNEE_MIN_LENGTH = 5;
    private static final int ASSIGNEE_MAX_LENGTH = 30;

    private String assignee;

    public Task(String title, String assignee, LocalDate dueDate) {
        super(title, dueDate);
        setAssignee(assignee);
        this.status = Status.TODO;
    }
    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        ensureValidAssignee(assignee);
        this.assignee = assignee;
      //  logEvent(String.format("Assignee changed from %s to %s", this.getAssignee(), assignee));
    }

    private void ensureValidAssignee(String assignee) {
        if (assignee.length() < ASSIGNEE_MIN_LENGTH || assignee.length() > ASSIGNEE_MAX_LENGTH) {
            throw new IllegalArgumentException(String.format(
                    "The assignee's name must be between %d and %d characters.",
                    ASSIGNEE_MIN_LENGTH, ASSIGNEE_MAX_LENGTH));
        }
    }

    @Override
    public void advanceStatus() {
        if (getStatus() != Status.VERIFIED) {
            this.status = Status.values()[status.ordinal() + 1];
            logEvent("Task status changed from " + Status.values()[status.ordinal() - 1] + " to " + status);
        } else {
            logEvent("Can't advance, already at Verified");
        }
    }

    @Override
    public void revertStatus() {
        if (status != Status.TODO) {
            status = Status.values()[status.ordinal() - 1];
            logEvent("Task status changed from " + Status.values()[status.ordinal() + 1] + " to " + status);
        } else {
            logEvent("Can't revert, already at To Do");
        }
    }
}
