package com.sims.model;

import java.io.Serializable;

public class Attendance implements Serializable {
    private Integer id;
    private Student student;
    private Calendar calendar;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public String toString() {
        return this.getId() + "|" + this.getStudent().getId() + "|" + this.getCalendar().getId();
    }
}
