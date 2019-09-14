package com.udacity.course3.reviews.repository;

import com.udacity.course3.reviews.model.Comment;
import com.udacity.course3.reviews.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by prisca on 2019/09/04.
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    List<Comment> findByReview(Review review);

}
