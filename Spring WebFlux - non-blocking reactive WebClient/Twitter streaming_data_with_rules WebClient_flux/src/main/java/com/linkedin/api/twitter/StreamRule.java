package com.linkedin.api.twitter;

public class StreamRule {
	//keyword(s)
	private String value; 

	//name rule(s)
	private String tag; 

	public StreamRule(String value, String tag) {
		super();
		this.value = value;
		this.tag = tag;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

}
