Calling Twilio API withh Feign

Sign up for a Twilio no-cost trial account
https://www.twilio.com/
The trial account gives you a trial US-based number and a trial balanace ($15). By default, the US phone number can send/receive calls, send/receive SMS to/from US domestic numbers only.

You need to enable call to countries other than the US. If not, you will get a HTTP 400 Bad Request.
On the "Develop" side menu, go to "Voice" -> "Settings" -> "Geo permissions" and select country required.
https://www.twilio.com/console/voice/calls/geo-permissions/low-risk

============================================================
References:

Twilio Programmable Voice documentation
https://www.twilio.com/docs/voice

For a quick intro on making outbound phone calls with Java:
https://www.twilio.com/docs/voice/quickstart/java#make-a-phone-call-with-java
Console steps
Introduce obligatory key parameters (SID, To, From, Twiml)
Intro to TwiML (Twilio Markup Language)

For info on Call(an object) properties/parameters 
https://www.twilio.com/docs/voice/api/call-resource


https://www.twilio.com/docs/voice/twiml
For info on how TwiML works.
At its core, TwiML is an XML document with special tags defined by Twilio to help you build your Programmable Voice application.
TwiML structure: the root <Response> element, verbs, and nouns. Case-sensitive.

https://www.twilio.com/docs/voice/twiml/say#
There is a 4,096 Unicode character limit on the text that <Say> can process.
When translating text to speech, the <Say> verb will make assumptions about how to pronounce numbers, dates, times, amounts of money and other abbreviations. Test these situations well.
When saying numbers, "12345" will be spoken as "twelve thousand three hundred forty-five", whereas "1 2 3 4 5" will be spoken as "one two three four five."
Punctuation such as commas and periods will be interpreted as natural pauses.

========================================
Files:

Twilio API does not work with JSON. Body is multipart/form-data
Jackson encoder does not work with form data. Feign formEncoder used instead.
Twilio API requires Basic Authentication (account SID, auth token)

Feign-form reference:
https://github.com/OpenFeign/feign-form


pom.xml
need to add feign-form
other than feign-core, feign-jackson
All Maven dependencies are latest version as of 27 Dec 2021.
JRE-17

\Call Twilio API with Feign\src\main\java\com\linkedin\feign\TwilioClient.java
Feign interface with @Header and @RequestLine annotations, method parameters.

\Call Twilio API with Feign\src\test\java\com\linkedin\feign\TwilioClientTest.java
Run Junit test
Argument values
Sensitive values stored in environmental variables, e.g. Twilio Sid, auth token, To number.
Static values for others
BasicAuthRequestInterceptor to deal withh Basic Authentication required by Twilio API
Feign.builder

Extra:
Spring Cloud and Feign form
https://stackoverflow.com/questions/35803093/how-to-post-form-url-encoded-data-with-spring-cloud-feign