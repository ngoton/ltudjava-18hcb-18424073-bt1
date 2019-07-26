package com.sims.dao;

import java.io.*;
import java.util.ArrayList;

public class IOFileDao {
    public ArrayList readFile( String file){
        ArrayList list = new ArrayList();
        try(FileInputStream out = new FileInputStream(new File(file))) {
            ObjectInputStream oos = new ObjectInputStream(out);
            list = (ArrayList) oos.readObject();
        } catch (Exception e) {
            System.out.println("Got an exception!");
        }
        return list;
    }
    public void writeFile(ArrayList list, String file){
        try(FileOutputStream out = new FileOutputStream(new File(file))) {
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(list);
        } catch (Exception e) {
            System.out.println("Got an exception!");
        }
    }

}
