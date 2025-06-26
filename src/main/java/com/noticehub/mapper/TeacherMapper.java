package com.noticehub.mapper;

import com.noticehub.dto.TeacherDto;
import com.noticehub.entity.*;
import com.noticehub.enums.Gender;
import com.noticehub.enums.Status;

public class TeacherMapper {

    public static Teacher mapToTeacher(
            TeacherDto dto,
            User user,
            Department department,
            Designation designation,
            Authority authority,
            JobType jobType
    ) {
        return Teacher.builder()
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
                .qualification(dto.qualification())
                .specialization(dto.specialization())
                .user(user)
                .department(department)
                .designation(designation)
                .authority(authority)
                .jobType(jobType)
                .build();
    }

    public static TeacherDto mapToTeacherDto(Teacher teacher) {
        return new TeacherDto(
                teacher.getId(),
                teacher.getIdNumber(),
                teacher.getFirstName(),
                teacher.getLastName(),
                teacher.getEmail(),
                teacher.getDateOfBirth(),
                teacher.getGender(),
                teacher.getAddress(),
                teacher.getContact(),
                teacher.getProfileImage(),
                teacher.getStatus(),
                teacher.getDescription(),
                teacher.getQualification(),
                teacher.getSpecialization(),
                null,
                teacher.getDepartment().getId(),
                teacher.getDesignation().getId(),
                teacher.getAuthority().getId(),
                teacher.getJobType().getId()
        );
    }
}
