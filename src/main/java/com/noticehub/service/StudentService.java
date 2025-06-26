package com.noticehub.service;

import com.noticehub.dto.StudentDto;

public interface StudentService {

    StudentDto createStudent(StudentDto studentDto);

    StudentDto updateStudent(Long id, StudentDto studentDto);

    StudentDto  getStudentById(Long id);

    void deleteStudent(Long id);
}
