package com.udacity.course3.reviews.repository;

import com.udacity.course3.reviews.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by prisca on 2019/09/04.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Optional<Product>findById(Integer id);

}
