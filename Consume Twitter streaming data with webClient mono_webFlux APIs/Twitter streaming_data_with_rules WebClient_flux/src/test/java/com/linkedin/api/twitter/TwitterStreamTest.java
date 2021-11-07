package com.linkedin.api.twitter;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootTest
class TwitterStreamTest {

	// @Value("${TWITTER_BEARER_TOKEN}") use this code if bearer token stored in environmental variable
	private String bearerToken = "Insert Twitter bearer token here";

	private final static String API_TWITTER_ENDPOINT = "https://api.twitter.com";

	private final static String API_TWITTER_STREAM_PATH = "/2/tweets/search/stream";

	private final static String API_TWITTER_STREAM_RULES_PATH = "/2/tweets/search/stream/rules";

	@Autowired
	private WebClient.Builder builder; //gets some auto-configuration with Spring when use .Builder
	
	@Test
	void webClientTest() throws InterruptedException, IOException {
	
		WebClient client = builder
				.baseUrl(API_TWITTER_ENDPOINT)
				.defaultHeaders(headers -> headers.setBearerAuth(bearerToken))
				.build();
		
		//build info we want to pass to rules end-point
		StreamRuleRequest ruleRequest = new StreamRuleRequest(); //construct, instantiate
		ruleRequest.addRule("bitcoin", "bitcoin tag");

		client.post()
			.uri(API_TWITTER_STREAM_RULES_PATH)
			.bodyValue(ruleRequest) //method, cause Object to be serialised to JSON and sent in request body
			.retrieve()
			.toBodilessEntity()
			.subscribe(response -> //subscribe and listen for response. then on response

				client.get() //send as Http GET
				.uri(API_TWITTER_STREAM_PATH) //to stream endpoint
				.retrieve()
				.bodyToFlux(String.class) //used to admit multiple values, need to specify type of value(String). Contrast to mono of project reactive which 
				.filter(body -> !body.isBlank()) //to exclude blank response bodies
				.subscribe(json -> {

				System.out.println(json);
				})
			);	
	System.in.read();
	
	}}
		
		


	