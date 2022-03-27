package com.iapl.apocalypse.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.iapl.apocalypse.models.Robot;

import lombok.RequiredArgsConstructor;



@Component
public class ApocalypseClient {
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	/** This function is called to get a list of robots from IBM azure On success .It takes no parameter and returns a list of robots
	 via a GET method **/
	public List<Robot> listRobotsFromAzure(final String address) throws RestClientException, Exception {
		
		ResponseEntity<Object> response  = null;
		List<Robot> robots = null;
		StopWatch timer = new StopWatch();
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("Content-Type", MediaType.APPLICATION_JSON.toString());   
		HttpEntity<Object> entity = new HttpEntity<Object>(httpHeaders);

		timer.start();
		
		try {   
			    //response = (Object) restTemplate
					//.exchange(address,HttpMethod.GET, entity, Object.class, (Object) Object.class).getBody();
			    
			     response = restTemplate.exchange(address, HttpMethod.GET, entity, Object.class);
			    
			    System.out.println("========== printing response from robots API ===========");
			    System.out.println(response);
			    
			    robots = (List<Robot>) response.getBody();
			    
		} catch(Exception ex) {
			
			timer.stop();
			System.out.println("========== printing exception from the client===========");
			System.out.println(ex.getMessage());
			
		
		}
		
		return robots;
	}

}
