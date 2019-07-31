package com.sims.dao;

import com.sims.model.Calendar;

import java.util.List;

public interface CalendarDao {
    List<Calendar> getList();
    List<Calendar> getListByStudent(String code);
    Calendar getCalendarById(Integer id);
    Calendar getCalendarByName(String name);
    boolean save(List<Calendar> calendars);
    boolean deleteAll();
    List<Calendar> importFile(String path);
}
