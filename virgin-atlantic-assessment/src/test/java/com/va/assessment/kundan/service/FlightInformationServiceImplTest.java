package com.va.assessment.kundan.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.convert.ConversionService;

import com.va.assessment.kundan.TestObjectFactory;
import com.va.assessment.kundan.helper.FlightCSVReader;
import com.va.assessment.kundan.model.Flight;
import com.va.assessment.kundan.view.FlightView;

@SpringBootTest
public class FlightInformationServiceImplTest {

	@Mock
	private ConversionService conversionService;
	
	@Mock
	private FlightCSVReader csvReader;
	
	@InjectMocks
	private FlightInformationServiceImpl flightService;
	
	@Test
	public void getFlightsOnDateTestNullDepartureDate() {
		
		LocalDate departureDate = null;
		
		assertThrows(NullPointerException.class, () -> flightService.getFlightsOnDate(departureDate));
	}
	
	@Test
	public void testFlightsOnSunday() {
		
		List<Flight> flightList = TestObjectFactory.createFlightListRecord();
		FlightView dummyFlightView = TestObjectFactory.createDummyFlightView();
		
		// setup mock rules
		when(this.csvReader.getFlights()).thenReturn(flightList);
		flightList.forEach(flight -> 
			when(this.conversionService.convert(flight, FlightView.class)).thenReturn(dummyFlightView)
		);
		
		LocalDate departureDate = LocalDate.of(2021, 10, 10); // Sunday
		
		// execute service method
		List<FlightView> flightsOnDate = flightService.getFlightsOnDate(departureDate);
		
		// verify
		assertNotNull(flightsOnDate);
		assertThat(flightsOnDate.size()).isEqualTo(9);
		verify(this.csvReader, times(1)).getFlights();
	}
	
	@Test
	public void testFlightsOnMonday() {
		
		List<Flight> flightList = TestObjectFactory.createFlightListRecord();
		FlightView dummyFlightView = TestObjectFactory.createDummyFlightView();
		
		// setup mock rules
		when(this.csvReader.getFlights()).thenReturn(flightList);
		flightList.forEach(flight -> 
			when(this.conversionService.convert(flight, FlightView.class)).thenReturn(dummyFlightView)
		);
		
		LocalDate departureDate = LocalDate.of(2021, 10, 11);
		
		// execute service method
		List<FlightView> flightsOnDate = flightService.getFlightsOnDate(departureDate);
		
		// verify
		assertNotNull(flightsOnDate);
		assertThat(flightsOnDate.size()).isEqualTo(9);
		verify(this.csvReader, times(1)).getFlights();
	}
	
	@Test
	public void testFlightsOnTuesday() {
		
		List<Flight> flightList = TestObjectFactory.createFlightListRecord();
		FlightView dummyFlightView = TestObjectFactory.createDummyFlightView();
		
		// setup mock rules
		when(this.csvReader.getFlights()).thenReturn(flightList);
		flightList.forEach(flight -> 
			when(this.conversionService.convert(flight, FlightView.class)).thenReturn(dummyFlightView)
		);
		
		LocalDate departureDate = LocalDate.of(2021, 10, 12);
		
		// execute service method
		List<FlightView> flightsOnDate = flightService.getFlightsOnDate(departureDate);
		
		// verify
		assertNotNull(flightsOnDate);
		assertThat(flightsOnDate.size()).isEqualTo(8);
		verify(this.csvReader, times(1)).getFlights();
	}
	
	@Test
	public void testFlightsOnWednesday() {
		
		List<Flight> flightList = TestObjectFactory.createFlightListRecord();
		FlightView dummyFlightView = TestObjectFactory.createDummyFlightView();
		
		// setup mock rules
		when(this.csvReader.getFlights()).thenReturn(flightList);
		flightList.forEach(flight -> 
			when(this.conversionService.convert(flight, FlightView.class)).thenReturn(dummyFlightView)
		);
		
		LocalDate departureDate = LocalDate.of(2021, 10, 13);
		
		// execute service method
		List<FlightView> flightsOnDate = flightService.getFlightsOnDate(departureDate);
		
		// verify
		assertNotNull(flightsOnDate);
		assertThat(flightsOnDate.size()).isEqualTo(7);
		verify(this.csvReader, times(1)).getFlights();
	}
	
	@Test
	public void testFlightsOnThursday() {
		
		List<Flight> flightList = TestObjectFactory.createFlightListRecord();
		FlightView dummyFlightView = TestObjectFactory.createDummyFlightView();
		
		// setup mock rules
		when(this.csvReader.getFlights()).thenReturn(flightList);
		flightList.forEach(flight -> 
			when(this.conversionService.convert(flight, FlightView.class)).thenReturn(dummyFlightView)
		);
		
		LocalDate departureDate = LocalDate.of(2021, 10, 14);
		
		// execute service method
		List<FlightView> flightsOnDate = flightService.getFlightsOnDate(departureDate);
		
		// verify
		assertNotNull(flightsOnDate);
		assertThat(flightsOnDate.size()).isEqualTo(7);
		verify(this.csvReader, times(1)).getFlights();
	}
	@Test
	public void testFlightsOnFriday() {
		
		List<Flight> flightList = TestObjectFactory.createFlightListRecord();
		FlightView dummyFlightView = TestObjectFactory.createDummyFlightView();
		
		// setup mock rules
		when(this.csvReader.getFlights()).thenReturn(flightList);
		flightList.forEach(flight -> 
			when(this.conversionService.convert(flight, FlightView.class)).thenReturn(dummyFlightView)
		);
		
		LocalDate departureDate = LocalDate.of(2021, 10, 15);
		
		// execute service method
		List<FlightView> flightsOnDate = flightService.getFlightsOnDate(departureDate);
		
		// verify
		assertNotNull(flightsOnDate);
		assertThat(flightsOnDate.size()).isEqualTo(7);
		verify(this.csvReader, times(1)).getFlights();
	}
	
	@Test
	public void testFlightsOnSaturday() {
		
		List<Flight> flightList = TestObjectFactory.createFlightListRecord();
		FlightView dummyFlightView = TestObjectFactory.createDummyFlightView();
		
		// setup mock rules
		when(this.csvReader.getFlights()).thenReturn(flightList);
		flightList.forEach(flight -> 
			when(this.conversionService.convert(flight, FlightView.class)).thenReturn(dummyFlightView)
		);
		
		LocalDate departureDate = LocalDate.of(2021, 10, 16);
		
		// execute service method
		List<FlightView> flightsOnDate = flightService.getFlightsOnDate(departureDate);
		
		// verify
		assertNotNull(flightsOnDate);
		assertThat(flightsOnDate.size()).isEqualTo(6);
		verify(this.csvReader, times(1)).getFlights();
	}
}
