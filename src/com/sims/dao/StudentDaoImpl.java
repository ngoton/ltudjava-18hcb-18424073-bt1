package com.sims.dao;

import com.sims.model.Classes;
import com.sims.model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl extends IOFileDao implements StudentDao {
    private static String studentFile = "../data/student.txt";
    private ClassesDao classesDao;

    public StudentDaoImpl(){
        this.classesDao = new ClassesDaoImpl();
    }

    @Override
    public List<Student> getList(){
        List<Student> list = new ArrayList<>();
        List<String[]> data = readFile(studentFile);
        for (String[] arr : data){
            Student student = new Student();
            student.setId(Integer.parseInt(arr[0]));
            student.setCode(arr[1]);
            student.setName(arr[2]);
            student.setGender(arr[3]);
            student.setIdNumber(arr[4]);

            Classes classes = classesDao.getClassById(Integer.parseInt(arr[5]));
            student.setStudentClass(classes);

            list.add(student);
        }

        return list;
    }

    @Override
    public boolean save(List<Student> students){
        return writeFile(students, studentFile);
    }

    @Override
    public boolean deleteAll(){
        return writeFile(null, studentFile);
    }
}
