package com.noticehub.repository;

import com.noticehub.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    //Optional<Level> findByName(String name);
}