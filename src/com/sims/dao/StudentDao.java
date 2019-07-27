package com.sims.dao;

import com.sims.model.Student;

import java.util.List;

public interface StudentDao {
    List<Student> getList();
    boolean update(List<Student> students);
}
