/**
 * 
 */
package com.va.assessment.kundan.controller;

import static org.assertj.core.api.Assertions.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.va.assessment.kundan.TestObjectFactory;
import com.va.assessment.kundan.service.FlightInformationServiceImpl;
import com.va.assessment.kundan.view.FlightView;

/**
 * @author Kundan
 *
 */
@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class FlightInformationRestControllerTest {

	
	private MockMvc mockMvc;

	@Mock
	FlightInformationServiceImpl service;
	
	@InjectMocks
	FlightInformationRestController controller;
	
	@BeforeAll
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	@Test
	public void testGetFlightInformation() {
		LocalDate departureDate = LocalDate.of(2021, 10, 10); // Sunday
		
		FlightView dummyFlightView = TestObjectFactory.createDummyFlightView();
		
		List<FlightView> listOfFlights = new ArrayList<>();
		listOfFlights.add(dummyFlightView);
		
		when(this.service.getFlightsOnDate(departureDate)).thenReturn(listOfFlights);
		
		try {
			this.mockMvc.perform(get("/flights/{departureDate}", departureDate)
					.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andReturn();
		} catch (Exception e) {
			e.printStackTrace();
			fail("Test case failed: " + e.getMessage());
		}
		
		verify(this.service, times(1)).getFlightsOnDate(departureDate);
		
	}
}
