package com.sims.service;

import com.sims.dao.ClassesDao;
import com.sims.dao.ClassesDaoImpl;
import com.sims.model.Classes;

import java.util.List;

public class ClassesServiceImpl implements ClassesService {
    private ClassesDao classesDao;

    public ClassesServiceImpl(){
        this.classesDao = new ClassesDaoImpl();
    }
    @Override
    public List<Classes> getList(){
        return classesDao.getList();
    }
}
