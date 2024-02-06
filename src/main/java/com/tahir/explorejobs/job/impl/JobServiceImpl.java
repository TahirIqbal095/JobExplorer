package com.tahir.explorejobs.job.impl;

import com.tahir.explorejobs.job.Job;
import com.tahir.explorejobs.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
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
        return null; // bookmark
    }

    @Override
    public boolean deleteById(int id) {
        for(Job job : jobs) {
            if(job.getId() == id) {
                jobs.remove(id);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateJob(Job job, int id) {
        Iterator<Job> iterator = jobs.iterator();
        while(iterator.hasNext()) {
            Job existingJob = iterator.next();
            if(existingJob.getId() == id) {
                existingJob.setTitle(job.getTitle());
                existingJob.setDiscription(job.getDiscription());
                existingJob.setMinSalary(job.getMinSalary());
                existingJob.setMaxSalary(job.getMaxSalary());
                existingJob.setLocation(job.getLocation());
                return true;
            }
        }
        return false;
    }
}
