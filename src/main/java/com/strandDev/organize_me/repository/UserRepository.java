package com.strandDev.organize_me.repository;

import com.strandDev.organize_me.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository <User, UUID> {
    boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);
}
