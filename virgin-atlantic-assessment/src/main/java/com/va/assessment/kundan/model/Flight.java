package com.va.assessment.kundan.model;

import java.time.DayOfWeek;
import java.util.Set;

import com.opencsv.bean.CsvBindByName;

public class Flight {

	// Departure Time,Destination,Destination Airport IATA,Flight No,Sunday,Monday,Tuesday,Wednesday,Thursday,Friday,Saturday
	@CsvBindByName (column = "Departure Time", required = true )
	private String departureTime;
	
	@CsvBindByName (column = "Destination", required = true )
	private String destination;
	
	@CsvBindByName (column = "Destination Airport IATA", required = true )
	private String destinationAirportIATA;
	
	@CsvBindByName (column = "Flight No", required = true )
	private String flightNumber;
	
	@CsvBindByName (column = "Sunday")
	private String sunday;
	
	@CsvBindByName (column = "Monday")
	private String monday;
	
	@CsvBindByName (column = "Tuesday")
	private String tuesday;
	
	@CsvBindByName (column = "Wednesday")
	private String wednesday;
	
	@CsvBindByName (column = "Thursday")
	private String thursday;
	
	@CsvBindByName (column = "Friday")
	private String friday;
	
	@CsvBindByName (column = "Saturday")
	private String saturday;

	private Set<DayOfWeek> departureDays;
	
	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
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

	public String getSunday() {
		return sunday;
	}

	public void setSunday(String sunday) {
		this.sunday = sunday;
	}

	public String getMonday() {
		return monday;
	}

	public void setMonday(String monday) {
		this.monday = monday;
	}

	public String getTuesday() {
		return tuesday;
	}

	public void setTuesday(String tuesday) {
		this.tuesday = tuesday;
	}

	public String getWednesday() {
		return wednesday;
	}

	public void setWednesday(String wednesday) {
		this.wednesday = wednesday;
	}

	public String getThursday() {
		return thursday;
	}

	public void setThursday(String thursday) {
		this.thursday = thursday;
	}

	public String getFriday() {
		return friday;
	}

	public void setFriday(String friday) {
		this.friday = friday;
	}

	public String getSaturday() {
		return saturday;
	}

	public void setSaturday(String saturday) {
		this.saturday = saturday;
	}

	public Set<DayOfWeek> getDepartureDays() {
		return departureDays;
	}

	public void setDepartureDays(Set<DayOfWeek> departureDays) {
		this.departureDays = departureDays;
	}

}
