/**
 * 
 */
package com.va.assessment.kundan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.va.assessment.kundan.service.IFlightInformationService;
import com.va.assessment.kundan.view.FlightSearch;

/**
 * Rest controller 
 * @author Kundan
 *
 */
@Controller
public class FlightInformationWebController {

	@Autowired
	private IFlightInformationService service;
	
	@GetMapping("/searchflights")
	public String launchFlightSearchPage(Model model) {
		
		return service.launchFlightSearchPage(model);
	}
	
	@PostMapping("/viewflights")
	public String searchAndViewFlights(@ModelAttribute FlightSearch flightSearch, Model model) {
		
		return service.getFlightInformation(flightSearch, model);
	}
}
