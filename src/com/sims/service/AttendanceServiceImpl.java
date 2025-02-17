package com.sims.service;

import com.sims.dao.AttendanceDao;
import com.sims.dao.AttendanceDaoImpl;
import com.sims.model.Attendance;

import java.util.List;

public class AttendanceServiceImpl implements AttendanceService {
    private AttendanceDao attendanceDao;

    public AttendanceServiceImpl(){
        this.attendanceDao = new AttendanceDaoImpl();
    }

    @Override
    public List<Attendance> getList(){
        return attendanceDao.getList();
    }

    @Override
    public boolean save(List<Attendance> attendances){
        return attendanceDao.save(attendances);
    }

    @Override
    public boolean addOne(Attendance attendance){
        return attendanceDao.addOne(attendance);
    }

    @Override
    public boolean deleteAll(){
        return attendanceDao.deleteAll();
    }

}
