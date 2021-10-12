package com.va.assessment.kundan.convertor;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.va.assessment.kundan.model.Flight;
import com.va.assessment.kundan.view.FlightView;

@Component
public class FlightConvertor implements Converter<Flight, FlightView> {

	@Override
	public FlightView convert(final Flight source) {
		
		FlightView flightView = new FlightView();
		if (source == null ) {
			return flightView;
		}
		
		flightView.setDepartureTime(convertDepartureTime ( source.getDepartureTime()) );
		flightView.setDestination(source.getDestination());
		
		flightView.setDestinationAirportIATA(source.getDestinationAirportIATA());
		flightView.setFlightNumber(source.getFlightNumber());
		
		return flightView;
	}

	private LocalTime convertDepartureTime(String departureTime) {
		
		if ( departureTime == null ) {
			return null;
		}
		
		DateTimeFormatter formatter  = DateTimeFormatter.ofPattern("H:m");
		LocalTime time = LocalTime.parse(departureTime.trim(), formatter);
		
		return time;
	}
	
}
