# consuming_rest_API
Consume sync, async and streaming data.

This respository contains codes to consume REST APIs.
  - RestTemplate class is dated, in maintenance mode as of Spring Framework 5.0
  - The codes in this folder are based on more current best practices.
  
There are codes to consume synchronous and asynchronous data.
  - codes used to call Microsoft cognitive services (applied AI).

There are codes to consume streaming data.
  - codes used to handle Tweet data from Twitter (social media).
  
Codes are written using Java reactive programming. This is an asynchronous non-blocking event-driven paradigm.
  - There are seperate codes for the WebClient-Mono and WebClient-Flux paradigm to  deal with single and stream data.

Feign folder
  - Feign is a Java to HTTP client binder for consuming REST text-based API
  - a library originally developed by NetFlix
  - when NetFlix stopped developing Feign, and it became open-source and community-driven, it became known as OpenFeign

All codes are working and screengrabs of output are included as proof.
