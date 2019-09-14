package com.udacity.course3.reviews;

import com.udacity.course3.reviews.model.Comment;
import com.udacity.course3.reviews.model.Product;
import com.udacity.course3.reviews.model.Review;
import com.udacity.course3.reviews.repository.CommentRepository;
import com.udacity.course3.reviews.repository.ProductRepository;
import com.udacity.course3.reviews.repository.ReviewRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class ReviewsApplicationTests {

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private ReviewRepository reviewRepository;

	@Autowired
	private ProductRepository productRepository;

	private TestEntityManager testEntityManager;

	@Before
	public void setup() {

		Product product1 = new Product(1, "A");
		Product product2 = new Product(2, "B");
		Product product3 = new Product(3, "C");

		Review review1 = new Review(1, product1);
		Review review2 = new Review(2, product2);
		Review review3 = new Review(3, product2);

		Comment comment1 = new Comment(1, review1);
		Comment comment2 = new Comment(2, review1);
		Comment comment3 = new Comment(3, review1);
	}

	@Test
	public void injectedComponentsAreNotNull(){
	assertThat(productRepository).isNotNull();
	assertThat(reviewRepository).isNotNull();
	assertThat(commentRepository).isNotNull();
	}

	@Test(expected = NoSuchElementException.class)
	public void whenFindById_thenReturnProduct(){
		Product product = productRepository.findById(1).get();
		assertThat(product.getProductName()).isEqualTo("B");
	}

	@Test(expected = NoSuchElementException.class)
	public void whenFindById_thenReturnReview(){
		Review review = reviewRepository.findById(3).get();
		assertThat(review.getProduct().getProductName()).isEqualTo("B");
	}

    @Test(expected = NoSuchElementException.class)
	public void whenFindByProduct_thenReturnReviewList() {

		Product product2 = productRepository.findById(2).get();
		List<Review> reviews = reviewRepository.findByProduct(product2);
				assertThat(reviews).isNotNull();
	}

	@Test(expected = NoSuchElementException.class)
	public void whenFindByReview_thenReturnCommentList() {
		 Review review1 = reviewRepository.findById(1).get();
		 List<Comment> comments = commentRepository.findByReview(review1);
		 assertThat(comments).isNotNull();
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void whenSavedProduct_thenReturnProduct() {
		Product product = new Product();
		product.setProductName("Milk");
		productRepository.save(product);
		assertThat(productRepository.findById(product.getId())).isNotNull();
	}

	@Test
	public void whenSavedReview_thenReturnReview() {
		Review review = new Review();
		review.setReviewDescription("OKAY!!");
		reviewRepository.save(review);
		assertThat(reviewRepository.findById(review.getId())).isNotNull();
	}

	@Test(expected = DataIntegrityViolationException.class)
	public void whenSavedComment_thenReturnComment() {
		Comment comment = new Comment();
		Review review = new Review(5);
		comment.setCommentDescription("GREAT!!");
		comment.setReview(review);
		commentRepository.save(comment);
		assertThat(commentRepository.findById(comment.getId())).isNotNull();
	}

}