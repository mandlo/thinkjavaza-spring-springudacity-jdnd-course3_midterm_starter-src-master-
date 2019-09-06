package com.udacity.course3.reviews.controller;

import com.udacity.course3.reviews.dto.ReviewDto;
import com.udacity.course3.reviews.model.Review;
import com.udacity.course3.reviews.repository.ProductRepository;
import com.udacity.course3.reviews.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Spring REST controller for working with review entity.
 */
@RestController
public class ReviewsController {

    // TODO: Wire JPA repositories here
    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    ProductRepository productRepository;

    /**
     * Creates a review for a product.
     * <p>
     * 1. Add argument for review entity. Use {@link RequestBody} annotation.
     * 2. Check for existence of product.
     * 3. If product not found, return NOT_FOUND.
     * 4. If found, save review.
     *
     * @param productId The id of the product.
     * @return The created review or 404 if product id is not found.
     */
    @RequestMapping(value = "/reviews/products/{productId}", method = RequestMethod.POST)
    public ResponseEntity<?> createReviewForProduct(@PathVariable("productId") Integer productId, @RequestBody Review review) {
        //List<ReviewDto> review = f

        throw new HttpServerErrorException(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * Lists reviews by product.
     *
     * @param productId The id of the product.
     * @return The list of reviews.
     */
    @RequestMapping(value = "/reviews/products/{productId}", method = RequestMethod.GET)
    public ResponseEntity<List<?>> listReviewsForProduct(@PathVariable("productId") Integer productId) {

        throw new HttpServerErrorException(HttpStatus.NOT_IMPLEMENTED);

        private void validateProductExistence(List<ReviewDto> reviews) {
            List<ReviewDto> list = reviews
                    .stream()
                    .filter(rvw -> Objects.isNull(productRepository.findProductById(rvw
                            .getProduct()
                            .getProductId())))
                    .collect(Collectors.toList());

//            if (!CollectionsUtils.isEmpty(list)) {
//                new ResourceNotFoundException("Product not found");
//            }
        }

    }

}

