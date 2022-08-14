package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CountryApiController {
	
	@Autowired
	private RestTemplate restTemplate; 
	
	private static String url = "https://countriesnow.space/api/v0.1/countries";
	
	@GetMapping(value="/countries")
	public CountryResponse getCountries() {
		
		CountryResponse countries = restTemplate.getForObject(url, CountryResponse.class);
		
		//ResponseEntity<Response> countries = restTemplate.getForObject(uri, Response.class);
				
		return countries;
	}
	
	@GetMapping(value="/countries/states")
	public StateResponse getStates() {
		
		StateResponse states = restTemplate.getForObject(url+"/states",  StateResponse.class);
		
		return states;
	}
}
