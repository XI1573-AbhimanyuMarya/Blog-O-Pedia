package com.demo.registration.repository;

import com.demo.registration.model.PostsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostEntityRepo extends JpaRepository<PostsEntity,Long> {
    Optional<PostsEntity> findByTitle(String title);
}
