/*
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */
package com.capsule.transitchecker.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.capsule.transitchecker.service.TransitCheckService;
import com.capsule.transitchecker.verifier.TransitCheck;
import com.capsule.transitchecker.verifier.TransitCheckFactory;

/**
 * The implementation of the service
 * @author christian_suarez
 *
 */
@Service
public class TransitCheckServiceImpl implements TransitCheckService{

	private static final Logger logger = LoggerFactory.getLogger(TransitCheckServiceImpl.class);
	
	
	/**
	 *	@see TransitCheckService.isVehicleAllowedTransit
	 */
	@Override
	public boolean isVehicleAllowedTransit(String vehicleId, Date dateToTransit) {
		
		logger.info("[isVehicleAllowedTransit] vehicle: " + vehicleId + " dateToTransit: " + dateToTransit);
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateToTransit);
		
		List<TransitCheck> transitChecks = TransitCheckFactory.buildTransitCheckRules();
		int index = 1;
		for(TransitCheck tc: transitChecks) {		
			boolean last = transitChecks.size()==index;
			TransitCheck.ProcessTypeEnum processStatus = tc.isTransitValid(vehicleId, cal, last);
			if(processStatus==TransitCheck.ProcessTypeEnum.DISALLOW) {
				return false;
			}else if(processStatus==TransitCheck.ProcessTypeEnum.ALLOW) {
				return true;
			}
			index++;
		}
		
		return true;
	}
	
	

}
