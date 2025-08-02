package com.series.ratings.webseries.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.series.ratings.webseries.entity.Review;

public interface ReviewRepository extends MongoRepository<Review, String> {

}
