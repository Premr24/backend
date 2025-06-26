package com.noticehub.service;

import com.noticehub.dto.SemesterDto;

public interface SemesterService {

    SemesterDto addSemester(SemesterDto semesterDto);

    SemesterDto updateSemester(Long id, SemesterDto updateSemester);

    SemesterDto getSemesterById(Long id);

    void deleteSemester(Long id);
}
