package com.capsule.transitchecker.verifier.impl;

import java.util.Arrays;
import java.util.Calendar;
import java.util.OptionalInt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.capsule.transitchecker.verifier.TransitCheck;

/**
 * This transit check implementation verify the date component of the
 * rule with the last digit of the vehicle id.
 * @author christian_suarez
 *
 */
public class DateTransitCheck implements TransitCheck {
	
	private static final Logger logger = LoggerFactory.getLogger(DateTransitCheck.class);
	
	private int[][] vehicleIdWithDays = {{}, {1,2}, {3,4}, {5,6}, {7,8}, {9,0}, {}};
	

	@Override
	public ProcessTypeEnum isTransitValid(String vehicleId, Calendar dateToGo, boolean last) {
		int lastDigit = Integer.valueOf(vehicleId.substring(vehicleId.length()-1));
		int dayOfWeek = dateToGo.get(Calendar.DAY_OF_WEEK)-1;
		
		//I get the last digit
		logger.info("[isVehicleAllowedTransit] lastDigit = " + lastDigit + " dayOfWeek: " + dayOfWeek + " date: " + dateToGo.getTime());
		int[] allowedVehicleIds = vehicleIdWithDays[dayOfWeek];
		OptionalInt optVehicleId =  Arrays.stream(allowedVehicleIds).filter(vp->vp==lastDigit).findAny();
		if(optVehicleId.isPresent()) {
			return ProcessTypeEnum.CONTINUE_VERIFY;
		}else {
			return ProcessTypeEnum.ALLOW;
		}
	}

}
