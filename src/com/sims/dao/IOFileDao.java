package com.sims.dao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOFileDao<T> {
    public List<T> readFile(String path, String regex){
        List<T> list = new ArrayList<>();
        File file = new File(path);
        try(FileInputStream fis = new FileInputStream(file)){
            String thisLine;
            InputStreamReader isr = new InputStreamReader(fis, "UTF8");
            try(BufferedReader br = new BufferedReader(isr)) {
                while((thisLine = br.readLine()) != null){
                    if(!thisLine.isEmpty()){
                        thisLine = thisLine.replace("\uFEFF", "");
                        T arr = (T)thisLine.split(regex);
                        list.add(arr);
                    }
                }
                br.close();
                isr.close();
                fis.close();
            } catch (IOException e) {
                System.out.println("Got an exception!");
            }
        }
        catch (IOException e){
            System.out.println("File not found!");
        }
        return list;
    }
    public boolean writeFile(List<T> data, String path, boolean append){
        File file = new File(path);
        try(FileOutputStream fos = new FileOutputStream(file, append)){
            OutputStreamWriter isw = new OutputStreamWriter(fos, "UTF8");
            try (BufferedWriter bw = new BufferedWriter(isw)) {
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
                isw.close();
                fos.close();
                return true;
            }catch (IOException e){
                System.out.println("Got an exception!");
            }
        }
        catch (IOException e){
            System.out.println("File not found!");
        }

        return false;
    }

}
