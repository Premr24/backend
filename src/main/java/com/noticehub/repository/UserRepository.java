package com.noticehub.repository;

import com.noticehub.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    //DB access layer for users
    Optional<User> findByEmail(String email);
//    @Query("SELECT u FROM User u WHERE u.status = com.noticehub.entity.User.Status.ACTIVE")
//    List<User> findAllActiveUsers();
}
