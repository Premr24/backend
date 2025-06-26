package com.noticehub.mapper;

import com.noticehub.dto.ProgramDto;
import com.noticehub.entity.Faculty;
import com.noticehub.entity.Level;
import com.noticehub.entity.Program;

public class ProgramMapper {

    public static Program mapToProgram(ProgramDto programDto, Faculty faculty, Level level) {
        return Program.builder()
                .id(programDto.id())
                .name(programDto.name())
                .faculty(faculty)
                .level(level)
                .build();
    }

    public static ProgramDto mapToProgramDto(Program program) {
        return new ProgramDto(
                program.getId(),
                program.getName(),
                program.getFaculty().getId(),
                program.getLevel().getId()
        );
    }
}
