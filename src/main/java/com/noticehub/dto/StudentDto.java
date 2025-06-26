package com.noticehub.dto;

import com.noticehub.entity.Student;
import com.noticehub.enums.Gender;
import com.noticehub.enums.Status;

import java.time.LocalDate;

public record StudentDto(
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
        String password,
        Long programId,
        Long semesterId ) {
}
