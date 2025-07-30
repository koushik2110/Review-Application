package com.series.ratings.webseries.exception;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ErrorDetails {
	
	private String message;
	private String description;
	private LocalDateTime timeStamp;
	public ErrorDetails(String message, String description, LocalDateTime timeStamp) {
		this.message = message;
		this.description = description;
		this.timeStamp = timeStamp;
	}

}