package com.sims.service;

import com.sims.dao.SubjectDao;
import com.sims.dao.SubjectDaoImpl;
import com.sims.model.Subject;

import java.util.List;

public class SubjectServiceImpl implements SubjectService {
    private SubjectDao subjectDao;

    public SubjectServiceImpl(){
        this.subjectDao = new SubjectDaoImpl();
    }
    @Override
    public List<Subject> getList(){
        return subjectDao.getList();
    }
}
