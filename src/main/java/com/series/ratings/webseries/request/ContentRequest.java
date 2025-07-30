package com.series.ratings.webseries.request;

import java.util.List;

import lombok.Data;

@Data
public class ContentRequest {
	private ContentType type;
    private String title;
    private int releaseYear;
    private List<String> cast;
    private List<String> genre;
    private String description;
}
