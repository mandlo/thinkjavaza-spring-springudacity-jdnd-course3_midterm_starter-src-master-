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

    @Autowired
    ProductRepository productRepository;

    @RequestMapping(value = "/reviews/products/{productId}", method = RequestMethod.POST)
    public ResponseEntity<?> createReviewForProduct(@PathVariable("productId") Integer productId, @RequestBody Review review) {

       try {
           Optional<Product> optionalProduct = productRepository.findById(productId);
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
       List<Review> reviewList = new ArrayList<>();
        try{
            Optional<Product> productOptional = productRepository.findById(productId);
            if(productOptional.isPresent()) {
                Product product = productOptional.get();
                reviewList = reviewRepository.findByProduct(product);
                return new ResponseEntity<List<?>>(reviewList, HttpStatus.OK);
            }
        } catch (Exception e) {
            throw new HttpServerErrorException(HttpStatus.NOT_IMPLEMENTED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

