package com.noticehub.service;

import com.noticehub.dto.ProgramDto;

import java.util.List;

public interface ProgramService {

    ProgramDto createProgram(ProgramDto programDto);

    ProgramDto updateProgram(Long id, ProgramDto programDto);

    ProgramDto getProgramById(Long id);

    void deleteProgram(Long id);
}
