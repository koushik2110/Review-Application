package com.series.ratings.webseries.request;

import lombok.Data;

@Data
public class UserRequestDTO {
	private String name;
	private int age;
	private String email;
	private String password;
	private String gender;
}
