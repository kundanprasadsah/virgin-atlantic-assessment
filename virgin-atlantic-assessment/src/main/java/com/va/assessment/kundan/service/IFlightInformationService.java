package com.va.assessment.kundan.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.ui.Model;

import com.va.assessment.kundan.view.FlightSearch;
import com.va.assessment.kundan.view.FlightView;

public interface IFlightInformationService {

	public List<FlightView> getFlightsOnDate(LocalDate departureDate);
	
	public String launchFlightSearchPage(Model model);
	
	public String getFlightInformation(FlightSearch flightSearch, Model model);
}
