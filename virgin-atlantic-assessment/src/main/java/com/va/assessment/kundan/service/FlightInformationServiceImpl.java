/**
 * 
 */
package com.va.assessment.kundan.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.va.assessment.kundan.helper.FlightCSVReader;
import com.va.assessment.kundan.model.Flight;
import com.va.assessment.kundan.view.FlightInformationView;
import com.va.assessment.kundan.view.FlightSearch;
import com.va.assessment.kundan.view.FlightView;
import com.va.assessment.kundan.view.Template;

/**
 * 
 * @author Kundan
 *
 */
@Service
public class FlightInformationServiceImpl implements IFlightInformationService {

	@Autowired
	private FlightCSVReader csvReader;
	
	@Autowired
	private ConversionService conversionService;
	
	@Override
	public String launchFlightSearchPage(Model model) {
		
		FlightSearch flightSearch = new FlightSearch();
		flightSearch.setDepartureDate(LocalDate.now());
		
		model.addAttribute("flightSearch", flightSearch);
		model.addAttribute("flightSearchAction", "/viewflights");
		return Template.SEARCH_FLIGHT_VIEW.label;
		
	}
	
	@Override
	public String getFlightInformation(FlightSearch flightSearch, Model model) {
		
		LocalDate departureDate = flightSearch.getDepartureDate();
		
		List<FlightView> flightSearchResult = getFlightsOnDate(departureDate);
		
		FlightInformationView flightInfoView = new FlightInformationView();
		
		flightInfoView.setDate(departureDate);
		flightInfoView.setFlightList(flightSearchResult);
		
		model.addAttribute("flightInformation", flightInfoView);
		model.addAttribute("searchFlight", "searchflights");
		return Template.FLIGHT_INFORMATION.label;
		
	}
	
	
	public List<FlightView> getFlightsOnDate(LocalDate departureDate){
		
		if (departureDate == null ) {
			throw new NullPointerException("Departure Date can't be null");
		}
		List<Flight> flightList = csvReader.getFlights();
		
		DayOfWeek departureDay = departureDate.getDayOfWeek();
		
		Stream<Flight> flightsOnDepartureDateStream = flightList.stream().filter(flight -> flight.getDepartureDays().contains(departureDay));
		
		List<FlightView> flightsOnDepartureDateList = new ArrayList<>();
		
		flightsOnDepartureDateStream.forEach(flight -> {
			FlightView flightView = conversionService.convert(flight, FlightView.class);
			flightsOnDepartureDateList.add(flightView);
		});
		
		Collections.sort(flightsOnDepartureDateList);
		
		return flightsOnDepartureDateList;
		
	}
	
}
