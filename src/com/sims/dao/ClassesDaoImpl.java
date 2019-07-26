package com.sims.dao;

import com.sims.model.Classes;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClassesDaoImpl implements ClassesDao {
    private static String classFile = "../data/class.txt";
    private List<Classes> classes;

    public ClassesDaoImpl(){
        this.classes = readFile();
    }

    public List<Classes> readFile(){
        File file = new File(getClass().getResource(classFile).getFile());
        List<Classes> list = new ArrayList<>();
        try(Scanner sc = new Scanner(file)) {
            while(sc.hasNextLine()){
                String[] arr = sc.nextLine().split("\\|");
                Classes classes = new Classes();
                classes.setId(Integer.parseInt(arr[0]));
                classes.setName(arr[1]);

                list.add(classes);
            }
        } catch (Exception e) {
            System.out.println("Got an exception!");
        }
        return list;
    }

    @Override
    public List<Classes> getList(){
        return classes;
    }

    @Override
    public Classes getClassById(Integer id){
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
