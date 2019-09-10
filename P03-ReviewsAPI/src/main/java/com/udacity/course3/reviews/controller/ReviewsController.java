package com.udacity.course3.reviews.controller;

import com.udacity.course3.reviews.model.Product;
import com.udacity.course3.reviews.model.Review;
import com.udacity.course3.reviews.repository.ProductRepository;
import com.udacity.course3.reviews.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Spring REST controller for working with review entity.
 */
@RestController
public class ReviewsController {

    @Autowired
    ReviewRepository reviewRepository;

    @RequestMapping(value = "/reviews/products/{productId}", method = RequestMethod.POST)
    public ResponseEntity<?> createReviewForProduct(@PathVariable("productId") Integer productId, @RequestBody Review review) {

       try {
           Optional<Product> optionalProduct = reviewRepository.findByProductId(productId);
           if (optionalProduct.isPresent()) {
            reviewRepository.save(review);
           return new ResponseEntity<>("Review is created", HttpStatus.CREATED);
           }
       } catch(Exception e) {
           throw new HttpServerErrorException(HttpStatus.NOT_IMPLEMENTED);
       }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/reviews/products/{productId}", method = RequestMethod.GET)
    public ResponseEntity<List<?>> listReviewsForProduct(@PathVariable("productId") Integer productId) {
       List list = new ArrayList<>();
        try{
            Optional<Product> productOptional = reviewRepository.findByProductId(productId);
            if(productOptional.isPresent()) {
                list = reviewRepository.findAll();
                return new ResponseEntity<List<?>>(list, HttpStatus.OK);
            }
        } catch (Exception e) {
            throw new HttpServerErrorException(HttpStatus.NOT_IMPLEMENTED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

