package com.sims.service;

import com.sims.model.Calendar;

import java.util.List;

public interface CalendarService {
    List<Calendar> getList();
    boolean save(List<Calendar> calendars);
    boolean deleteAll();
    List<Calendar> importFile(String path);
}
