package com.sims.dao;

import com.sims.model.Classes;
import com.sims.model.Student;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentDaoImpl implements StudentDao {
    private static String studentFile = "../data/student.txt";
    private ClassesDao classesDao;

    public StudentDaoImpl(){
        this.classesDao = new ClassesDaoImpl();
    }

    @Override
    public List<Student> getList(){
        File file = new File(getClass().getResource(studentFile).getFile());
        List<Student> list = new ArrayList<>();
        try(Scanner sc = new Scanner(file)) {
            while(sc.hasNextLine()){
                String[] arr = sc.nextLine().split("\\|");
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
        } catch (Exception e) {
            System.out.println("Got an exception!");
        }
        return list;
    }

    @Override
    public boolean update(List<Student> students){
        File file = new File(getClass().getResource(studentFile).getFile());
        try(PrintWriter pw = new PrintWriter(file)) {
            for (Student s : students){
                pw.write(s.toString());
            }
            pw.flush();
            pw.close();
            return true;
        }catch (Exception e){
            System.out.println("Got an exception!");
        }

        return false;
    }
}
