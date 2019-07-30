package com.sims.dao;

import com.sims.model.*;

import java.util.ArrayList;
import java.util.List;

public class CalendarDaoImpl extends IOFileDao implements CalendarDao {
    private static String path = "../data/calendar.txt";
    private String calendarFile;
    private ClassesDao classesDao;
    private SubjectDao subjectDao;

    public CalendarDaoImpl(){
        this.calendarFile = getClass().getResource(path).getFile();
        this.classesDao = new ClassesDaoImpl();
        this.subjectDao = new SubjectDaoImpl();
    }

    @Override
    public List<Calendar> getList(){
        List<Calendar> list = new ArrayList<>();
        List<String[]> data = readFile(calendarFile, "\\|");
        for (String[] arr : data){
            Calendar calendar = new Calendar();
            calendar.setId(Integer.parseInt(arr[0]));
            calendar.setRoom(arr[3]);

            Classes classes = classesDao.getClassById(Integer.parseInt(arr[1]));
            if (classes != null){
                calendar.setClasses(classes);
            }

            Subject subject = subjectDao.getSubjectById(Integer.parseInt(arr[2]));
            if (subject != null){
                calendar.setSubject(subject);
            }

            list.add(calendar);
        }

        return list;
    }

    @Override
    public Calendar getCalendarById(Integer id){
        List<Calendar> calendars = this.getList();
        Calendar calendar = null;
        for (Calendar s : calendars){
            if (id.equals(s.getId())){
                calendar = s;
                break;
            }
        }
        return calendar;
    }

    @Override
    public boolean save(List<Calendar> calendars){
        return writeFile(calendars, calendarFile, false);
    }

    @Override
    public boolean deleteAll(){
        return writeFile(null, calendarFile, false);
    }

    @Override
    public List<Calendar> importFile(String path){
        List<Calendar> list = getList();
        List<Calendar> newList = new ArrayList<>();
        Subject subject = null;
        Classes classes = null;
        List<String[]> data = readFile(path, ",");
        Integer lastCalendar = 0;
        if (list.size() > 0) {
            lastCalendar = list.get(list.size() - 1).getId();
        }
        int i = 0;
        for (String[] arr : data){
            if (i == 0){
                String className = arr[0].trim();
                if (!className.isEmpty()){
                    classes = classesDao.getClassByName(className);
                    if (classes == null){
                        List<Classes> classesList = classesDao.getList();
                        Integer lastId = 0;
                        if (classesList.size() > 0) {
                            lastId = classesList.get(classesList.size() - 1).getId();
                        }
                        Classes c = new Classes();
                        c.setId(++lastId);
                        c.setName(className);
                        if(classesDao.addOne(c)){
                            classes = c;
                        }
                        else {
                            return list;
                        }
                    }
                }
            }
            else if (i > 1){
                String subjectCode = arr[1].trim();
                if (!subjectCode.isEmpty()){
                    subject = subjectDao.getSubjectByCode(subjectCode);
                    if (subject == null){
                        List<Subject> subjectList = subjectDao.getList();
                        Integer lastId = 0;
                        if (subjectList.size() > 0) {
                            lastId = subjectList.get(subjectList.size() - 1).getId();
                        }
                        Subject c = new Subject();
                        c.setId(++lastId);
                        c.setCode(subjectCode);
                        c.setName(arr[2].trim());
                        if(subjectDao.addOne(c)){
                            subject = c;
                        }
                        else {
                            return list;
                        }
                    }
                }

                Calendar calendar = new Calendar();
                calendar.setId(++lastCalendar);
                calendar.setRoom(arr[3].trim());
                calendar.setClasses(classes);
                calendar.setSubject(subject);
                newList.add(calendar);
                list.add(calendar);


            }
            i++;
        }

        writeFile(newList, calendarFile, true);

        return list;
    }
}
