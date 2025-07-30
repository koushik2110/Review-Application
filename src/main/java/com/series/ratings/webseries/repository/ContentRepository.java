package com.series.ratings.webseries.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.series.ratings.webseries.entity.Content;

public interface ContentRepository extends MongoRepository<Content, String> {
	 public List<Content> findByType(String type);
	 public Optional<Content> findByTitle(String title);
	 public void deleteByTitle(String title);
}
