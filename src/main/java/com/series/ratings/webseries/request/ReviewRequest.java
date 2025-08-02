package com.series.ratings.webseries.request;

import lombok.Data;

@Data
public class ReviewRequest {
	private String userID;
	private String contentID;
	private double rating;
	private String reviewComments;	
}
