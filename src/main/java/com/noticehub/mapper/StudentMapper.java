package com.noticehub.mapper;

import com.noticehub.dto.StudentDto;
import com.noticehub.entity.Program;
import com.noticehub.entity.Semester;
import com.noticehub.entity.Student;
import com.noticehub.entity.User;

public class StudentMapper {

    public static Student mapToStudent(
            StudentDto dto,
            User user,
            Program program,
            Semester semester
    ) {
        return Student.builder()
                .id(dto.id())
                .idNumber(dto.idNumber())
                .firstName(dto.firstName())
                .lastName(dto.lastName())
                .email(dto.email())
                .dateOfBirth(dto.dateOfBirth())
                .gender(dto.gender())
                .address(dto.address())
                .contact(dto.contact())
                .profileImage(dto.profileImage())
                .status(dto.status())
                .description(dto.description())
                .user(user)
                .program(program)
                .semester(semester)
                .build();
    }

    public static StudentDto mapToStudentDto(Student student) {
        return new StudentDto(
                student.getId(),
                student.getIdNumber(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getDateOfBirth(),
                student.getGender(),
                student.getAddress(),
                student.getContact(),
                student.getProfileImage(),
                student.getStatus(),
                student.getDescription(),
                null,
                student.getProgram().getId(),
                student.getSemester().getId()
        );
    }
}
