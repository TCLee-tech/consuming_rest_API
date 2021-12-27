package com.linkedin.feign;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface TwilioClient {
    
    @Headers("Content-Type: application/x-www-form-urlencoded")
    @RequestLine("POST 2010-04-01/Accounts/{AccountSid}/Calls.json") // AccountSid is a template expression. Wil be replaced by String accountSid method arguement
    public void sendVoiceMessage(   @Param("AccountSid") String accountSid,  //method arguments
                                    @Param("To") String to,
                                    @Param("From") String from,
                                    @Param("Twiml") String twiml); //Twilio Markup Language
}
