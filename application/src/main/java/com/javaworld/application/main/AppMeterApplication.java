package com.javaworld.application.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


/**
 * @author O-AbdelRahman.Attya
 */


/**
 * to do
 * =======
 * 
 * -1 - read database columns names from a properties file, cause we can have 
 *      different databases with different column names
 *      
 * 1- what is the difference between java.util.Date and
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
 * 11- BE >> add devtools dependency   --->> don't it cause alot of weird memory issues
 * 12- BE >> configure hibernate to use a custom logger
 * 15- FE >> send audit info details from audit list component to audit-info component
 *           when clicking on >> icon.. and don't retrieve audit details from backend
 * 16- FE >> filter by response status [success/fail]
 * 17- FE & BE >> allow extracting reports such as hits on services or projects
 * 18- FE & BE >> show traffic in dash board
 * 19- FE >> allow xml formatting for audit logs
 * 20- FE >> add loading spinner when audits list is not retrieved yet..
 *           and also for the audit entry details
 * 21- BE >> make this project as a jar that can be easily added to 
 *           any app 
 *           
 *
 *     
 * done
 *=======
 * >> BE >> retrieve audits ordered by request time descending
 * >> BE >> handle case when log file does not has date in it's name
 *           [the same day request]
 * >> BE >> return only first 20 request.
 * >> FE & BE >> add pagination, search by user name & URL
 * >> FE >> change mouse shape to hand when hover on >> mark

 */

//@EntityScan(basePackages = { "com.javaworld.application" })
@SpringBootApplication(scanBasePackages = { "com.javaworld.application" }, 
                       exclude = { DataSourceAutoConfiguration.class })
public class AppMeterApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(AppMeterApplication.class, args);
	}
	
}
