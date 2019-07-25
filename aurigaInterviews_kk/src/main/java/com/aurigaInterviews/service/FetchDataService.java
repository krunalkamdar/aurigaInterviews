package com.aurigaInterviews.service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurigaInterviews.rest.AurigaInterviewsRestClient;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class FetchDataService {

	@Autowired
	AurigaInterviewsRestClient client;

	ObjectMapper mapper = new ObjectMapper();
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
	
	public Map<String,Object> fetchData() throws JsonParseException, JsonMappingException, IOException, ParseException {
		
		//REST API Call to get Data
		String resp = client.getData();
		
		List<Map<String, Object>> data1 = mapper.readValue(resp, List.class);
		Map<String, Object> data = data1.get(0);
		Map<String,Object> finalResponse = new HashMap<>();
		for(Entry obj : data.entrySet()) {
			Map<String,Object> value = (Map<String, Object>) obj.getValue();
			//discoveryDate, alertIds, collector
			finalResponse.put("agentVersion", (String) value.get("agentVersion"));
			finalResponse.put("architecture", (String) value.get("architecture"));
			finalResponse.put("cpuModel", (String) value.get("cpuModel"));
			finalResponse.put("description", (String) value.get("description"));
			finalResponse.put("externalIp", (String) value.get("externalIp"));
			
			Map<String,Object> collector = (Map<String, Object>) value.get("collector");
			finalResponse.put("collector", (String)collector.get("collectorName"));
			
			List<Object> alertIds = (List<Object>) value.get("alertIds");
			finalResponse.put("howManyAlerts", alertIds.size());
			
			Date date = sdf.parse((String)value.get("discoveryDate"));
			finalResponse.put("discoveryDate", format.format(date));
			
			
		}
		// Final Response in Map Object
		return finalResponse;
		
	}
	
}
