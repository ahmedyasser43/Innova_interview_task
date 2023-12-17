package com.example.innova_interview.service;

import com.example.innova_interview.models.Post;
import com.example.innova_interview.models.Review;
import com.example.innova_interview.service.PostService;
import com.example.innova_interview.repository.PostRepository;
import com.example.innova_interview.repository.ReviewRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PostServiceTest {

    @InjectMocks
    private PostService postService;

    @Mock
    private PostRepository postRepository;

    @Mock
    private ReviewRepository reviewRepository;

    // Initialization of mocks
    public PostServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addPostReview_Success() {
        Post post = new Post();
        Review review = new Review();
        review.setPost(post);

        when(postRepository.save(any())).thenReturn(post);
        when(reviewRepository.save(any())).thenReturn(review);
        boolean result = postService.addPostReview(review);

        assertTrue(result);
        verify(postRepository, times(1)).save(any());
        verify(reviewRepository, times(1)).save(any());
    }

    @Test
    void addPostReview_NullComment_Failure() {
        Review review = new Review();
        review.setComment(null);

        boolean result = postService.addPostReview(review);

        assertFalse(result);
    }

    @Test
    void addPostReview_EmptyComment_Failure() {
        Review review = new Review();
        review.setComment("");

        boolean result = postService.addPostReview(review);

        assertFalse(result);
    }


}
