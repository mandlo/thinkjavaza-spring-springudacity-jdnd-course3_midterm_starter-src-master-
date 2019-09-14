package com.udacity.course3.reviews.repository;

import com.udacity.course3.reviews.model.Product;
import com.udacity.course3.reviews.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by prisca on 2019/09/04.
 */
@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

    Optional<Review> findById(Integer id);

    List<Review> findByProduct(Product product);

}
