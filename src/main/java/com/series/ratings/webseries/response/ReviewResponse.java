package com.series.ratings.webseries.response;

import lombok.Data;

@Data
public class ReviewResponse {
	private String userID;
	private String contentID;
	private double rating;
	private String reviewComments;	
}
