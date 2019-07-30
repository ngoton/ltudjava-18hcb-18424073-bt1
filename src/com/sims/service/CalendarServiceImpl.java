package com.sims.service;

import com.sims.dao.CalendarDao;
import com.sims.dao.CalendarDaoImpl;
import com.sims.model.Calendar;

import java.util.List;

public class CalendarServiceImpl implements CalendarService {
    private CalendarDao calendarDao;

    public CalendarServiceImpl(){
        this.calendarDao = new CalendarDaoImpl();
    }

    @Override
    public List<Calendar> getList(){
        return calendarDao.getList();
    }

    @Override
    public boolean save(List<Calendar> calendars){
        return calendarDao.save(calendars);
    }

    @Override
    public boolean deleteAll(){
        return calendarDao.deleteAll();
    }

    @Override
    public List<Calendar> importFile(String path){
        return calendarDao.importFile(path);
    }
}
