package com.example.innova_interview.seed;

import com.example.innova_interview.models.Post;
import com.example.innova_interview.models.Review;
import com.example.innova_interview.repository.PostRepository;
import com.example.innova_interview.repository.ReviewRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataSeeder {

    private final PostRepository postRepository;
    private final ReviewRepository reviewRepository;

    @Autowired
    public DataSeeder(PostRepository postRepository, ReviewRepository reviewRepository) {
        this.postRepository = postRepository;
        this.reviewRepository = reviewRepository;
    }

    @PostConstruct
    public void seedData() {
        seedPosts(50000);
        seedReviews(20000);
    }

    private void seedPosts(int count) {
        List<Post> posts = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Post post = new Post();
            posts.add(post);
        }
        postRepository.saveAll(posts);
    }

    private void seedReviews(int count) {
        List<Review> reviews = new ArrayList<>();
        List<Post> allPosts = postRepository.findAll();
        for (int i = 0; i < count; i++) {
            Review review = new Review();
            review.setPost(getRandomPost(allPosts));
            reviews.add(review);
        }
        reviewRepository.saveAll(reviews);
    }

    private Post getRandomPost(List<Post> posts) {
        int randomIndex = (int) (Math.random() * posts.size());
        return posts.get(randomIndex);
    }
}
