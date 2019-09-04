package com.udacity.course3.reviews.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by prisca on 2019/09/04.
 */
@Embeddable
public class ReviewKey {

    @Column(name = "comment_id")
    Long commentId;

    @Column(name = "product_id")
    Long productId;

    // standard constructors, getters, and setters
    // hashcode and equals implementation

}
