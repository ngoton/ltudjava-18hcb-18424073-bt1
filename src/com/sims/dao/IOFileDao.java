package com.sims.dao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOFileDao<T> {
    public List<T> readFile(String path){
        File file = new File(getClass().getResource(path).getFile());
        List<T> list = new ArrayList<>();
        String thisLine;
        try(FileReader fr = new FileReader(file)){
            try(BufferedReader br = new BufferedReader(fr)) {
                while((thisLine = br.readLine()) != null){
                    T arr = (T)thisLine.split("\\|");

                    list.add(arr);
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
    public boolean writeFile(List<T> data, String path){
        File file = new File(getClass().getResource(path).getFile());
        try(FileWriter fw = new FileWriter(file, false)) {
            try (BufferedWriter bw = new BufferedWriter(fw)) {
                if (data == null){
                    bw.write("");
                }
                else {
                    for (T s : data) {
                        bw.write(s.toString());
                        bw.newLine();
                    }
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
