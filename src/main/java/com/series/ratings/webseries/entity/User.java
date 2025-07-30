package com.series.ratings.webseries.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "user_dtl")
public class User {
	private String name;
	private int age;
	private String email;
	private String password;
	private String gender;
}
