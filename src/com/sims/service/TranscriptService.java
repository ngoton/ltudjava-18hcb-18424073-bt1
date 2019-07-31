package com.sims.service;

import com.sims.model.Transcript;

import java.util.List;

public interface TranscriptService {
    List<Transcript> getList();
    List<Transcript> getListByStudent(String code);
    boolean save(List<Transcript> transcripts);
    boolean deleteAll();
    List<Transcript> importFile(String path);
}
