package com.noticehub.service.impl;

import com.noticehub.dto.FacultyDto;
import com.noticehub.entity.Faculty;
import com.noticehub.exception.ResourceNotFoundException;
import com.noticehub.mapper.FacultyMapper;
import com.noticehub.repository.FacultyRepository;
import com.noticehub.service.FacultyService;
import org.springframework.stereotype.Service;

@Service
public class FacultyImp implements FacultyService {

    public final FacultyRepository facultyRepository;

    public FacultyImp(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    // Add Faculty method
    @Override
    public FacultyDto createFaculty(FacultyDto facultyDto) {

        Faculty faculty = FacultyMapper.mapToFaculty(facultyDto);
        Faculty savedFaculty = facultyRepository.save(faculty);
        return FacultyMapper.mapToFacultyDto(savedFaculty);
    }

    //Update Faculty method
    @Override
    public FacultyDto updateFaculty(Long id, FacultyDto updateFaculty) {

        Faculty faculty = facultyRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Faculty does not exists!"));

        faculty.setName(updateFaculty.name());
        Faculty update = facultyRepository.save(faculty);

        return new FacultyDto(update.getId(), update.getName());
    }

    //Retrieve Faculty method
    @Override
    public FacultyDto getFacultyById(Long id) {

        Faculty faculty = facultyRepository
                .findById(id)
                .orElseThrow(() ->  new ResourceNotFoundException("Faculty does not exists!"));
        return FacultyMapper.mapToFacultyDto(faculty);
    }

    //Delete Faculty method
    @Override
    public void deleteFaculty(Long id) {

        Faculty faculty = facultyRepository
                .findById(id)
                .orElseThrow(() ->  new ResourceNotFoundException("Faculty does not exists!"));
        facultyRepository.deleteById(id);
    }
}
