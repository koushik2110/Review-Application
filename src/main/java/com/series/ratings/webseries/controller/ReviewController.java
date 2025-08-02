package com.series.ratings.webseries.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.series.ratings.webseries.request.ReviewRequest;
import com.series.ratings.webseries.response.ReviewResponse;
import com.series.ratings.webseries.service.IReviewService;

@RestController
@RequestMapping("/reviewer/review")
@CrossOrigin("*")
public class ReviewController {
	
	@Autowired
	public IReviewService service;
	
	@PostMapping
	public ResponseEntity<ReviewResponse> createReview(@RequestBody ReviewRequest review) {
		return new ResponseEntity<ReviewResponse>(service.createReview(review), HttpStatus.CREATED);
	}
	
}
