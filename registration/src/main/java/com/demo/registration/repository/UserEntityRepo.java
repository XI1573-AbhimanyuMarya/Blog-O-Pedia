package com.demo.registration.repository;

import com.demo.registration.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserEntityRepo extends JpaRepository<UserEntity,Long> {

   Optional<UserEntity> findByEmail(String email);

}
