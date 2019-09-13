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
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.isNotNull;


@RunWith(SpringRunner.class)
@DataJpaTest
public class ReviewsApplicationTests {

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private ReviewRepository reviewRepository;

	@Autowired
	private ProductRepository productRepository;

	@Before
	public void setup() {
		Product product = new Product(6);
		product.setProductName("camera");
		productRepository.save(product);
		Review review = new Review(4);
		review.setReviewDescription("great!!");
		review.setProduct(product);
		reviewRepository.save(review);
		Comment comment = new Comment(2);
		comment.setCommentDescription("Wow!!");
		comment.setReview(review);
		commentRepository.save(comment);

	}

	@Test
	public void contextLoads() {
	}





}