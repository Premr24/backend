package com.noticehub.repository;

import com.noticehub.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepositroy extends JpaRepository<Faculty, Long> {
}
