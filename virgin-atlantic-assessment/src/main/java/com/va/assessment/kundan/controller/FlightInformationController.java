/**
 * 
 */
package com.va.assessment.kundan.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.va.assessment.kundan.service.IFlightInformationService;
import com.va.assessment.kundan.view.FlightInformationView;
import com.va.assessment.kundan.view.FlightView;

/**
 * @author Kundan
 *
 */
@RestController
public class FlightInformationController {

	@Autowired
	private IFlightInformationService service;
	
	@GetMapping (value = "/flights/{departureDate}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FlightInformationView> getFlightInformation(@PathVariable (name = "departureDate") @DateTimeFormat (iso = ISO.DATE) final LocalDate departureDate ) {
		
		List<FlightView> listOfFlights = service.getFlightsOnDate(departureDate);
		
		FlightInformationView flightInfoView = new FlightInformationView();
		
		flightInfoView.setDate(departureDate);
		flightInfoView.setFlightList(listOfFlights);
		return ResponseEntity.ok(flightInfoView);
		
		
		
	}
}
