package com.sims.dao;

import com.sims.model.Attendance;
import com.sims.model.Calendar;
import com.sims.model.Student;
import com.sims.model.Transcript;

import java.util.ArrayList;
import java.util.List;

public class TranscriptDaoImpl extends IOFileDao implements TranscriptDao {
    private static String path = "../data/transcript.txt";
    private String transcriptFile;
    private CalendarDao calendarDao;
    private StudentDao studentDao;
    private AttendanceDao attendanceDao;

    public TranscriptDaoImpl(){
        this.transcriptFile = getClass().getResource(path).getFile();
        this.calendarDao = new CalendarDaoImpl();
        this.studentDao = new StudentDaoImpl();
        this.attendanceDao = new AttendanceDaoImpl();
    }

    @Override
    public List<Transcript> getList(){
        List<Transcript> list = new ArrayList<>();
        List<String[]> data = readFile(transcriptFile, "\\|");
        for (String[] arr : data){
            Transcript transcript = new Transcript();
            transcript.setId(Integer.parseInt(arr[0]));

            Student student = studentDao.getStudentById(Integer.parseInt(arr[1]));
            if (student != null){
                transcript.setStudent(student);
            }
            Calendar calendar = calendarDao.getCalendarById(Integer.parseInt(arr[2]));
            if (calendar != null){
                transcript.setCalendar(calendar);
            }

            transcript.setMiddleMark(Float.parseFloat(arr[3]));
            transcript.setFinalMark(Float.parseFloat(arr[4]));
            transcript.setOtherMark(Float.parseFloat(arr[5]));
            transcript.setMark(Float.parseFloat(arr[6]));

            list.add(transcript);
        }

        return list;
    }

    @Override
    public List<Transcript> getListByStudent(String code){
        List<Transcript> list = new ArrayList<>();
        List<String[]> data = readFile(transcriptFile, "\\|");
        for (String[] arr : data){
            Transcript transcript = new Transcript();
            transcript.setId(Integer.parseInt(arr[0]));

            Student student = studentDao.getStudentById(Integer.parseInt(arr[1]));
            if (student != null){
                transcript.setStudent(student);
            }
            Calendar calendar = calendarDao.getCalendarById(Integer.parseInt(arr[2]));
            if (calendar != null){
                transcript.setCalendar(calendar);
            }

            transcript.setMiddleMark(Float.parseFloat(arr[3]));
            transcript.setFinalMark(Float.parseFloat(arr[4]));
            transcript.setOtherMark(Float.parseFloat(arr[5]));
            transcript.setMark(Float.parseFloat(arr[6]));

            if (transcript.getStudent() != null) {
                if (transcript.getStudent().getCode().equals(code)) {
                    list.add(transcript);
                }
            }
        }

        return list;
    }

    @Override
    public Transcript getTranscriptById(Integer id){
        List<Transcript> transcripts = this.getList();
        Transcript transcript = null;
        for (Transcript s : transcripts){
            if (id.equals(s.getId())){
                transcript = s;
                break;
            }
        }
        return transcript;
    }

    @Override
    public List<Transcript> getTranscriptByCalendar(Calendar calendar){
        List<Transcript> transcripts = getList();
        List<Transcript> transcriptList = new ArrayList<>();
        for (Transcript a : transcripts){
            if (calendar.getId().equals(a.getCalendar().getId())){
                transcriptList.add(a);
            }
        }
        return transcriptList;
    }

    @Override
    public boolean save(List<Transcript> transcripts){
        List<Attendance> attendanceList = attendanceDao.getList();
        Integer lastAttendance = 0;
        if (attendanceList.size() > 0) {
            lastAttendance = attendanceList.get(attendanceList.size() - 1).getId();
        }
        for (Transcript t : transcripts){
            boolean checkExists = false;
            for (Attendance a : attendanceList){
                if (a.getCalendar().getId().equals(t.getCalendar().getId()) && a.getStudent().getId().equals(t.getStudent().getId())){
                    checkExists = true;
                    break;
                }
            }
            if (checkExists == false){
                Attendance attendance = new Attendance();
                attendance.setId(++lastAttendance);
                attendance.setStudent(t.getStudent());
                attendance.setCalendar(t.getCalendar());
                attendanceList.add(attendance);
                attendanceDao.addOne(attendance);

            }
        }
        return writeFile(transcripts, transcriptFile, false);
    }


    @Override
    public boolean deleteAll(){
        return writeFile(null, transcriptFile, false);
    }

    @Override
    public List<Transcript> importFile(String path) {
        List<Transcript> list = getList();
        List<Transcript> newList = new ArrayList<>();
        List<Attendance> attendanceList = attendanceDao.getList();
        Student student = null;
        Calendar calendar = null;
        List<String[]> data = readFile(path, ",");
        Integer lastTranscript = 0;
        if (list.size() > 0) {
            lastTranscript = list.get(list.size() - 1).getId();
        }
        Integer lastAttendance = 0;
        if (attendanceList.size() > 0) {
            lastAttendance = attendanceList.get(attendanceList.size() - 1).getId();
        }

        int i = 0;
        for (String[] arr : data){
            if (i == 0){
                String calendarName = arr[0].trim();
                if (!calendarName.isEmpty()){
                    calendar = calendarDao.getCalendarByName(calendarName);
                    if (calendar == null){
                        return list;
                    }
                }
            }
            else if (i > 1){
                boolean checkCode = true;
                String studentCode = arr[1].trim();
                if (!studentCode.isEmpty()){
                    student = studentDao.getStudentByCode(studentCode);
                    if (student == null){
                        checkCode = false;
                    }
                }


                for (Transcript t : list){
                    if (student.getId().equals(t.getStudent().getId()) && calendar.getId().equals(t.getCalendar().getId())){
                        checkCode = false;
                        break;
                    }
                }

                if (checkCode == true) {
                    Transcript transcript = new Transcript();
                    transcript.setId(++lastTranscript);
                    transcript.setStudent(student);
                    transcript.setCalendar(calendar);
                    transcript.setMiddleMark(Float.parseFloat(arr[3]));
                    transcript.setFinalMark(Float.parseFloat(arr[4]));
                    transcript.setOtherMark(Float.parseFloat(arr[5]));
                    transcript.setMark(Float.parseFloat(arr[6]));
                    newList.add(transcript);
                    list.add(transcript);

                    boolean checkExists = false;
                    for (Attendance a : attendanceList){
                        if (a.getCalendar().getId().equals(calendar.getId()) && a.getStudent().getId().equals(student.getId())){
                            checkExists = true;
                            break;
                        }
                    }
                    if (checkExists == false){
                        Attendance attendance = new Attendance();
                        attendance.setId(++lastAttendance);
                        attendance.setStudent(student);
                        attendance.setCalendar(calendar);
                        attendanceList.add(attendance);
                        attendanceDao.addOne(attendance);

                    }
                }
            }
            i++;
        }

        writeFile(newList, transcriptFile, true);

        return list;
    }
}
