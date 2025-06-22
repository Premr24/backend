package com.noticehub.service.impl;

import com.noticehub.dto.FacultyDto;
import com.noticehub.entity.Faculty;
import com.noticehub.exception.ResourceNotFoundException;
import com.noticehub.mapper.FacultyMapper;
import com.noticehub.repository.FacultyRepositroy;
import com.noticehub.service.FacultyService;
import org.springframework.stereotype.Service;

@Service
public class FacultyImp implements FacultyService {

    public final FacultyRepositroy facultyRepositroy;

    public FacultyImp(FacultyRepositroy facultyRepositroy) {
        this.facultyRepositroy = facultyRepositroy;
    }

    // Add Faculty method
    @Override
    public FacultyDto createFaculty(FacultyDto facultyDto) {

        Faculty faculty = FacultyMapper.mapToFaculty(facultyDto);
        Faculty savedFaculty = facultyRepositroy.save(faculty);
        return FacultyMapper.mapToFacultyDto(savedFaculty);
    }

    @Override
    public FacultyDto updateFaculty(Long id, FacultyDto updateFaculty) {

        Faculty faculty = facultyRepositroy
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Faculty does not exists!"));

        faculty.setName(updateFaculty.name());
        Faculty update = facultyRepositroy.save(faculty);

        return new FacultyDto(update.getId(), update.getName());
    }

    @Override
    public FacultyDto getFacultyById(Long id) {

        Faculty faculty = facultyRepositroy
                .findById(id)
                .orElseThrow(() ->  new ResourceNotFoundException("Faculty not found!"));
        return FacultyMapper.mapToFacultyDto(faculty);
    }

    @Override
    public void deleteFaculty(Long id) {

        Faculty faculty = facultyRepositroy
                .findById(id)
                .orElseThrow(() ->  new ResourceNotFoundException("Faculty does not exists!"));
        facultyRepositroy.deleteById(id);
    }
}
