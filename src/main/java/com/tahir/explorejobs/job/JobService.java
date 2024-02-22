package com.tahir.explorejobs.job;

import java.util.List;

public interface JobService {
    List<Job> findAll();

    boolean createJob(Job job);

    Job getJobById(int id);

    boolean deleteById(int id);

    boolean updateJob(Job job, int id);
}
