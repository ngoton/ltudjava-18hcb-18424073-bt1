package com.sims.dao;

import com.sims.model.Calendar;
import com.sims.model.Transcript;

import java.util.List;

public interface TranscriptDao {
    List<Transcript> getList();
    Transcript getTranscriptById(Integer id);
    List<Transcript> getTranscriptByCalendar(Calendar calendar);
    boolean save(List<Transcript> transcripts);
    boolean deleteAll();
    List<Transcript> importFile(String path);
}
