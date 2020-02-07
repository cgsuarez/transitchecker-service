package com.capsule.transitchecker.verifier.impl;

import java.util.Calendar;

import org.joda.time.DateTime;
import org.joda.time.DateTimeFieldType;
import org.joda.time.Interval;

import com.capsule.transitchecker.verifier.TransitCheck;

/**
 * This implementation is responsible to verify the time component
 * of te Pico y Placa rule
 * 
 * @author christian_suarez
 *
 */
public class HourTransitCheck implements TransitCheck {

	private int startHour;
	private int startMinute;
	private int endHour;
	private int endMinute;
	
	public HourTransitCheck(int startHour, int startMinute, 
				int endHour, int endMinute) {
		this.startHour = startHour;
		this.startMinute = startMinute;
		this.endHour = endHour;
		this.endMinute = endMinute;
	}
	
	
	@Override
	public ProcessTypeEnum isTransitValid(String vehicleId, Calendar dateToGo, boolean last) {
		DateTime trafficDateTime = new DateTime().
				withField(DateTimeFieldType.clockhourOfDay(), dateToGo.get(Calendar.HOUR_OF_DAY))
				.withField(DateTimeFieldType.minuteOfHour(), dateToGo.get(Calendar.MINUTE));
		
		DateTime startDateTime = new DateTime().
						withField(DateTimeFieldType.clockhourOfDay(), startHour)
						.withField(DateTimeFieldType.minuteOfHour(), startMinute);
		DateTime endDateTime = new DateTime().
				withField(DateTimeFieldType.clockhourOfDay(), endHour)
				.withField(DateTimeFieldType.minuteOfHour(), endMinute);
		
		boolean insideTime =  new Interval( startDateTime, endDateTime ).contains( trafficDateTime );
		if(insideTime) {
			return ProcessTypeEnum.DISALLOW;
		}else if(!insideTime && !last) {
			return ProcessTypeEnum.CONTINUE_VERIFY;
		}else if(!insideTime && last){
			return ProcessTypeEnum.ALLOW;
		}
		
		return ProcessTypeEnum.CONTINUE_VERIFY;
		
		
	}

}
