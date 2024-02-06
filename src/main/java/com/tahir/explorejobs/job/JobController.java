package com.tahir.explorejobs.job;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JobController {
    private List<Job> jobs = new ArrayList<>();

    @GetMapping("/jobs")
    public List<Job> findAll() {
        return jobs;
    }
    @PostMapping("/jobs")
    public String createJob(@RequestBody Job job) {
        jobs.add(job);
        return "job added successfully";
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