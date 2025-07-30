package com.series.ratings.webseries.response;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.series.ratings.webseries.request.ContentType;

import lombok.Data;

@Data
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"})
//@JsonFilter("ContentFilter")
public class ContentResponse {
	@JsonProperty("Title")
	private String title;
//    @JsonIgnore
	private ContentType type;
    private int releaseYear;
    private List<String> cast;
    private List<String> genre;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
