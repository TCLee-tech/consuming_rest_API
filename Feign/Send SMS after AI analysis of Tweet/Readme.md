To handle streaming data - Twitter API client with WebClient-Flux
To send data for AI sentiment analysis - Azure Cognitive Services API client with HTTP Client/Request Builder
To send SMS to alert user - Twilio's Programmable SMS API with OpenFeign 

Twilio Programmable SMS API
https://www.twilio.com/docs/sms/api
Message Resource (refers to inbound or outbound message)
https://www.twilio.com/docs/sms/api/message-resource#create-a-message-resource

A2P vs P2P SMS messaging use cases
application-to-person (A2P)
one-way messages
marketing messsages
OTP
appointment reminders

person-to-person messaging
customer service messaging


As the programme will be sending SMS for each Tweet, filter the Tweet stream for a subject matter that is not common.
I have used "SCB coin" which does not exist yet.
Twitter API reference
add / delete rules, retrieve stream rules, connect to stream
https://developer.twitter.com/en/docs/twitter-api/tweets/filtered-stream/api-reference
Postman: https://t.co/twitter-api-postman
