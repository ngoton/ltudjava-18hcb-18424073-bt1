package com.sims.dao;

import com.sims.model.Classes;
import com.sims.model.Student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClassesDaoImpl implements ClassesDao {
    private static String classFile = "../data/class.txt";

    @Override
    public List<Classes> getList(){
        File file = new File(getClass().getResource(classFile).getFile());
        List<Classes> list = new ArrayList<>();
        String thisLine;
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            while((thisLine = br.readLine()) != null){
                String[] arr = thisLine.split("\\|");
                Classes classes = new Classes();
                classes.setId(Integer.parseInt(arr[0]));
                classes.setName(arr[1]);

                list.add(classes);
            }
        } catch (IOException e) {
            System.out.println("Got an exception!");
        }
        return list;
    }

    @Override
    public Classes getClassById(Integer id){
        List<Classes> classes = this.getList();
        Classes cls = null;
        for (Classes c : classes){
            if (id.equals(c.getId())){
                cls = new Classes();
                cls = c;
            }
        }
        return cls;
    }

    @Override
    public Classes getClassByName(String name){
        List<Classes> classes = this.getList();
        Classes cls = null;
        for (Classes c : classes){
            if (name.equals(c.getName())){
                cls = new Classes();
                cls = c;
            }
        }
        return cls;
    }
}
