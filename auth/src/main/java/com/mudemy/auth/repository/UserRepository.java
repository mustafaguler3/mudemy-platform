package com.mudemy.auth.repository;

import com.mudemy.auth.model.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<AuthUser,Long> {
    Optional<AuthUser> findByUsername(String username);
    Optional<AuthUser> findByEmail(String email);
}
