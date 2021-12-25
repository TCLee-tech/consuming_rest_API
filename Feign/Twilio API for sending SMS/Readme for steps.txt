<strong>How to use Twilio to send SMS</strong>

<p>Log in to Twilio Develop console and get 'Account SID', Auth Token' and 'Phone Number'.</p>
	<ul>
		<li>Twilio uses Basic Authentication.</li>
		<li>'Phone Number" appears on SMS as Sender</li>
	</ul>

<p> Go to Twilio Docs -> API Reference -> Message Resource</p>
<a href="https://www.twilio.com/docs/sms/api/message-resource" target="_blank">Link here</a>
<p> get url from curl template<p>

<p>Go to Postman</p>
<ul>
<li>Http method: POST</li>
<li>URL from curl template of Twilio Docs (API reference documentation)</li>
	<ul>
	<li>Authorisation: Basic Authentication</li>
	<li>Username: Twilio Account SID<li>
	<li>Password: Twilio Auth Token</li>
	</ul>

<li>Body: Not JSON. Select 'x-www-form-urlencoded'.</li>
	<ul>
	<li>'From': 'Phone Number' from Twilio console</li>
	<li>'To': Your own mobile number</li>
	<li>'Body': SMS message to send</li>	
	</ul>
</ul>

