package com.linkedin.feign;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import feign.Feign;
import feign.auth.BasicAuthRequestInterceptor;
import feign.form.FormEncoder;

@ActiveProfiles("test")
@SpringBootTest
class TwilioClientTest {

    //@Value("${TWILIO_SID}") //uncomment if using environment variables
    private String twilioSid = "xxx"; //assign values if not storing in environmental variables

    //@Value("${TWILIO_AUTH_TOKEN}")
    private String twilioAuthToken = "9bdxxxx";

    //@Value("${TO_NUMBER}")
    private String toNumber = "+659xxxxxxx";

    private  static final String fromNumber = "+131xxxxxxx";

    private static final String TWILIO_API_DOMAIN = "https://api.twilio.com/";

	@Test
	void sendVoiceMessageTest() {

        BasicAuthRequestInterceptor interceptor = new BasicAuthRequestInterceptor(twilioSid, twilioAuthToken);

        TwilioClient client = Feign.builder()
                .requestInterceptor(interceptor) 
                .encoder(new FormEncoder())
                .target(TwilioClient.class, TWILIO_API_DOMAIN);
        
        client.sendVoiceMessage(twilioSid, toNumber, fromNumber, "<Response><Say>Hello from Twilio. The Java Feign Client to call the Twilio API is successful.The date is 26 December 2021.</Say></Response>");
        //Twiml String text can be changed
    }
}
