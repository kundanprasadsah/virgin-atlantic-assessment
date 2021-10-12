package com.va.assessment.kundan.view;

public enum FlightInfoTemplate {

	SEARCH_FLIGHT_VIEW("flight-search"),
	FLIGHT_INFORMATION("flight-result");
	
	public final String label;
	
	private FlightInfoTemplate(String label) {
		this.label = label;
	}
}
