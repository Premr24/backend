package com.noticehub.dto;

import com.noticehub.enums.Gender;
import com.noticehub.enums.Status;

import java.time.LocalDate;

public record TeacherDto(
        Long id,
        String idNumber,
        String firstName,
        String lastName,
        String email,
        LocalDate dateOfBirth,
        Gender gender,
        String address,
        String contact,
        byte[] profileImage,
        Status status,
        String description,
        String qualification,
        String specialization,
        String password,
        Long departmentId,
        Long designationId,
        Long authorityId,
        Long jobTypeId) {
}
