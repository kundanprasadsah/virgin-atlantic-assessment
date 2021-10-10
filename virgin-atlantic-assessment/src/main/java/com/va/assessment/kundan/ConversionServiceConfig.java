/**
 * 
 */
package com.va.assessment.kundan;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;

import com.va.assessment.kundan.convertor.FlightConvertor;

/**
 * @author Kundan
 * Configuration file 
 */
@Configuration
public class ConversionServiceConfig {

	/**
	 * Create instance of FlightConvertor and register it with Default Conversion service
	 * @return ConversionService
	 */
	@Bean
	@Primary
	public ConversionService createConversionServiceAndRegisterConvetor() {
		
		DefaultConversionService conversionService = new DefaultConversionService();
		
		conversionService.addConverter(new FlightConvertor());
		
		return conversionService;
	}
}
