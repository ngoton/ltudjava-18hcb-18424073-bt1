package com.sims.model;

import java.io.Serializable;

public class Calendar implements Serializable {
    private Integer id;
    private Classes classes;
    private Subject subject;
    private String room;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public String toString() {
        return this.getId() + "|" + this.getClasses().getId() + "|" + this.getSubject().getId() + "|" + this.getRoom();
    }
}
