Real-time sentiment analysis of streaming data (tweets from Twitter)

// AZURE
// pass text to Azure Cognitive Services for sentiment analysis

\src\main\java\com\linkedin\api\azure\TextDocument.java
==> the model class. class TextDocument with 3 attributes (id, text, language)
==> create data object (TextDocument) of this model class
==> getter and setter for all 3 attributes

\src\main\java\com\linkedin\api\azure\TextAnalyticsRequest.java
==> putting the <TextDocumnt> data objects into a list
==> ArrayList of <TextDocument> objects
==> object (documents)
==> method (getDocuments) to get such an ArrayList
==> method (setDocuments) to set such an ArrayList

\src\main\java\com\linkedin\api\azure\AzureSentimentService.java
==> get Azure API_Key, path, endpoint for AI sentiment analysis from Azure Cognitive Services
==> import Jackson library for ObjectMapper and JsonNode selection of data
==> instance requestSentimentAnalysis of object SentimentAnalysis
	* instantiate with parameters of text and langiage
	* create new data object (TextDocument), passing in arguments
	* create new ArrayList of <TextDocument> objects
	* get and add new TextDocument object to new ArrayList
==> HttpClient.newBuilder method
==> HttpRequest.newBuilder method
	* build http request with info on URI, header, API_KEY, content type, POST method, timeout
==> HttpResponse method uses BodyHandlers to covert bytes coming back toString
==> then Jackson ObjectMapper reads specific JsonNode key-value pairs to extract the ArrayList (documents) fed to Azure Cognitive Services, and the sentiment score coming back
==> these values are then returned

\src\main\java\com\linkedin\api\azure\SentimentAnalysis.java
==> class SentimentAnalysis
==> class has 2 attributes - an ArrayList of <TextDocument> objects sent to Azure for analysis, and the sentiment score returned
==> getter and setter for both attributes

=======================================================================================================

// TWITTER
// streaming data (Tweets) from social media

\src\main\java\com\linkedin\api\twitter\Tweet
==> class Tweet with 2 attributes - text and id. For Twitter API, all Tweets have unique id
==> no Object in this java file
==> getter and setter for both attributes 

\src\main\java\com\linkedin\api\twitter\StreamResponse
==> create object (data) of Tweet class
==> getter and setter of data
==> create StreamResponse object and return it to whoever that calls it

\src\main\java\com\linkedin\api\twitter\StreamRule
==> class StreamRule
==> it is possible to filter incoming streaming Tweets with key words (rules)
==> each rule is a "value" and each value has a "tag". These are the 2 attributes of the StreamRule class.
==>  constructor
==> getter and setter

\src\main\java\com\linkedin\api\twitter\StreamRuleRequest
==> new ArrayList of <StreamRule>
==> getter and setter of List<StreamRule>
==> method to add rule to new ArrayList
==> there no method to delete rule, so need to use Postman

\src\main\java\com\linkedin\api\twitter\TwitterStreamingService
==> the API for comsuming streaming data from Twitter
==> import reactor Flux library
==> set Twitter bearer token, endpoint and path for streaming data
==> build a WebClient
==> get response to stream path
==> decode response to Flux<String.class>
==> return the Flux<String.class> so that it can be passed to the next method

\src\main\java\com\linkedin\api\StreamingSentimentAnalysis
==> autowired APIs for Twitter streaming service and Azure sentiment analysis service
==> subscribe to Twitter Flux stream
=> Jackson ObjectMapper to deserialise Flux<String.class> to StreamResponse objects of Tweet class
==> send each StreamResponse object to Azure sentiment analysis service