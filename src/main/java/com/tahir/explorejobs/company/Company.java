package com.tahir.explorejobs.company;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tahir.explorejobs.job.Job;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "company") // mapped by a field called company which exists in jobs
    private List<Job> jobs;

    public Company() {
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
