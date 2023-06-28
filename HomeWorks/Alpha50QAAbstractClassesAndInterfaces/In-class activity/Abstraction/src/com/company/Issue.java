package com.company;

import java.time.LocalDate;

public class Issue extends BoardItem {

    private String description;

    public Issue(String title, String description, LocalDate dueDate) {
        super(title, dueDate, Status.OPEN);
        setDescription(description);
        this.status = Status.OPEN;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description.isEmpty()) {
            this.description = "No description";
        } else {
            this.description = description;
        }
    }

    @Override
    public void advanceStatus() {
        if (status == Status.OPEN) {
            status = Status.VERIFIED;
            logEvent("Issue status set to Verified");
        } else {
            logEvent("Issue status already Verified");
        }
    }

    @Override
    public void revertStatus() {
        if (status == Status.VERIFIED) {
            status = Status.OPEN;
            logEvent("Issue status set to Open");
        } else {
            logEvent("Issue status already Open");
        }
    }

    @Override
    public String viewInfo() {
        String baseInfo = super.viewInfo();
        return String.format("Issue: %s, Description: %s", baseInfo, this.description);
    }
}
