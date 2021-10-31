// https://docs.microsoft.com/en-us/rest/api/cognitiveservices-textanalytics/3.1preview4/key-phrases/key-phrases

package com.linkedin.api.azure;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KeyPhrases {

	// @Value("${AZURE_API_KEY}") use this line if API_KEY is stored in environmental variables of computer
	private String azureApiKey = "Enter your API Key from Azure portal here";

	private static final String AZURE_ENDPOINT = "https://restapi.cognitiveservices.azure.com/";
	
	private static final String AZURE_ENDPOINT_PATH = "/text/analytics/v3.1-preview.4/keyPhrases";

	private static final String API_KEY_HEADER_NAME = "Ocp-Apim-Subscription-Key";

	private static final String CONTENT_TYPE = "Content-Type";

	private static final String APPLICATION_JSON = "application/json";
	
	private static final String EXAMPLE_JSON  = "{"
			+ "  \"documents\": ["
			+ "    {"
			+ "      \"language\": \"en\","
			+ "      \"id\": \"1\","
			+ "      \"text\": \"In an e360 interview, Carlos Nobre, Brazil’s leading expert on the Amazon and climate change, "
			+ "discusses the key perils facing the world’s largest rainforest, where a record number of fires are now raging, "
			+ "and lays out what can be done to stave off a ruinous transformation of the region.\""
			+ "    }"
			+ "  ]"
			+ "}";
	
	private static final String textForAnalysis = "In an e360 interview, Carlos Nobre, Brazil’s leading expert on the Amazon and climate change, discusses the key perils facing the world’s largest rainforest, where a record number of fires are now raging, and lays out what can be done to stave off a ruinous transformation of the region.";
	
	//auto-inject from LandonMonitorApplication.java
	@Autowired
	public ObjectMapper mapper;

	@Test
	public void getKeyPhrases() throws IOException, InterruptedException {
		
		TextDocument document = new TextDocument("1", textForAnalysis, "en");
		TextAnalyticsRequest requestBody = new TextAnalyticsRequest();
		requestBody.getDocuments().add(document);

		HttpClient client = HttpClient.newHttpClient();

		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(AZURE_ENDPOINT + AZURE_ENDPOINT_PATH))
				.header(CONTENT_TYPE, APPLICATION_JSON)
				.header(API_KEY_HEADER_NAME, this.azureApiKey)
				.POST(BodyPublishers.ofString(mapper.writeValueAsString(requestBody)))
				.build();
		
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

		assertEquals(200, response.statusCode());
		System.out.println(response.body());
	}
}
