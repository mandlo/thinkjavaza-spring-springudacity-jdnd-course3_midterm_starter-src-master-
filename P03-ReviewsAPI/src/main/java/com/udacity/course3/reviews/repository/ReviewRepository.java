package com.udacity.course3.reviews.repository;

import com.sun.org.apache.regexp.internal.RE;
import com.udacity.course3.reviews.model.Review;
import com.udacity.course3.reviews.model.ReviewKeyPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by prisca on 2019/09/04.
 */
@Repository
public interface ReviewRepository extends JpaRepository<Review, ReviewKeyPK> {

    Optional<Review>findByPk(ReviewKeyPK pk);

    @Query("SELECT r FROM Review r WHERE r.reviewKeyPK.machineId = ?")


}
