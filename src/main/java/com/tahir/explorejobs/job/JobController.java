package com.tahir.explorejobs.job;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JobController {
    JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public List<Job> findAll() {
        return jobService.findAll();
    }
    @PostMapping("/jobs")
    public String createJob(@RequestBody Job job) {
        jobService.createJob(job);
        return "job added successfully";
    }
    @GetMapping("/jobs/{id}")
    public Job getJobById(@PathVariable int id) {
        return jobService.getJobById(id);
    }
}




/*

get /jobs: get all jobs
get /jobs/{id}: get a specific job by id

post /jobs: create a new job (request body should contain the job details)

delete /jobs/{id}: delete a specific job by id

put /jobs/{id}: update a specific job with id (request body should contain the updated job details)

get /jobs/{id}/company : get the company associated with specific job by id

 */