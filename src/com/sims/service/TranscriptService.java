package com.sims.service;

import com.sims.model.Transcript;

import java.util.List;

public interface TranscriptService {
    List<Transcript> getList();
    boolean save(List<Transcript> transcripts);
    boolean deleteAll();
    List<Transcript> importFile(String path);
}
