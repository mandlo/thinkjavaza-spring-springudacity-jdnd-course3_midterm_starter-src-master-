package com.udacity.course3.reviews.controller;

import com.udacity.course3.reviews.model.Product;
import com.udacity.course3.reviews.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    ProductRepository productRepository;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody Product product) {
        try {
            productRepository.save(product);
        } catch (Exception e) {
            throw new HttpServerErrorException(HttpStatus.NOT_IMPLEMENTED);
        }
    }

    @RequestMapping(value = "/{id}")
    public ResponseEntity<?> findById (@PathVariable("id") Integer id){
        try {
           return new ResponseEntity<>(productRepository.findById(id), HttpStatus.OK);
            } catch (Exception e) {
                    throw new HttpServerErrorException(HttpStatus.NOT_FOUND);
            }
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<?> listProducts () {
       List<Product> productList = new ArrayList<>();
         try {
              productList = productRepository.findAll();
                    return productList;
             } catch (Exception e) {
                    throw new HttpServerErrorException(HttpStatus.NOT_IMPLEMENTED);
             }
        }
   }