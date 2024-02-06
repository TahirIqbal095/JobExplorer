package com.tahir.explorejobs.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {
    JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<Job>> findAll() {
        return ResponseEntity.ok(jobService.findAll());
    }
    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job) {
        jobService.createJob(job);
        return new ResponseEntity<>("job added successfully", HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable int id) {
        return new ResponseEntity<>(jobService.getJobById(id), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable int id) {
        boolean deleted = jobService.deleteById(id);
        if(deleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> updateJob(@RequestBody Job job, @PathVariable int id) {
        boolean updated = jobService.updateJob(job, id);
        if(updated) {
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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