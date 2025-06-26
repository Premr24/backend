package com.noticehub.mapper;

import com.noticehub.dto.JobTypeDto;
import com.noticehub.entity.JobType;

public class JobTypeMapper {

    public static JobType mapToJobType(JobTypeDto jobTypeDto) {
        return new JobType(
                jobTypeDto.id(),
                jobTypeDto.name()
        );
    }

    public static JobTypeDto mapToJobTypeDto(JobType jobType) {
        return new JobTypeDto(
                jobType.getId(),
                jobType.getName()
        );
    }
}
