package com.sims.service;

import com.sims.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getList();
    boolean update(List<Student> students);
}
