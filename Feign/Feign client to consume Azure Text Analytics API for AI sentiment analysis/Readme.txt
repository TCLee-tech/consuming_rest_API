
Files involved:

pom.xml
Add "feign-core" and "feign-jackson" dependencies.

AZURE folder
\src\main\java\com\linkedin\api\azure\TextDocument
the model.
attributes: text for Azure sentiment analysis, language of text, id of text.
getter and setter for attributes.

\src\main\java\com\linkedin\api\azure\TextAnalyticsRequest
ArrayList of the <TextDocument> object.
getter and setter

\src\main\java\com\linkedin\api\azure\SentimentAnalysisResponse
ArrayList of TextDocumentScore object
each TextDocumentScore object has attributes of id and sentiment
getter and setter for object and List

TWILIO folder ** important **
\src\main\java\com\linkedin\api\twilio\AzureSentimentClient.java
Feign used here
interface xxx {	 
	@RequestLine and @Headers annotations
	method from Class for SentimentAnalysisResponse (type parameter1, type parameter2)
	//no body
}


test folder for TWILIO ** important **
\src\test\java\com\linkedin\api\twilio\AzureSentimentClientTest.java
To test for positive sentiment
introduce positive sentiment arguments to object model that will be fed to Azure API.
instantiate new TextAnalyticsRequest (the array of objects passed as HTTP requestBody)
get and add the arguments into requestBody
set the response coming back from Azure sentiment analysis (SentimentAnalysisResponse) to null 
Feign.builder 	- set Jackson decoder & encoder (for (de)serialisation)
		- set end point
response from Azure API = Feign builder with all the header and body details
printing out the sentiment returned in console for eyeballs sight
assert that the response is not null and equals to positive. 


