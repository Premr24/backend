package com.noticehub.service;

import com.noticehub.dto.JobTypeDto;

public interface JobTypeService {

    JobTypeDto createJobType(JobTypeDto jobTypeDto);

    JobTypeDto updateJobType(Long id, JobTypeDto updateJobType);

    JobTypeDto getJobTypeById(Long id);

    void deleteJobType(Long id);
}
