/**
 * 
 */
package com.va.assessment.kundan.view;

import java.time.LocalTime;

/**
 * FlightView holds flight data that will be displayed in UI. It implements Comparable interface 
 * so that the flights can be returned in chronological order of departure time.
 * @author Kundan
 *
 */
public class FlightView implements Comparable<FlightView>{

	private LocalTime departureTime;
	
	private String destination;
	
	private String destinationAirportIATA;
	
	private String flightNumber;

	/**
	 * Compare current Flight's departure time with the departure time of supplied other object 
	 */
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
