package com.va.assessment.kundan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

/**
 * bootstrap the spring boot application  
 * @author Kundan
 *
 */
@SpringBootApplication
@EnableAutoConfiguration (exclude= {ErrorMvcAutoConfiguration.class})
public class VirginAtlanticAssessmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(VirginAtlanticAssessmentApplication.class, args);
	}

}
