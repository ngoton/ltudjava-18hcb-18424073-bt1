package com.sims.dao;

import com.sims.model.Classes;
import com.sims.model.Student;

import java.io.*;
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
        String thisLine;
        try(FileReader fr = new FileReader(file)){
            try(BufferedReader br = new BufferedReader(fr)) {
                while((thisLine = br.readLine()) != null){
                    String[] arr = thisLine.split("\\|");
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
                br.close();
                fr.close();
            } catch (IOException e) {
                System.out.println("Got an exception!");
            }
        }catch (IOException e){
            System.out.println("File not found!");
        }

        return list;
    }

    @Override
    public boolean update(List<Student> students){
        File file = new File(getClass().getResource(studentFile).getFile());
        try(FileWriter fw = new FileWriter(file, false)) {
            try (BufferedWriter bw = new BufferedWriter(fw)) {
                for (Student s : students) {
                    bw.write(s.toString());
                    bw.newLine();
                }
                bw.close();
                fw.close();
                return true;
            }catch (IOException e){
                System.out.println("Got an exception!");
            }
        }catch (IOException e){
            System.out.println("File not found!");
        }

        return false;
    }
}
