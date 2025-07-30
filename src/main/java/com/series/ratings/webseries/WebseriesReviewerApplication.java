package com.series.ratings.webseries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@EnableMongoAuditing
@SpringBootApplication
public class WebseriesReviewerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebseriesReviewerApplication.class, args);
	}

}
