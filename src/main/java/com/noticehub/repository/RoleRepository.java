package com.noticehub.repository;

import com.noticehub.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    //To access data from DB for roles
    Optional<Role> findByName(String name);
}
