package com.va.assessment.kundan.helper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.va.assessment.kundan.helper.FlightCSVReader;
import com.va.assessment.kundan.model.Flight;

public class FlightCSVReaderTest {


	@Test
	public void testGetFlight() {
		
		FlightCSVReader csvReader = new FlightCSVReader();
	
		List<Flight> fligtList = csvReader.getFlights();
		
		assertNotNull(fligtList);
		assertThat(fligtList.size()).isEqualTo(27);
	}
}
