package com.udacity.course3.reviews.repository;

import com.udacity.course3.reviews.model.Product;
import com.udacity.course3.reviews.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by prisca on 2019/09/04.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("select p from Product p where p.productId = :productId")
    Product findByProductId(@Param("productId") Integer id);

}
