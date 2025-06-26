package com.noticehub.service.impl;

import com.noticehub.dto.SemesterDto;
import com.noticehub.entity.Semester;
import com.noticehub.exception.ResourceNotFoundException;
import com.noticehub.mapper.FacultyMapper;
import com.noticehub.mapper.SemesterMapper;
import com.noticehub.repository.SemesterRepository;
import com.noticehub.service.SemesterService;
import org.springframework.stereotype.Service;

@Service
public class SemesterImpl implements SemesterService {

    public final SemesterRepository semesterRepository;

    public SemesterImpl(SemesterRepository semesterRepository) {
        this.semesterRepository = semesterRepository;
    }

    //add semester method
    @Override
    public SemesterDto addSemester(SemesterDto semesterDto) {

        Semester semester = SemesterMapper.mapToSemester(semesterDto);
        Semester saveSemester = semesterRepository.save(semester);
        return SemesterMapper.mapToSemesterDto(saveSemester);
    }

    //update semester method
    @Override
    public SemesterDto updateSemester(Long id, SemesterDto updateSemester) {

        Semester semester = semesterRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Semester does not exists!"));
        semester.setName(updateSemester.name());
        Semester update = semesterRepository.save(semester);
        return new SemesterDto(update.getId(), update.getName());
    }

    //retrieve semester method
    @Override
    public SemesterDto getSemesterById(Long id) {

        Semester semester = semesterRepository
                .findById(id)
                .orElseThrow(() ->  new ResourceNotFoundException("Semester does not exists!"));
        return SemesterMapper.mapToSemesterDto(semester);
    }

    //delete semester method
    @Override
    public void deleteSemester(Long id) {

        Semester semester = semesterRepository
                .findById(id)
                .orElseThrow(() ->  new ResourceNotFoundException("Semester does not exists!"));
        semesterRepository.deleteById(id);
    }
}
