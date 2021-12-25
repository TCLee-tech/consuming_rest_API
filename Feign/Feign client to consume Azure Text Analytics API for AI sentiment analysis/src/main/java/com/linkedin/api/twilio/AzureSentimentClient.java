// https://github.com/OpenFeign/feign

package com.linkedin.api.twilio;

import com.linkedin.api.azure.SentimentAnalysisResponse;
import com.linkedin.api.azure.TextAnalyticsRequest;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

/* interface groups related methods with empty bodies.
Empty body means that the method does not have any implementation.:
    public void methodName1() {}
Method with body:
    public void methodName2() {
        // body
    }
For Feign, implementation is provisioned at runtime.
Interface cannot contain constructors.
It cannot be used to create objects.
*/
public interface AzureSentimentClient { 

    @RequestLine("POST /text/analytics/v3.0/sentiment") //annotation to describe HTTP request (HTTP method and path)
    @Headers({"Ocp-Apim-Subscription-Key: {apiKey}", "Content-Type: application/json"}) //array of strings within header. Can be static (e.g. Content-Type: MIME type) or dynamic (e.g. Ocp-Apim-Subscription-Key: {apiKey}). {apiKey} is a placeholder/template/expression, value resolved by annotated parameter.
    public SentimentAnalysisResponse analyse(@Param("apiKey") String apiKey, TextAnalyticsRequest request); 
    //parameter named apiKey of type String, annotated with @Param and name of template to replace in Header. When called, the value of the parameter is resolved to the template in Header.
    //parameter named request => See TextAnalyticsRequest.java. TextAnalyticsRequest is the type used to pass "documents" List to Azure. It models the JSON request body sent to Azure. Feign would serialise Object to JSON and send to Azure.

/*
    public SentimentAnalysisResponse analyse(); is the method with no parameters.
    SentimentAnalysisResponse is a class. It defines an ArrayList of objects of type TextDocumentScore
    TextDocumentScore is an object of sentiment score and ID returned by Azure Text Analytics API when a Tweet is fed to it
    
    Feign will automatically deserialize the responseBody coming back from the Azure Text Analytics API into the type returned by this method,
    e.g. JSON response to Java object.
*/
}
