package com.sims.model;

import java.io.Serializable;

public class User implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private String role;
    private Student student;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String toString() {
        return this.getId() + "|" + this.getUsername() + "|" + this.getPassword() + "|" + this.getRole() + "|" + (this.getStudent()!=null ? this.getStudent().getId() : 0);
    }

}
