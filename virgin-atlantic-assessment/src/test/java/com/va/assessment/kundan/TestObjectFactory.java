package com.va.assessment.kundan;

import java.time.LocalTime;
import java.util.List;

import com.va.assessment.kundan.helper.FlightCSVReader;
import com.va.assessment.kundan.model.Flight;
import com.va.assessment.kundan.view.FlightView;

public class TestObjectFactory {

	public static List<Flight> createFlightListRecord(){
		
		FlightCSVReader csvReader = new FlightCSVReader();
		
		List<Flight> fligtList = csvReader.getFlights();
		
		return fligtList;
	}
	
	public static FlightView createDummyFlightView() {
		
		FlightView flightView = new FlightView();
		
		flightView.setDepartureTime(LocalTime.now());
		flightView.setDestination("Dummy");
		flightView.setDestinationAirportIATA("Dummy");
		flightView.setFlightNumber("Dummy");
		return flightView;
	}
}
