package com.sims.dao;

import com.sims.model.Classes;

import java.util.List;

public interface ClassesDao {
    List<Classes> getList();
    Classes getClassById(Integer id);
    Classes getClassByName(String name);
}
