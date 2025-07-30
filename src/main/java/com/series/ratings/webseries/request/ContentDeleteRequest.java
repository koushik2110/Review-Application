package com.series.ratings.webseries.request;

import java.util.List;

import lombok.Data;

@Data
public class ContentDeleteRequest {
	private List<String> titles;

}
