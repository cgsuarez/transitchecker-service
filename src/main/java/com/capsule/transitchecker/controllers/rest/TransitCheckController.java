/*
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */

package com.capsule.transitchecker.controllers.rest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.capsule.transitchecker.dto.AllowTransitRequest;
import com.capsule.transitchecker.dto.AllowTransitResponse;
import com.capsule.transitchecker.dto.HeaderResponse;
import com.capsule.transitchecker.service.TransitCheckService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * This method publish the apis to the transit check
 * @author christian_suarez
 *
 */
@RestController
@RequestMapping(value="/api/transitcheck")
@Api(value="Transit Checker", description = "Operations related to the transit check")
public class TransitCheckController {
	
	private static final Logger logger = LoggerFactory.getLogger(TransitCheckController.class);
	
	private SimpleDateFormat sdfDate = null;	
	
	/**
	 * The service that checks if the vehicle is allow to transit or not
	 */
	@Autowired
	private TransitCheckService transitCheckService;
	
	
	/**
	 * The initialization method
	 */
	@PostConstruct
	public void init() {
		sdfDate = new SimpleDateFormat("dd/MM/yyyy HH:mm");		
	}
	
	/**
	 * Check if a vehicle is allowed to transit
	 * @param request	The request 
	 * @return	The response that tells if the vehicle is allowed to transit
	 */
	@PostMapping("/isAllowTransit")
	@ApiOperation(value="Check if a vehicle is allowed to transit", response = AllowTransitResponse.class)
	public @ResponseBody AllowTransitResponse 
				verifyAllowTransit(@RequestBody AllowTransitRequest request) {
		AllowTransitResponse response = new AllowTransitResponse();
		response.setHeader(new HeaderResponse());
		
		try {
			
			Date dt = sdfDate.parse(request.getDate() + " " + request.getTime());
			response.setAllowToTransit(transitCheckService.isVehicleAllowedTransit(request.getVehicleId(),
					dt));			
			response.getHeader().setCode(0);
			
			logger.info("[verifyAllowTransit] response: " + response);
			
		}catch(ParseException pe) {
			response.getHeader().setCode(-1);
			response.getHeader().setMessage("Format error on date or time");
		}
		
		
		return response;
	}
	
}
