package com.sims.dao;

import com.sims.model.Calendar;

import java.util.List;

public interface CalendarDao {
    List<Calendar> getList();
    Calendar getCalendarById(Integer id);
    boolean save(List<Calendar> calendars);
    boolean deleteAll();
    List<Calendar> importFile(String path);
}
