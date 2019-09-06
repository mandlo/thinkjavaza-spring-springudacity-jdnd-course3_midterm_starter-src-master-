package com.udacity.course3.reviews.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by prisca on 2019/09/04.
 */
@Entity
public class Comment {

    public Comment(Integer commentId, List<Review> reviewList) {
        this.commentId = commentId;
        this.reviewList = reviewList;
    }

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;

    @OneToMany
    private List<Review> reviewList;

    public Comment() {
    }

    public Comment(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }
}
