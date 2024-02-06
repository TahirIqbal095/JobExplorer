package com.tahir.explorejobs.job;

import java.util.List;

public interface JobService {
    List<Job> findAll();

    void createJob(Job job);

    Job getJobById(int id);
}
