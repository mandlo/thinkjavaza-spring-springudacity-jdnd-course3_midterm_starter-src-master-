package com.udacity.course3.reviews.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by prisca on 2019/09/04.
 */
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    private String productName;

    @OneToMany
    private List<Review> reviewList;

    @ManyToMany //(cascade = { CascadeType.ALL })
    private List<Comment> comments;

    public Product() {
    }

    public Product(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }
}
