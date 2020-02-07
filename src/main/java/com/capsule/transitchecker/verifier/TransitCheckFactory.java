package com.capsule.transitchecker.verifier;

import java.util.Arrays;
import java.util.List;

import com.capsule.transitchecker.verifier.impl.DateTransitCheck;
import com.capsule.transitchecker.verifier.impl.HourTransitCheck;

/**
 * This class acts like a Factory with the rules that applies to
 * the traffic check (the date and the times. This could be more
 * sophisticated, maybe the rules get from a database.
 * @author christian_suarez
 *
 */
public class TransitCheckFactory {

	/**
	 * Builds the TransitCheck implementation with the rules
	 * related to  Pico y Placa. An improvement could be use
	 * a service and Qualified Name to build the rules 
	 * @return
	 */
	public static List<TransitCheck> buildTransitCheckRules(){
		return Arrays.asList( new DateTransitCheck(), 
					   new HourTransitCheck(7, 0, 9, 30), 
					   new HourTransitCheck(16, 0, 19, 30));
	}
	
}
