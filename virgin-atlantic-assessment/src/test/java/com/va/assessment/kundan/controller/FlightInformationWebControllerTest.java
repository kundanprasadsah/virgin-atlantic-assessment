/**
 * 
 */
package com.va.assessment.kundan.controller;

import static org.assertj.core.api.Assertions.fail;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.va.assessment.kundan.service.FlightInformationServiceImpl;
import com.va.assessment.kundan.view.FlightInfoTemplate;
import com.va.assessment.kundan.view.FlightSearch;

/**
 * @author Kundan
 *
 */
@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class FlightInformationWebControllerTest {

	private MockMvc mockMvc;
	private ObjectMapper jsonMapper;
	
	@Mock
	FlightInformationServiceImpl service;
	
	@InjectMocks
	FlightInformationWebController controller;
	
	@BeforeAll
	public void setUp() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/resources/templates");
		viewResolver.setSuffix(".html");
		this.mockMvc = MockMvcBuilders.standaloneSetup(controller)
				.setViewResolvers(viewResolver)
				.build();
		this.jsonMapper = Jackson2ObjectMapperBuilder.json().modules(new JavaTimeModule()).build();
	}
	
	@Test
	public void testLaunchFlightSearchPage() {
		
		Model modelMap = new ExtendedModelMap();
		
		when(this.service.launchFlightSearchPage(modelMap)).thenReturn(FlightInfoTemplate.SEARCH_FLIGHT_VIEW.label);
		
		try {
			this.mockMvc.perform(get("/searchflights")
					.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(view().name(FlightInfoTemplate.SEARCH_FLIGHT_VIEW.label));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Test case failed :- ", e.getMessage());
		}
		
		verify(this.service, times(1)).launchFlightSearchPage(modelMap);
		
	}
	
	@Test
	public void testSearchAndViewFlights() {
		
		Model modelMap = new ExtendedModelMap();
		FlightSearch flightSearch = new FlightSearch();
		
		try {
			
			String payload = this.jsonMapper.writeValueAsString(flightSearch);
			
			when(this.service.getFlightInformation(any(FlightSearch.class), any(Model.class))).thenReturn(FlightInfoTemplate.FLIGHT_INFORMATION.label);

			this.mockMvc.perform(post("/viewflights")
					.accept(MediaType.APPLICATION_JSON)
					.content(payload))
			.andExpect(status().isOk())
			.andExpect(view().name(FlightInfoTemplate.FLIGHT_INFORMATION.label));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Test case failed :- ", e.getMessage());
		}

		verify(this.service, times(1)).getFlightInformation(any(FlightSearch.class), any(Model.class));

	}
}
