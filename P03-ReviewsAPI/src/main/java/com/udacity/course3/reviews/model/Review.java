package com.udacity.course3.reviews.model;

import javax.persistence.*;

/**
 * Created by prisca on 2019/09/04.
 */
@Entity
public class Review {

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "comment_id")
    String commentId;

    @EmbeddedId
    ReviewKey reviewKeyId;

    @ManyToOne
    //@MapsId("product_id")
    @JoinColumn(name = "product_id")
    Product product;

    @ManyToOne
    //@MapsId("comment_id")
    @JoinColumn(name = "comment_id")
    Comment comment;

}
