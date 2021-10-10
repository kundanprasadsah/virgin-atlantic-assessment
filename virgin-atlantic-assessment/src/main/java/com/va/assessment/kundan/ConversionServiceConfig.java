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
 *
 */
@Configuration
public class ConversionServiceConfig {

	@Bean
	@Primary
	public ConversionService createConversionServiceAndRegisterConvetor() {
		
		DefaultConversionService conversionService = new DefaultConversionService();
		
		conversionService.addConverter(new FlightConvertor());
		
		return conversionService;
	}
}
