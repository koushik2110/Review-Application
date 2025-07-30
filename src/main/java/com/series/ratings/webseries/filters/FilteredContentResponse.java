package com.series.ratings.webseries.filters;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.series.ratings.webseries.response.ContentResponse;

@JsonFilter("ContentFilter")
public class FilteredContentResponse extends ContentResponse{

}
