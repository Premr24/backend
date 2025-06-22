package com.noticehub.repository;

import com.noticehub.entity.Faculty;
import com.noticehub.entity.Level;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FacultyRepositroy extends JpaRepository<Faculty, Long> {
    Optional<Level> findByName(String name);
}
