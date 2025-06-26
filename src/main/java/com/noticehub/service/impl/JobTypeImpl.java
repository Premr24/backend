package com.noticehub.service.impl;

import com.noticehub.dto.JobTypeDto;
import com.noticehub.entity.JobType;
import com.noticehub.exception.ResourceNotFoundException;
import com.noticehub.mapper.JobTypeMapper;
import com.noticehub.repository.JobTypeRepository;
import com.noticehub.service.JobTypeService;
import org.springframework.stereotype.Service;

@Service
public class JobTypeImpl implements JobTypeService {

    public final JobTypeRepository jobTypeRepository;

    public JobTypeImpl(JobTypeRepository jobTypeRepository) {
        this.jobTypeRepository = jobTypeRepository;
    }

    //Add JobType method
    @Override
    public JobTypeDto createJobType(JobTypeDto jobTypeDto) {

        JobType jobType = JobTypeMapper.mapToJobType(jobTypeDto);
        JobType savedJobType = jobTypeRepository.save(jobType);
        return JobTypeMapper.mapToJobTypeDto(savedJobType);
    }

    //update JobType method
    @Override
    public JobTypeDto updateJobType(Long id, JobTypeDto updateJobType) {

       JobType jobType = jobTypeRepository
               .findById(id)
               .orElseThrow(() -> new ResourceNotFoundException("JobType does not exists!"));

       jobType.setName(updateJobType.name());
       JobType update = jobTypeRepository.save(jobType);
        return new JobTypeDto(update.getId(), update.getName());
    }

    //retrieve JobType method
    @Override
    public JobTypeDto getJobTypeById(Long id) {

        JobType jobType = jobTypeRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("JobType does not exists!"));
        return JobTypeMapper.mapToJobTypeDto(jobType);
    }

    //delete jobType method
    @Override
    public void deleteJobType(Long id) {

        JobType jobType = jobTypeRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("JobType deleted successfully."));
        jobTypeRepository.deleteById(id);
    }
}
