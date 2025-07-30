package com.series.ratings.webseries.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.series.ratings.webseries.entity.User;

public interface UserRepository extends MongoRepository<User, ObjectId>{

	User findByName(String name);
	
	User deleteByName(String name);
	
	
}
