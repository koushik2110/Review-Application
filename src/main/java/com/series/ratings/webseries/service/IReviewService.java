package com.series.ratings.webseries.service;

import com.series.ratings.webseries.request.ReviewRequest;
import com.series.ratings.webseries.response.ReviewResponse;

public interface IReviewService {
	
	public ReviewResponse createReview(ReviewRequest review );

}
