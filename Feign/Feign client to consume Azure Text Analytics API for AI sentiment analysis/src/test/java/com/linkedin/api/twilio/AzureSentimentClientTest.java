package com.linkedin.api.twilio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.linkedin.api.azure.SentimentAnalysisResponse;
import com.linkedin.api.azure.TextAnalyticsRequest;
import com.linkedin.api.azure.TextDocument;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

@ActiveProfiles("test")
@SpringBootTest
class AzureSentimentClientTest {

	//@Value("${AZURE_API_KEY}")
	private String azureApiKey;

	private static final String AZURE_ENDPOINT = "https://xxx.cognitiveservices.azure.com/";

	@Test
	void testFeignPositiveSentiment() throws IOException, InterruptedException {
		
		TextDocument document = new TextDocument("1","SCB coin is great!", "en"); //instantiate, pass arguments
		TextAnalyticsRequest requestBody = new TextAnalyticsRequest();  //see TextAnalyticsRequest.java. New List of TextDocument objects.
		requestBody.getDocuments().add(document); //add document from line 33 to List of TextDocument objects.
		
		SentimentAnalysisResponse analysis = null; //set List of sentiment scores returned by Azure to null. See SentimentAnalysisResponse.java.
		
		AzureSentimentClient client = Feign.builder()
			.decoder(new JacksonDecoder()) //object of type JacksonDecoder(). ..takes JSON responseBody from Azure API and deserializing it
			.encoder(new JacksonEncoder()) // serialize any objects in responseBody sending to Azure API
			.target(AzureSentimentClient.class, AZURE_ENDPOINT); //the interface from AzureSentimentClient.java. the domain of the API.

		analysis = client.analyse(azureApiKey, requestBody);
		//analysis from Line 37 - the output from Azure API
		//client from Line 39 - the Feign builder
		//.analyse - the method in AzureSentimentClient.java Line 26. The values for azureApiKey and requestBody are passed in.

		System.out.println(analysis.getDocuments().get(0).getSentiment()); //printing sentiment score for 1st document in TextDocumentScore list.
		assertNotNull(analysis);
		assertEquals("positive", analysis.getDocuments().get(0).getSentiment());
	}

}
