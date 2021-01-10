package com.javaworld.application.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


/**
 * @author O-AbdelRahman.Attya
 */


/**
 * to do
 * =======
 * 1- what is the diffrence between java.util.Date and
 *    java.sql.Date in AuditInfo member variables ?
 *    
 * 2- int vs long identifier mapping by hibernate ?
 * 
 * 3- should  i close the session in hibernate ??
 * 3- should i  create a transaction..even if session reads 
 *    data from data base ??
 *    
 * 4- handle CORS in a better way instead of setting headers directly
 *    in the controller..allow specific  origin only not *
 *    
 * 5-  (FE) => change mouse shape to hand when hover on >> mark
 * 6-  (FE) => fill audit Info fields with data from BE
 * 7-  (FE) => add audit entry id to url and retrieve 
 *             audit info based on it.
 *             
 * 8-   implement audit info dao using (jpa - jpql - named queries - named native queries)
 * 10-  implement auditInfoDao using Hibernate HQL
 * 8- make backend and front end in modules such as in 
 *    thingsboard app
 *    
 * 9- hide all useless elements of the angular template..
 * 11- FE >> add devtools dependency
 *     
 *done
 *=====
 *
 */

@EntityScan(basePackages = { "com.javaworld.application" })
@SpringBootApplication(scanBasePackages = { "com.javaworld.application" })
public class AppMeterApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppMeterApplication.class, args);
	}
	

	/*
	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.addAllowedOrigin("*");		
		config.addAllowedHeader("*");
		config.setAllowCredentials(true);
		config.addAllowedHeader("*");
		config.addAllowedMethod("OPTIONS");
		config.addAllowedMethod("GET");
		config.addAllowedMethod("POST");
		config.addAllowedMethod("PUT");
		config.addAllowedMethod("DELETE");
		config.addExposedHeader("totalPages");
		source.registerCorsConfiguration("/**", config);
		
		return new CorsFilter(source);
	}
	*/

}
