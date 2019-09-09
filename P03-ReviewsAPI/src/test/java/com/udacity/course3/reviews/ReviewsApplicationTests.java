package com.udacity.course3.reviews;

import com.udacity.course3.reviews.model.Comment;
import com.udacity.course3.reviews.model.Product;
import com.udacity.course3.reviews.model.Review;
import com.udacity.course3.reviews.repository.CommentRepository;
import com.udacity.course3.reviews.repository.ProductRepository;
import com.udacity.course3.reviews.repository.ReviewRepository;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.isNotNull;


@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest
public class ReviewsApplicationTests {

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private ReviewRepository reviewRepository;

	@Autowired
	private ProductRepository productRepository;

	@Before
	public void setup() {
		Comment comment = new Comment(2);
		commentRepository.save(comment);
		Review review = new Review(4);
		reviewRepository.save(review);
		Product product = new Product(6);
		productRepository.save(product);
	}


	@Test
	public void contextLoads() {
	}

	@Test
	public void injectedComponentsAreNotNull(){

		assertThat(commentRepository.findById(2),isNotNull());
		assertThat(reviewRepository.findById(4),isNotNull());
		assertThat(productRepository.findById(6),isNotNull());
	}

//3- Make a method for every repository . In this method try to save an object and retrieve it and check if it was retrieved or not


	@Test
	public void whenSavedProduct_thenfindProductName() {
		//create product and save it
		Product product = new Product();
		product.setProductName("Testing_Product");
		productRepository.save(product);

		assertThat(productRepository.findById(product.getProductId()), isNotNull());
	}



}