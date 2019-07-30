package com.sims.dao;

import com.sims.model.Attendance;

import java.util.List;

public interface AttendanceDao {
    List<Attendance> getList();
    Attendance getAttendanceById(Integer id);
    boolean save(List<Attendance> attendances);
    boolean addOne(Attendance attendances);
    boolean deleteAll();
}
