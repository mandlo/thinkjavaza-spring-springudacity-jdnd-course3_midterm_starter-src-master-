package com.udacity.course3.reviews.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by prisca on 2019/09/04.
 */
@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long productId;
}
