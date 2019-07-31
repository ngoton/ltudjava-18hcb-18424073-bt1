package com.sims.service;

import com.sims.model.Calendar;
import com.sims.model.Student;

import java.util.List;

public interface CalendarService {
    List<Calendar> getList();
    List<Calendar> getListByStudent(String code);
    boolean save(List<Calendar> calendars);
    boolean deleteAll();
    List<Calendar> importFile(String path);
}
