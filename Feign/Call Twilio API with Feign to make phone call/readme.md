<strong>Calling Twilio API with Feign</strong>

Proof of Work: https://youtu.be/koFYfml6p-I

<p>Sign up for a Twilio no-cost trial account</p>
<ul>
<li>https://www.twilio.com/</li>
<li>The trial account gives you a trial US-based number and a trial balanace ($15). By default, the US phone number can send/receive calls, send/receive SMS to/from US domestic numbers only.</li>
<br>
  
<li>You need to enable call to countries other than the US. If not, you will get a HTTP 400 Bad Request.</li>
<li>In the "Develop" side menu, go to "Voice" -> "Settings" -> "Geo permissions" and select country required.</li>
<li>https://www.twilio.com/console/voice/calls/geo-permissions/low-risk</li>
</ul>

<hr>
<strong>References:</strong>

<p>Twilio Programmable Voice documentation:</p>
<ul>
  <li>https://www.twilio.com/docs/voice</li>
</ul>
<br>

<p>For a quick intro on making outbound phone calls with Java:</p>
<ul>  
<li>https://www.twilio.com/docs/voice/quickstart/java#make-a-phone-call-with-java
<li>Console steps
<li>Introduce obligatory key parameters (SID, To, From, Twiml)
<li>Intro to TwiML (Twilio Markup Language)
</ul>
<br>

<p>For info on Call(an object) properties/parameters:</p> 
<ul>
  <li>https://www.twilio.com/docs/voice/api/call-resource</li>
</ul>
<br>

<p>For info on how TwiML works:</p>
<ul>
<li>https://www.twilio.com/docs/voice/twiml</li>
<li>At its core, TwiML is an XML document with special tags defined by Twilio to help you build your Programmable Voice application.</li>
<li>TwiML structure: the root <Response> element, verbs, and nouns. Case-sensitive.</li>
</ul>
<br>

<p>Say</p>
<ul>
  <li>https://www.twilio.com/docs/voice/twiml/say#</li>
<li>There is a 4,096 Unicode character limit on the text that <Say> can process.</li>
<li>When translating text to speech, the <Say> verb will make assumptions about how to pronounce numbers, dates, times, amounts of money and other abbreviations. Test these situations well.</li>
<li>When saying numbers, "12345" will be spoken as "twelve thousand three hundred forty-five", whereas "1 2 3 4 5" will be spoken as "one two three four five."</li>
<li>Punctuation such as commas and periods will be interpreted as natural pauses.</li>
</ul>
<br>

<p>Extra:</p>
<ul>
<li>Spring Cloud and Feign form</li>
<li>https://stackoverflow.com/questions/35803093/how-to-post-form-url-encoded-data-with-spring-cloud-feign</li>
</ul>

<hr>
<strong>Files:</strong>
<ul>
<li>Twilio API does not work with JSON. Body is multipart/form-data</li>
<li>Jackson encoder does not work with form data. Feign formEncoder used instead.</li>
<li>Twilio API requires Basic Authentication (account SID, auth token)</li>
<br>
<li>Feign-form reference:</li>
<li>https://github.com/OpenFeign/feign-form</li>
</ul>
<br>

<p>pom.xml</p>
<ul>
<li>need to add feign-form, other than feign-core, feign-jackson</li>
<li>All Maven dependencies are latest version as of 27 Dec 2021.</li>
<li>JRE-17</li>
</ul>
<br>

<p>\Call Twilio API with Feign\src\main\java\com\linkedin\feign\TwilioClient.java</p>
<ul><li>Feign interface with @Header and @RequestLine annotations, method parameters.</ul></li>
<br>

<p>\Call Twilio API with Feign\src\test\java\com\linkedin\feign\TwilioClientTest.java</p>
<ul>
<li>Run Junit test</li>
<li>Argument values</li>
<li>Sensitive values stored in environmental variables, e.g. Twilio Sid, auth token, To number.</li>
<li>Static values for others</li>
<li>BasicAuthRequestInterceptor to deal withh Basic Authentication required by Twilio API</li>
<li>Feign.builder</li>
</ul>
