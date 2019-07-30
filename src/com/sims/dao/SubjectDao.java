package com.sims.dao;

import com.sims.model.Subject;

import java.util.List;

public interface SubjectDao {
    List<Subject> getList();
    Subject getSubjectById(Integer id);
    Subject getSubjectByName(String name);
    Subject getSubjectByCode(String code);
    boolean addOne(Subject subject);
}
