package com.sims.model;

import java.io.Serializable;

public class Student implements Serializable {
    private Integer id;
    private String code;
    private String name;
    private String gender;
    private String idNumber;
    private Classes studentClass;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Classes getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(Classes studentClass) {
        this.studentClass = studentClass;
    }

    public Object[] toObject() {
        return new Object[]{
                this.getId(), this.getCode(), this.getName(), this.getGender(), this.getIdNumber(), this.getStudentClass().getName()
        };
    }
}
