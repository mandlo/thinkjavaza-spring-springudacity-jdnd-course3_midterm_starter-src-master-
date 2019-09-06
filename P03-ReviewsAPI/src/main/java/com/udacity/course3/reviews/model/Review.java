package com.udacity.course3.reviews.model;

import javax.persistence.*;

/**
 * Created by prisca on 2019/09/04.
 */
@Entity
public class Review {

    @EmbeddedId
    ReviewKeyPK pk;

    @ManyToOne
    Product product;

    @ManyToOne
    Comment comment;

    @Column(nullable = false)
    private Integer rating;

    public Review() {
        super();
    }

    public Review(Product product, Review review, Integer rating) {
        pk = new ReviewKeyPK();
        pk.setProduct(product);
        pk.setComment(comment);
        this.rating = rating;
    }



}
