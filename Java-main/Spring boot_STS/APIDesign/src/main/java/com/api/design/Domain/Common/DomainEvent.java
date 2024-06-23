package com.api.design.Domain.Common;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public abstract class DomainEvent {
    private boolean isPublished;
    private OffsetDateTime dateOccurred;

    protected DomainEvent() {
        dateOccurred = OffsetDateTime.now();
    }

    public boolean isPublished() {
        return isPublished;
    }

    public void setPublished(boolean published) {
        isPublished = published;
    }

    public OffsetDateTime getDateOccurred() {
        return dateOccurred;
    }

    protected void setDateOccurred(OffsetDateTime dateOccurred) {
        this.dateOccurred = dateOccurred;
    }

    public String getFormattedTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return dateOccurred.format(formatter);
    }
}
