package com.noticehub.mapper;

import com.noticehub.dto.FacultyDto;
import com.noticehub.dto.LevelDto;
import com.noticehub.entity.Faculty;
import com.noticehub.entity.Level;

public class FacultyMapper {

    public static Faculty mapToFaculty(FacultyDto facultyDto) {
        return new Faculty(
                facultyDto.id(),
                facultyDto.name()
        );
    }

    public static FacultyDto mapToFacultyDto(Faculty faculty) {
        return new FacultyDto(
                faculty.getId(),
                faculty.getName()
        );
    }
}
