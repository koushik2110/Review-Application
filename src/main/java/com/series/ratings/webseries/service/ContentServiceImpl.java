package com.series.ratings.webseries.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.series.ratings.webseries.entity.Content;
import com.series.ratings.webseries.exception.NotFoundException;
import com.series.ratings.webseries.repository.ContentRepository;
import com.series.ratings.webseries.request.ContentRequest;
import com.series.ratings.webseries.response.ContentResponse;

@Service
public class ContentServiceImpl implements IContentService {

	@Autowired
	public ContentRepository contentRepo;
	
    private ModelMapper mapper;
    
    public ContentServiceImpl(ModelMapper mapper) {
    	this.mapper = mapper;
    }

	@Override
	public List<ContentResponse> createContent(List<ContentRequest> content) {
		List<Content> newContents = content.stream().map(con->mapper.map(con, Content.class)).collect(Collectors.toList());
		newContents =  contentRepo.saveAll(newContents);
		return newContents.stream().map(con->mapper.map(con, ContentResponse.class)).collect(Collectors.toList());
	}

	@Override
	public List<ContentResponse> getContentList() {
		List<Content> contents = contentRepo.findAll();
		return contents.stream().map(content-> mapper.map(content, ContentResponse.class)).collect(Collectors.toList());
	}

	@Override
	public List<ContentResponse> getContent(String type) {
		List<Content> contentsByType = contentRepo.findByType(type.toUpperCase());
		return contentsByType.stream().map(content-> mapper.map(content,  ContentResponse.class)).collect(Collectors.toList());
	}

	@Override
	public ContentResponse updateContent(ContentRequest content) {
		Content existing = contentRepo.findByTitle(content.getTitle())
	            .orElseThrow(() -> new NotFoundException("Content not found for title: " + content.getTitle()));
		existing.setDescription(content.getDescription());
		Content updatedContent = contentRepo.save(existing);
		return mapper.map(updatedContent, ContentResponse.class);
	}

	@Override
	public String deleteContent(List<String> titles) {
		titles.stream().forEach(title ->{
			contentRepo.deleteByTitle(title);
		});
		return "Deleted Successfully";
	}

}
