
package com.linkedin.api.azure;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//Azure Named Entities Recognition endpoint. https://docs.microsoft.com/en-us/azure/cognitive-services/text-analytics/named-entity-types?tabs=general

@SpringBootTest
class AzureNamedEntitiesRecognition {

	// @Value("${AZURE_API_KEY}")  use this if API key stored on computer under "Environmental Variables"
	private String azureApiKey = "enter your API KEY from your Azure Console";

	private static final String AZURE_ENDPOINT = "https://restapi.cognitiveservices.azure.com";
	
	private static final String AZURE_ENDPOINT_PATH = "/text/analytics/v3.1-preview.4/entities/recognition/general";

	private static final String API_KEY_HEADER_NAME = "Ocp-Apim-Subscription-Key";

	private static final String CONTENT_TYPE = "Content-Type";

	private static final String APPLICATION_JSON = "application/json";
	
	private static final String EXAMPLE_JSON  = "{"
			+ "  \"documents\": ["
			+ "    {"
			+ "      \"language\": \"en\","
			+ "      \"id\": \"1\","
			+ "      \"text\": \"The Standard Chartered Bank, headquartered in London, was formed in 1969 through the merger of Standard Bank and Chartered Bank.\""
			+ "    }"
			+ "  ]"
			+ "}";

	@Test
	public void getEntities() throws IOException, InterruptedException {
		
		 // 1.  Create a client 
		 HttpClient client = HttpClient.newHttpClient();

        
		 // 2.  Create the request
		 HttpRequest request = HttpRequest.newBuilder()
			 .header(CONTENT_TYPE, APPLICATION_JSON)
			 .header(API_KEY_HEADER_NAME, azureApiKey)
			 .uri(URI.create(AZURE_ENDPOINT + AZURE_ENDPOINT_PATH))
			 .POST(BodyPublishers.ofString(EXAMPLE_JSON))
			 .build();
				 
		 // 3.  Send the request and receive response
		 HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		 
		 // 4.  Work with the response
		assertEquals(200, response.statusCode());
		System.out.println(response.body());
		 }
 
	 }
