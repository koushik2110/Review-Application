package com.series.ratings.webseries.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.series.ratings.webseries.request.ContentDeleteRequest;
import com.series.ratings.webseries.request.ContentRequest;
import com.series.ratings.webseries.response.ContentResponse;
import com.series.ratings.webseries.service.IContentService;
import com.series.ratings.webseries.utils.CommonUtils;

@RestController
@RequestMapping("/reviewer/content")
@CrossOrigin("*")
public class ContentController {
	
        @Autowired
        public IContentService contentService;
        
        @Autowired
        public ModelMapper mapper;
	   
		
	    @PostMapping
		public ResponseEntity<List<ContentResponse>> addConetent(@RequestBody List<ContentRequest> content){
	    	   return new ResponseEntity<List<ContentResponse>>(contentService.createContent(content), HttpStatus.CREATED);
	    }
	    
	    @GetMapping(path = "/list")
	    public ResponseEntity<List<ContentResponse>> getContentList(){
	    	return new ResponseEntity<List<ContentResponse>>(contentService.getContentList(), HttpStatus.OK);
	    }
	    
	    @GetMapping
	    public ResponseEntity<MappingJacksonValue> getContent(@RequestParam("type") String type ){
	    	List<ContentResponse> contentList = contentService.getContent(type);
	    	CommonUtils utils = new CommonUtils();
	    	MappingJacksonValue mapping = utils.responseFilterUtil(contentList,  mapper);
	        return new ResponseEntity<>(mapping, HttpStatus.OK);
	    }
	    
	    @PutMapping
		public ResponseEntity<ContentResponse> updateConetent(@RequestBody ContentRequest content){
	    	   return new ResponseEntity<ContentResponse>(contentService.updateContent(content), HttpStatus.OK);
	    }
	    
	    @DeleteMapping
	    public ResponseEntity<String> deleteContent(@RequestBody ContentDeleteRequest content){
	    	System.out.println(content.getTitles().toString());
	    	return new ResponseEntity<String>(contentService.deleteContent(content.getTitles()), HttpStatus.OK);
	    }
}
