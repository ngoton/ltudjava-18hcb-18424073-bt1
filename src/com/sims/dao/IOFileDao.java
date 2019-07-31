package com.sims.dao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOFileDao<T> {
    public List<T> readFile(String path, String regex){
        File file = new File(path);
        List<T> list = new ArrayList<>();
        String thisLine;
        try(FileReader fr = new FileReader(file)){
            try(BufferedReader br = new BufferedReader(fr)) {
                while((thisLine = br.readLine()) != null){
                    if(!thisLine.isEmpty()){
                        thisLine = thisLine.replace("\uFEFF", "");
                        T arr = (T)thisLine.split(regex);
                        list.add(arr);
                    }
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
    public boolean writeFile(List<T> data, String path, boolean append){
        File file = new File(path);
        try(FileWriter fw = new FileWriter(file, append)) {
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
