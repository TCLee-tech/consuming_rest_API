package com.linkedin.api.twitter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
//import org.springframework.web.util.UriComponentsBuilder;

import reactor.core.publisher.Mono;

@SpringBootTest
class TwitterSearchTests {

	//@Value("${TWITTER_BEARER_TOKEN}") use this if Twitter's bearer token is stored in environmental variable of computer
	private String bearerToken = "Insert Twitter bearer token here";
	
	private final static String API_TWITTER_ENDPOINT = "https://api.twitter.com";

	private final static String API_TWITTER_TWEETS_PATH = "/2/tweets/search/recent";

	/*
	@Test
	void restTemplateTest() {

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + this.bearerToken);

		String uri = UriComponentsBuilder.fromHttpUrl(API_TWITTER_ENDPOINT + API_TWITTER_TWEETS_PATH)
				.queryParam("query", "LinkedIn Learning")
				.build()
				.toUriString();
		
		HttpEntity<?> entity = new HttpEntity<Object>(headers);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
		
		assertEquals(200, response.getStatusCodeValue());
	}
*/

	@Test
	void webClientTest() throws InterruptedException {

		WebClient client = WebClient.create(API_TWITTER_ENDPOINT); //static create method

		//Mono Object container that publish item in future.
		//utype within Project Reactor (https://projectreactor.io) ..reactive, fully non-blocking.
		//specific generic parameter for what container will hold in future -> a response entity of String type, response received from API
		Mono<ResponseEntity<String>> mono = client.get() //WebClient get request
				.uri(API_TWITTER_TWEETS_PATH + "?query={query}", "bitcoin") //template in {}
				.header("Authorization", "Bearer " + this.bearerToken)
				.retrieve() //retrieve the response entity
				.toEntity(String.class); //convert to response entity with body of String type
		
		/* blocking call with webClient/mono, code will wait until response is received
		API call becomes synchromous
		ResponseEntity<String> response = mono.block(); 
		System.out.println(response.getBody());
		assertEquals(200, response.getStatusCodeValue());
		*/

		mono.subscribe(response -> {
			System.out.println(response.getBody());
			assertEquals(200, response.getStatusCodeValue());
		});

		System.out.println("This should print first in an async call");
		Thread.sleep(5000);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
