package com.noticehub.repository;

import com.noticehub.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

    boolean existsByEmail(String email);
    boolean existsByContact(String contact);
    boolean existsByIdNumber(String idNumber);

}
