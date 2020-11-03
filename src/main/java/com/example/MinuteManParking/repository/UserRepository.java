package com.example.MinuteManParking.repository;

import com.example.MinuteManParking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsUserByEmail(String email);

    boolean existsUserByUsername(String username);

    User findByUsernameAndPassword(String username, String password);
}
