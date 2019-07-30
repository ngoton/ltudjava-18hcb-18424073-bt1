package com.sims.dao;

import com.sims.model.*;

import java.util.ArrayList;
import java.util.List;

public class AttendanceDaoImpl extends IOFileDao implements AttendanceDao {
    private static String path = "../data/attendance.txt";
    private String attendanceFile;
    private CalendarDao calendarDao;
    private StudentDao studentDao;

    public AttendanceDaoImpl(){
        this.attendanceFile = getClass().getResource(path).getFile();
        this.calendarDao = new CalendarDaoImpl();
        this.studentDao = new StudentDaoImpl();
    }

    @Override
    public List<Attendance> getList(){
        List<Attendance> list = new ArrayList<>();
        List<String[]> data = readFile(attendanceFile, "\\|");
        for (String[] arr : data){
            Attendance attendance = new Attendance();
            attendance.setId(Integer.parseInt(arr[0]));

            Calendar calendar = calendarDao.getCalendarById(Integer.parseInt(arr[1]));
            if (calendar != null){
                attendance.setCalendar(calendar);
            }

            Student student = studentDao.getStudentById(Integer.parseInt(arr[2]));
            if (student != null){
                attendance.setStudent(student);
            }

            list.add(attendance);
        }

        return list;
    }

    @Override
    public Attendance getAttendanceById(Integer id){
        List<Attendance> attendances = this.getList();
        Attendance attendance = null;
        for (Attendance s : attendances){
            if (id.equals(s.getId())){
                attendance = s;
                break;
            }
        }
        return attendance;
    }

    @Override
    public boolean save(List<Attendance> attendances){
        return writeFile(attendances, attendanceFile, false);
    }

    @Override
    public boolean addOne(Attendance attendance){
        List<Attendance> attendanceList = new ArrayList<>();
        attendanceList.add(attendance);
        return writeFile(attendanceList, attendanceFile, true);
    }

    @Override
    public boolean deleteAll(){
        return writeFile(null, attendanceFile, false);
    }

}
