package com.sims.controller;

import com.sims.model.*;
import com.sims.service.*;
import com.sims.view.TranscriptForm;

import java.util.List;

public class TranscriptController {
    private TranscriptForm transcriptForm;
    private TranscriptService transcriptService;
    private CalendarService calendarService;
    private StudentService studentService;

    public TranscriptController(TranscriptForm transcriptForm){
        this.transcriptForm = transcriptForm;
        this.transcriptService = new TranscriptServiceImpl();
        this.calendarService = new CalendarServiceImpl();
        this.studentService = new StudentServiceImpl();
    }

    public List<Transcript> getList(){
        return transcriptService.getList();
    }

    public List<Calendar> getCalendarList(){
        return calendarService.getList();
    }

    public List<Student> getStudentList(){
        return studentService.getList();
    }

    public boolean save(List<Transcript> transcripts){
        return transcriptService.save(transcripts);
    }

    public boolean deleteAll(){
        return transcriptService.deleteAll();
    }

    public List<Transcript> importFile(String path){
        return transcriptService.importFile(path);
    }
}
