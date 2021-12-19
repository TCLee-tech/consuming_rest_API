package com.linkedin.api.twitter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;

@Service
public class TwitterStreamingService {

	//@Value("${TWITTER_BEARER_TOKEN}") use this if TWITTER_BEARER_TOKEN stored in environment variable
	private String bearerToken = "";

	private final static String API_TWITTER_ENDPOINT = "https://api.twitter.com";

	private final static String API_TWITTER_STREAM_PATH = "/2/tweets/search/stream";

	@Autowired
	private WebClient.Builder builder;

	public Flux<String> stream() {

		//1.  Use the WebClient to connect to the stream and return the Flux from the method
		WebClient client = this.builder
				.baseUrl(API_TWITTER_ENDPOINT)
				.defaultHeaders(headers -> headers.setBearerAuth(bearerToken))
				.build();

		return client.get()	//Flux<String> returned here
				.uri(API_TWITTER_STREAM_PATH)
				.retrieve()
				.bodyToFlux(String.class)
				.filter(tweet -> !tweet.isBlank());
	
	}
}
			
		//2.  Using Postman, delete the client's existing rules and create a new rule to filer for "ethereum"
		
		/*There was a rule to filter Tweet stream for "bitcoin" 
		It was setted in my previous exercise. May be different for yours.
		In StreamRuleRequest.java, there is a method to addRule, but there is no method to deleleRule.
		So we use Postman to delete the old rule. Steps for Postman:
		- log in to Postman
		- POST
		- https://api.twitter.com/2/tweets/search/stream/rules 
		- set Authorization - Bearer Token
		- Body: 
		{
    		"delete": {
        		"ids": [
            		"..enter IDs of rule here .."
        		]
    		}
		} 

		To confirm, use GET with same URL and Authorization, no JSON body.

		To add a new rule using POSTMAN, e.g to filter for "ethereum":
		- POST
		- https://api.twitter.com/2/tweets/search/stream/rules 
		- set Authorization - Bearer Token
		- Body: 
		{
    		"add": [
        		{
            		"value": "ethereum",
            		"tag": "ethereum tag"
        		}
    		]
		}

		Reference: https://developer.twitter.com/en/docs/twitter-api/tweets/filtered-stream/api-reference/post-tweets-search-stream-rules#Add
		*/

	