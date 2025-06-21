package com.noticehub.repository;

import com.noticehub.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    //DB access layer for roles
}
