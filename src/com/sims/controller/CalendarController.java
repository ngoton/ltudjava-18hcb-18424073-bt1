package com.sims.controller;

import com.sims.model.Calendar;
import com.sims.model.Classes;
import com.sims.model.Subject;
import com.sims.service.*;
import com.sims.view.CalendarForm;

import java.util.List;

public class CalendarController {
    private CalendarForm calendarForm;
    private CalendarService calendarService;
    private ClassesService classesService;
    private SubjectService subjectService;

    public CalendarController(CalendarForm calendarForm){
        this.calendarForm = calendarForm;
        this.calendarService = new CalendarServiceImpl();
        this.classesService = new ClassesServiceImpl();
        this.subjectService = new SubjectServiceImpl();
    }

    public List<Calendar> getList(){
        return calendarService.getList();
    }

    public List<Classes> getClassList(){
        return classesService.getList();
    }

    public List<Subject> getSubjectList(){
        return subjectService.getList();
    }

    public boolean save(List<Calendar> calendars){
        return calendarService.save(calendars);
    }

    public boolean deleteAll(){
        return calendarService.deleteAll();
    }

    public List<Calendar> importFile(String path){
        return calendarService.importFile(path);
    }
}
