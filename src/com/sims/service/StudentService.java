package com.sims.service;

import com.sims.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getList();
    boolean save(List<Student> students);
    boolean deleteAll();
    List<Student> importFile(String path);
}
