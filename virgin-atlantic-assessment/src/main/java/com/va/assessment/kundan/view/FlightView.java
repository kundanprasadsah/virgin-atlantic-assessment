/**
 * 
 */
package com.va.assessment.kundan.view;

import java.time.LocalTime;

/**
 * @author Kundan
 *
 */
public class FlightView implements Comparable<FlightView>{

	private LocalTime departureTime;
	
	private String destination;
	
	private String destinationAirportIATA;
	
	private String flightNumber;

	@Override
	public int compareTo(FlightView other) {
		return this.departureTime.compareTo(other.departureTime);
	}

	public LocalTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDestinationAirportIATA() {
		return destinationAirportIATA;
	}

	public void setDestinationAirportIATA(String destinationAirportIATA) {
		this.destinationAirportIATA = destinationAirportIATA;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	
	
}
