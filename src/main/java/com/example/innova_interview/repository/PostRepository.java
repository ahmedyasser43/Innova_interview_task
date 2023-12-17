package com.example.innova_interview.repository;

import com.example.innova_interview.models.Post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("SELECT p FROM Post p WHERE p.userId = :userId ORDER BY p.id")
    public List<Post> getUserPosts(
            @Param("userId") Integer userId,
            @Param("offset") Integer offset,
            @Param("size") Integer size
    );
}
