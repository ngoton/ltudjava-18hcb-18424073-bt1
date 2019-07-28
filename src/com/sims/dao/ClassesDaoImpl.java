package com.sims.dao;

import com.sims.model.Classes;
import java.util.ArrayList;
import java.util.List;

public class ClassesDaoImpl extends IOFileDao implements ClassesDao {
    private static String classFile = "../data/class.txt";

    @Override
    public List<Classes> getList(){
        List<Classes> list = new ArrayList<>();
        List<String[]> data = readFile(classFile);
        for (String[] arr : data){
            Classes classes = new Classes();
            classes.setId(Integer.parseInt(arr[0]));
            classes.setName(arr[1]);

            list.add(classes);
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
