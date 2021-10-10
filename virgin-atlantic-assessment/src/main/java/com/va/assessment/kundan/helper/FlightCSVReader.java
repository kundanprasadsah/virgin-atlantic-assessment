package com.va.assessment.kundan.helper;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.time.DayOfWeek;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.va.assessment.kundan.model.Flight;

/**
 * FlightCSVReader loads flights.csv file from the classpath, read each records and creates a list of flight records.
 * @author Kundan
 *
 */
@Component
public class FlightCSVReader {

	private static final String FLIGHT_CSV_FILE_NAME = "flights.csv";

	private List<Flight> flightList;
	
	public List<Flight> getFlights() {
		
		readFlightsFromCSV();
		
		populateDepartureDays();
		
		return this.flightList;
	}

	/**
	 * Read flight records from flights.csv and stores in the list for future use. 
	 */
	private void readFlightsFromCSV() {

		InputStream flightCSVInputStream = FlightCSVReader.class.getClassLoader().getResourceAsStream(FLIGHT_CSV_FILE_NAME); 
		Reader reader = new BufferedReader(new InputStreamReader(flightCSVInputStream));

		CsvToBean<Flight> flightCSVToBean = new CsvToBeanBuilder(reader).withType(Flight.class).build();

		this.flightList = flightCSVToBean.parse();

	}
	
	/**
	 * Iterate through the flightList List and creates a set of the days when flight departs
	 */
	private void populateDepartureDays() {
		
		for ( Flight flight : this.flightList) {
			flight.setDepartureDays(new HashSet<>());
			
			if ( StringUtils.isNotBlank(flight.getSunday())) {
				flight.getDepartureDays().add(DayOfWeek.SUNDAY);
			}
			if ( StringUtils.isNotBlank(flight.getMonday())) {
				flight.getDepartureDays().add(DayOfWeek.MONDAY);
			}
			if ( StringUtils.isNotBlank(flight.getTuesday())) {
				flight.getDepartureDays().add(DayOfWeek.TUESDAY);
			}
			if ( StringUtils.isNotBlank(flight.getWednesday())) {
				flight.getDepartureDays().add(DayOfWeek.WEDNESDAY);
			}
			if ( StringUtils.isNotBlank(flight.getThursday())) {
				flight.getDepartureDays().add(DayOfWeek.THURSDAY);
			}
			if ( StringUtils.isNotBlank(flight.getFriday())) {
				flight.getDepartureDays().add(DayOfWeek.FRIDAY);
			}
			if ( StringUtils.isNotBlank(flight.getSaturday())) {
				flight.getDepartureDays().add(DayOfWeek.SATURDAY);
			}
		}
	}

}
