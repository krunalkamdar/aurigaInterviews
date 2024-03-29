package com.aurigaInterviews.rest;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AurigaInterviewsRestClient {

	@Autowired
	RestTemplate restTemplate;
	
	public String getData() {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity entity = new HttpEntity(headers);
	      
	      // Return data as string
	      //return "[{ \"2b727991-5ddb-4a42-82eb-13bbb2876a28\": { \"agentVersion\": \"0.1.0\", \"alertIds\": [\"0a45fa06-87ad-4ef7-ae30-f05d42beca22\", \"16597623-a5d1-4a21-8304-58c458aefd3b\"], \"architecture\": \"x64\", \"collector\": {\"tenantId\": \"496e3cfd-672c-47ae-9dfb-0d840b0aed80\", \"collectorId\": \"5316b276-18cc-4692-b89b-26ae22a0c4ef\", \"collectorName\": \"Test_Collector\"}, \"cpuModel\": \"Intel(R) Xeon(R) CPU E5-2673 v3 @ 2.40GHz\", \"cpuNumber\": 1, \"description\": \"Auriga Test Device\", \"deviceId\": \"2b727991-5ddb-4a42-82eb-13bbb2876a28\", \"discoveryDate\": \"2019-05-21T16:02:56.819\", \"externalIp\": \"144.0.1.163\", \"externalIpCordLat\": \"52.35\", \"externalIpCordLong\": \"4.9167\", \"externalIpDateUpdated\": \"2019-06-10T09:33:07.932\", \"ipAddresses\": [{\"ipAddress\": \"1.0.0.4\", \"ipFamily\": \"IPv4\", \"macAddress\": \"01:1d:3a:20:da:2d\"}], \"isAgentConnected\": true, \"lastSeenDate\": \"2019-06-10T09:46:00.176Z\", \"name\": \"AurigaDC01\", \"osCode\": \"Windows_NT\", \"platform\": \"win32\", \"registeredDate\": \"2019-05-21T16:02:56.819\", \"release\": \"6.3.9600\", \"updatesScriptLastRun\": \"2019-06-10T09:24:10\" }}]";
	      return restTemplate.exchange("https://api.cybergator.co.uk/testing/devices", HttpMethod.GET,entity,String.class).getBody();
	}
}
