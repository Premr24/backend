package com.noticehub.mapper;

import com.noticehub.dto.SemesterDto;
import com.noticehub.entity.Semester;

public class SemesterMapper {

    public static Semester mapToSemester(SemesterDto semesterDto) {
        return new Semester(
                semesterDto.id(),
                semesterDto.name()
        );
    }

    public static SemesterDto mapToSemesterDto(Semester semester) {
        return new SemesterDto(
                semester.getId(),
                semester.getName()
        );
    }
}
