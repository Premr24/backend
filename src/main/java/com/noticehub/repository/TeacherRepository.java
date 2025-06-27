package com.noticehub.repository;

import com.noticehub.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    boolean existsByEmail(String email);
    boolean existsByContact(String contact);
    boolean existsByIdNumber(String idNumber);
}
