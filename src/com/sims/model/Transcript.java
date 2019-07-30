package com.sims.model;

import java.io.Serializable;

public class Transcript implements Serializable {
    private Integer id;
    private Student student;
    private Calendar calendar;
    private Float middleMark;
    private Float finalMark;
    private Float otherMark;
    private Float mark;

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

    public Float getMiddleMark() {
        return middleMark;
    }

    public void setMiddleMark(Float middleMark) {
        this.middleMark = middleMark;
    }

    public Float getFinalMark() {
        return finalMark;
    }

    public void setFinalMark(Float finalMark) {
        this.finalMark = finalMark;
    }

    public Float getOtherMark() {
        return otherMark;
    }

    public void setOtherMark(Float otherMark) {
        this.otherMark = otherMark;
    }

    public Float getMark() {
        return mark;
    }

    public void setMark(Float mark) {
        this.mark = mark;
    }

    public String toString() {
        return this.getId() + "|" + this.getStudent().getId() + "|" + this.getCalendar().getId() + "|" + this.getMiddleMark() + "|" + this.getFinalMark() + "|" + this.getOtherMark() + "|" + this.getMark();
    }
}
