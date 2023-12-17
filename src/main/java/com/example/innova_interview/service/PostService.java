package com.example.innova_interview.service;

import com.example.innova_interview.models.Post;
import com.example.innova_interview.models.Review;
import com.example.innova_interview.repository.PostRepository;
import com.example.innova_interview.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final ReviewRepository reviewRepository;

    @Autowired
    public PostService(PostRepository postRepository, ReviewRepository reviewRepository) {
        this.postRepository = postRepository;
        this.reviewRepository = reviewRepository;
    }
    public boolean createPost(Post post){
        try {
            postRepository.save(post);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Post> getUserPosts(Integer userId, int page, int size) {

        int offset = page * size;

        List<Post> pagePosts = postRepository.getUserPosts(userId, offset, size);

        return pagePosts;
    }

    @Transactional
    public boolean addPostReview(Review review) {
        try {
            Post post = review.getPost();

            if (review.comment == null || review.comment.isEmpty()) {
                throw new Exception("Comment is required");
            }

            if (post.getId() == null) {
                //Post deleted
                return false;
            }
            reviewRepository.save(review);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
