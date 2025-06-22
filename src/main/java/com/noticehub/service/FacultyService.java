package com.noticehub.service;

import com.noticehub.dto.FacultyDto;

public interface FacultyService {

    FacultyDto createFaculty(FacultyDto facultyDto);

    FacultyDto updateFaculty(Long id, FacultyDto updateFaculty);

    FacultyDto getFacultyById(Long id);

    void deleteFaculty(Long id);
}
