package com.shashanksirmour.me;

import java.time.LocalDate;

public class data {
    String shortNote;
    String detail;
    private LocalDate deadline;


    public data(String shortNote, String detail, LocalDate deadline) {
        this.shortNote = shortNote;
        this.detail = detail;
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return shortNote;
    }

    public String getShortNote() {
        return shortNote;
    }

    public void setShortNote(String shortNote) {
        this.shortNote = shortNote;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }
}
