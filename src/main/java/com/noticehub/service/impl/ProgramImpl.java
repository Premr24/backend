package com.noticehub.service.impl;

import com.noticehub.dto.ProgramDto;
import com.noticehub.entity.Faculty;
import com.noticehub.entity.Level;
import com.noticehub.entity.Program;
import com.noticehub.exception.ResourceNotFoundException;
import com.noticehub.mapper.ProgramMapper;
import com.noticehub.repository.FacultyRepository;
import com.noticehub.repository.LevelRepository;
import com.noticehub.repository.ProgramRepository;
import com.noticehub.service.ProgramService;
import org.springframework.stereotype.Service;

@Service
public class ProgramImpl implements ProgramService {

    private final ProgramRepository programRepository;
    private final FacultyRepository facultyRepository;
    private final LevelRepository levelRepository;

    public ProgramImpl(ProgramRepository programRepository,
                       FacultyRepository facultyRepository,
                       LevelRepository levelRepository) {
        this.programRepository = programRepository;
        this.facultyRepository = facultyRepository;
        this.levelRepository = levelRepository;
    }

    @Override
    public ProgramDto createProgram(ProgramDto programDto) {

        Faculty faculty = facultyRepository.findById(programDto.faculty_id())
                .orElseThrow(() -> new ResourceNotFoundException("Faculty does not exists!"));

        Level level = levelRepository.findById(programDto.level_id())
                .orElseThrow(() -> new ResourceNotFoundException("Level does not exists!"));

        Program program = ProgramMapper.mapToProgram(programDto, faculty, level);
        Program saved = programRepository.save(program);
        return ProgramMapper.mapToProgramDto(saved);
    }

    @Override
    public ProgramDto updateProgram(Long id, ProgramDto programDto) {

        Program program = programRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Program does not exists!"));

        Faculty faculty = facultyRepository.findById(programDto.faculty_id())
                .orElseThrow(() -> new ResourceNotFoundException("Faculty does not exists!"));

        Level level = levelRepository.findById(programDto.level_id())
                .orElseThrow(() -> new ResourceNotFoundException("Level does not exists!"));

        program.setName(programDto.name());
        program.setFaculty(faculty);
        program.setLevel(level);

        Program updated = programRepository.save(program);
        return ProgramMapper.mapToProgramDto(updated);
    }

    @Override
    public ProgramDto getProgramById(Long id) {
        Program program = programRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Program does not exists!"));
        return ProgramMapper.mapToProgramDto(program);
    }

    @Override
    public void deleteProgram(Long id) {

        Program program = programRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Program does not exists!"));
        programRepository.delete(program);
    }
}
