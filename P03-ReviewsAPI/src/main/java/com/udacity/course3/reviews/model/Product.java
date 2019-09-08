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


}
