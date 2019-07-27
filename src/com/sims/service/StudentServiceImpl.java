package com.sims.service;

import com.sims.dao.StudentDao;
import com.sims.dao.StudentDaoImpl;
import com.sims.model.Student;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao;

    public StudentServiceImpl(){
        this.studentDao = new StudentDaoImpl();
    }

    @Override
    public List<Student> getList(){
        return studentDao.getList();
    }

    @Override
    public boolean update(List<Student> students){
        return studentDao.update(students);
    }
}
