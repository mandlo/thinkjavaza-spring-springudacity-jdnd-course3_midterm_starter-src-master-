package com.udacity.course3.reviews;

import com.udacity.course3.reviews.repository.CommentRepository;
import com.udacity.course3.reviews.repository.ProductRepository;
import com.udacity.course3.reviews.repository.ReviewRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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


	@Test
	public void contextLoads() {
	}

//	@Test
//	public void injectedComponentsAreNotNull(){
//		assertThat(commentRepository).isNotNull();
//		assertThat(reviewRepository).isNotNull();
//		assertThat(productRepository).isNotNull();
//	}

}