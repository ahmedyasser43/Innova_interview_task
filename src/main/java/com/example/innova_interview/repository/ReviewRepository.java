package com.example.innova_interview.repository;

import com.example.innova_interview.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
