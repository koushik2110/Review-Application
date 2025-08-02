package com.series.ratings.webseries.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.series.ratings.webseries.entity.Review;
import com.series.ratings.webseries.exception.NotFoundException;
import com.series.ratings.webseries.repository.ReviewRepository;
import com.series.ratings.webseries.request.AIReviewRequest;
import com.series.ratings.webseries.request.ReviewRequest;
import com.series.ratings.webseries.response.AIReviewResponse;
import com.series.ratings.webseries.response.ReviewResponse;

@Service
public class ReviewServiceImpl implements IReviewService {
	
	@Autowired
	public ReviewRepository repository;
	
	@Autowired
	public ModelMapper mapper;
	
	@Autowired
	public RestTemplate restTemplate;

	@Override
	public ReviewResponse createReview(ReviewRequest review) {
		AIReviewResponse response = restTemplate.postForObject("http://localhost:8000/validate_review", mapper.map(review, AIReviewRequest.class), AIReviewResponse.class);
		if(response.getStatus().equals("rejected")) {
			throw new NotFoundException("The Comment is inappropriate");
		}
		Review newReview = repository.save(mapper.map(review, Review.class));
		return mapper.map(newReview, ReviewResponse.class);
	}

}
