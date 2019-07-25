package com.aurigaInterviews.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aurigaInterviews.service.FetchDataService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller
public class FetchDetailsController {
	
	
	@Autowired
	FetchDataService fetchDataService;
	
	@RequestMapping("/fetchData")
	public ResponseEntity<Map<String,Object>> fetchData() throws JsonParseException, JsonMappingException, IOException, ParseException {
		Map<String,Object> finalResponse = fetchDataService.fetchData();
		
		return ResponseEntity.ok(finalResponse);
	}

}
