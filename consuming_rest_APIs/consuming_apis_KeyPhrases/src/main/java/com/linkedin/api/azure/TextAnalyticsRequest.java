package com.linkedin.api.azure;

import java.util.ArrayList;
import java.util.List;

//modelled HTTP requestBody needed for API
// <TextDocument> object is in TextDocument.java
public class TextAnalyticsRequest {

	private List<TextDocument> documents = new ArrayList<>();

	public List<TextDocument> getDocuments() {
		return documents;
	}

	public void setDocuments(List<TextDocument> documents) {
		this.documents = documents;
	}

}
