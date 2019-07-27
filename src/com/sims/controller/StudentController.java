package com.sims.controller;

import com.sims.model.Classes;
import com.sims.model.Student;
import com.sims.service.ClassesService;
import com.sims.service.ClassesServiceImpl;
import com.sims.service.StudentService;
import com.sims.service.StudentServiceImpl;
import com.sims.view.StudentForm;
import java.util.List;

public class StudentController {
    private StudentForm studentForm;
    private StudentService studentService;
    private ClassesService classesService;

    public StudentController(StudentForm studentForm){
        this.studentForm = studentForm;
        this.studentService = new StudentServiceImpl();
        this.classesService = new ClassesServiceImpl();
    }

    public List<Student> getList(){
        return studentService.getList();
    }

    public List<Classes> getClassList(){
        return classesService.getList();
    }

    public String update(List<Student> students){
        String result = "Lưu thất bại!";
        if (studentService.update(students)){
            result = "Lưu thành công!";
        }
        return result;
    }
}
