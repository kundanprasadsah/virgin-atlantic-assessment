package com.va.assessment.kundan.service;

import java.time.LocalDate;
import java.util.List;

import com.va.assessment.kundan.view.FlightView;

public interface IFlightInformationService {

	public List<FlightView> getFlightsOnDate(LocalDate departureDate);
}
