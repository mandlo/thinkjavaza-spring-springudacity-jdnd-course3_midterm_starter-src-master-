package com.udacity.course3.reviews.model;

import javax.persistence.*;

/**
 * Created by prisca on 2019/09/04.
 */
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @MapsId("product_id")
    @JoinColumn(name = "product_id")
    Product product;

    private String reviewDescription;

    public Review() {
        super();
    }

    public Review(Integer reviewId) {
        this.id = reviewId;
    }

    public Review(Integer reviewId, Product product) {
        this.id = reviewId;
        this.product = product;
    }

    public Integer getReviewId() {
        return id;
    }

    public void setReviewId(Integer reviewId) {
        this.id = reviewId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getReviewDescription() {
        return reviewDescription;
    }

    public void setReviewDescription(String reviewDescription) {
        this.reviewDescription = reviewDescription;
    }
}
