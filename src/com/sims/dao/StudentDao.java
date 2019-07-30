package com.sims.dao;

import com.sims.model.Student;

import java.util.List;

public interface StudentDao {
    List<Student> getList();
    Student getStudentById(Integer id);
    Student getStudentByCode(String code);
    boolean save(List<Student> students);
    boolean deleteAll();
    List<Student> importFile(String path);
}
