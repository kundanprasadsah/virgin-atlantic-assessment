package com.va.assessment.kundan.view;

public enum Template {

	SEARCH_FLIGHT_VIEW("flight-search"),
	FLIGHT_INFORMATION("flight-result");
	
	public final String label;
	
	private Template(String label) {
		this.label = label;
	}
}
