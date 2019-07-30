package com.sims.service;

import com.sims.model.Attendance;

import java.util.List;

public interface AttendanceService {
    List<Attendance> getList();
    boolean save(List<Attendance> attendances);
    boolean addOne(Attendance attendance);
    boolean deleteAll();
}
