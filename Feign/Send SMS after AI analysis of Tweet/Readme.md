<ul>
<li>To handle streaming data - Twitter API client with WebClient-Flux</li>
<li>To send data for AI sentiment analysis - Azure Cognitive Services API client with HTTP Client/Request Builder</li>
<li>To send SMS to alert user - Twilio's Programmable SMS API with OpenFeign </li>
</ul>

<hr>
<a href = https://www.twilio.com/docs/sms/api>Twilio Programmable SMS API</a>

<a href = https://www.twilio.com/docs/sms/api/message-resource#create-a-message-resource>Message Resource (refers to inbound or outbound message)</a>

<hr>
<p><strong>A2P vs P2P SMS messaging use cases</p></strong>
<p>application-to-person (A2P)</p>
<ul>
<li>one-way messages</li>
<li>marketing messsages</li>
<li>OTP</li>
<li>appointment reminders</li>
</ul>

<p>person-to-person messaging</p>
<ul>
  <li>customer service messaging</li>
</ul>

<hr>
<p>As the programme will be sending SMS for each Tweet, filter the Tweet stream for a subject matter that is not common.</p>
<p>I have used "SCB coin" which does not exist yet.</p>
<p>Twitter API reference: https://developer.twitter.com/en/docs/twitter-api/tweets/filtered-stream/api-reference</p>
<p>add / delete rules, retrieve stream rules, connect to stream</p>
<p>Postman: https://t.co/twitter-api-postman</p>

<br>
<p>Note: The following was added to "application properties" to resolve circular dependecies due to @Bean</p>
<p>spring.main.allow-circular-references = true</p>
