/*
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */
package com.capsule.transitchecker.configuration;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * This class configure the swagger documentation for the apis
 * @author christian_suarez
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	 
    
	/**
	 * This method configure the swagger scan procedures to generate the documentation
	 * @return	The api producer
	 */
	@Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors
                		.basePackage("com.capsule.transitchecker.controllers.rest"))
                .paths(regex("/api/transitcheck.*"))
                .build()
                .apiInfo(metaData());
    }
 
	 /**
	  * This method returns the metadata to the swagger documentation
	 * @return	The meta data
	 */
	private ApiInfo metaData() {
        ApiInfo apiInfo = new ApiInfo(
                "Transit Checker",
                "Transit Checker Online API",
                "1.0",
                "Terms of service",
                new Contact("Christian Suarez", "https://springframework.guru/about/", "csuarez@capsule-soft.com"),
               "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0");
        return apiInfo;
	 }
    
}
