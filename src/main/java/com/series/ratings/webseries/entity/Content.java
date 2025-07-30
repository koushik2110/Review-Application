package com.series.ratings.webseries.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import com.series.ratings.webseries.request.ContentType;

import lombok.Data;

@Data
@Document(collection = "content_dtl")
public class Content {

	@Id
	private String id;
	private String title;
	private ContentType type;
    private int releaseYear;
    private List<String> cast;
    private List<String> genre;
    private String description;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;
}
