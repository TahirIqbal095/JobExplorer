package com.tahir.explorejobs.job.impl;

import com.tahir.explorejobs.job.Job;
import com.tahir.explorejobs.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class JobServiceImpl implements JobService {

    private final List<Job> jobs = new ArrayList<>();
    private int nextId = 0;

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        job.setId(nextId++);
        jobs.add(job);
    }

    @Override
    public Job getJobById(int id) {
        for(Job job : jobs) {
            if(job.getId() == id)
                return job;
        }
        return null;
    }
}
