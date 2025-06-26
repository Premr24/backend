package com.noticehub.service;

import com.noticehub.dto.TeacherDto;

import java.util.List;

public interface TeacherService {

    TeacherDto createTeacher(TeacherDto teacherDto);

    TeacherDto updateTeacher(Long id, TeacherDto teacherDto);

    TeacherDto getTeacherById(Long id);

    void deleteTeacher(Long id);

    List<TeacherDto> getAllTeachers();
}
