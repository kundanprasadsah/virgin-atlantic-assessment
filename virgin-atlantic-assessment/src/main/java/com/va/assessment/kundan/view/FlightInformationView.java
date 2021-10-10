/**
 * 
 */
package com.va.assessment.kundan.view;

import java.time.LocalDate;
import java.util.List;

import com.va.assessment.kundan.model.Flight;

/**
 * @author Kundan
 *
 */
public class FlightInformationView {

	private LocalDate date;
	
	private List<FlightView> flightList;

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public List<FlightView> getFlightList() {
		return flightList;
	}

	public void setFlightList(List<FlightView> flightList) {
		this.flightList = flightList;
	}

}
