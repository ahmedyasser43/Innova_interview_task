package com.example.innova_interview.controller;

import com.example.innova_interview.models.Post;
import com.example.innova_interview.models.Review;
import com.example.innova_interview.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/post/add/")
    public boolean addPost(@RequestBody Post post) {
        return postService.createPost(post);
    }

    @GetMapping("/posts/{userId}/")
    public List<Post> getUserPosts(
            @PathVariable Integer userId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return postService.getUserPosts(userId, page, size);
    }

    @PostMapping("/posts/review/add/")
    public boolean addReview( @RequestBody Review review) {
        return postService.addPostReview(review);
    }
}