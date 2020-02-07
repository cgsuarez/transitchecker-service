/*
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */
package com.capsule.transitchecker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

/**
 * This is the main class that run a spring boot instance for the app
 * @author christian_suarez
 *
 */
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = "com.capsule.transitchecker")
public class Application {
	
	
	
	 private static final Class<Application> applicationClass = Application.class;

	/**
	 * The main entry point of the app
	 * @param args	the string arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(applicationClass, args);
	}

    
    /**
     * This method configures the spring application
     * @param application	the application
     * @return	the application builder
     */
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }	
	   
   
}
