package com.tahir.explorejobs.job.impl;

import com.tahir.explorejobs.job.Job;
import com.tahir.explorejobs.job.JobRepository;
import com.tahir.explorejobs.job.JobService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

    private JobRepository jobRepository;

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public boolean createJob(Job job) {
        try {
            jobRepository.save(job);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public Job getJobById(int id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteById(int id) {
        try {
            jobRepository.deleteById(id);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateJob(Job job, int id) {
        Optional<Job> optionalJob = jobRepository.findById(id);

        if(optionalJob.isPresent()) {
            Job existingJob = optionalJob.get();
            existingJob.setTitle(job.getTitle());
            existingJob.setDescription(job.getDescription());
            existingJob.setMinSalary(job.getMinSalary());
            existingJob.setMaxSalary(job.getMaxSalary());
            existingJob.setLocation(job.getLocation());
            return true;
        }
        return false;
    }
}
