package com.series.ratings.webseries.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.converter.json.MappingJacksonValue;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.series.ratings.webseries.filters.FilteredContentResponse;
import com.series.ratings.webseries.response.ContentResponse;

public class CommonUtils {
	
	
	public MappingJacksonValue responseFilterUtil(List<ContentResponse> contentList, ModelMapper mapper) {
		List<FilteredContentResponse> filteredList = contentList.stream()
	            .map(c -> mapper.map(c, FilteredContentResponse.class))
	            .collect(Collectors.toList());

	        MappingJacksonValue mapping = new MappingJacksonValue(filteredList);

	        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
	            .filterOutAllExcept("Title", "releaseYear", "cast", "genre", "description");

	        FilterProvider filters = new SimpleFilterProvider()
	            .addFilter("ContentFilter", filter);

	        mapping.setFilters(filters);
	        return mapping;
	}
}
