package com.sims.dao;

import com.sims.model.Attendance;
import com.sims.model.Calendar;

import java.util.List;

public interface AttendanceDao {
    List<Attendance> getList();
    Attendance getAttendanceById(Integer id);
    List<Attendance> getAttenddanceByCalendar(Calendar calendar);
    boolean save(List<Attendance> attendances);
    boolean addOne(Attendance attendances);
    boolean deleteAll();
    boolean updateAll(List<Attendance> attendances);
}
