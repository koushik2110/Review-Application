package com.series.ratings.webseries.service;

import java.util.List;

import com.series.ratings.webseries.request.ContentRequest;
import com.series.ratings.webseries.response.ContentResponse;

public interface IContentService {
      public List<ContentResponse> createContent(List<ContentRequest> content);
      public List<ContentResponse> getContentList();
      public List<ContentResponse> getContent(String type);
	  public ContentResponse updateContent(ContentRequest content);
	  public String deleteContent(List<String> list);
}
