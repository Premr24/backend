package com.noticehub.controller;

import com.noticehub.dto.JobTypeDto;
import com.noticehub.service.JobTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/jobType")
public class JobTypeController {

    private final JobTypeService jobTypeService;

    public JobTypeController(JobTypeService jobTypeService) {
        this.jobTypeService = jobTypeService;
    }

    //REST API to add JobType
    @PostMapping
    public ResponseEntity<JobTypeDto> addJobType(@RequestBody JobTypeDto jobTypeDto) {
        return new ResponseEntity<>(jobTypeService.createJobType(jobTypeDto), HttpStatus.CREATED);
    }

    //REST API to update JobType
    @PutMapping("/{id}")
    public ResponseEntity<JobTypeDto> updateJobType(@PathVariable Long id,
                                                    @RequestBody JobTypeDto updateJobType) {

        JobTypeDto jobTypeDto = jobTypeService.updateJobType(id, updateJobType);
        return ResponseEntity.ok(jobTypeDto);
    }

    //REST API to get JobType
    @GetMapping("/{id}")
    public ResponseEntity<JobTypeDto> getJobTypeById(@PathVariable Long id){

        JobTypeDto jobTypeDto = jobTypeService
                .getJobTypeById(id);
        return ResponseEntity.ok(jobTypeDto);
    }

    //REST API to delete JobType
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJobType(@PathVariable Long id) {
        jobTypeService.deleteJobType(id);
        return ResponseEntity.ok("JobType deleted successfully.");
    }
}
