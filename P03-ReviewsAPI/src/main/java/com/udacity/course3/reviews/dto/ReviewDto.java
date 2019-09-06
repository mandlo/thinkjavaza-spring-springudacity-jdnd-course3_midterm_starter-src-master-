package com.udacity.course3.reviews.dto;

import com.udacity.course3.reviews.model.Product;

/**
 * Created by prisca on 2019/09/05.
 */
public class ReviewDto {

    private Product product;
    private Integer rating;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
