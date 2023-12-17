package com.example.innova_interview.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import org.springframework.data.annotation.Id;

import java.util.List;

@Entity
public class Post {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public String title;

    public String body;

    private Integer userId;

    @OneToMany(mappedBy = "post")
    private List<Review> reviews;

    public Integer getUserId() {
        return userId;
    }

    public Integer getId() {
        return id;
    }
}
