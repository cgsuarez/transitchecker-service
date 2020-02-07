package com.capsule.transitchecker.verifier;

import java.util.Calendar;

/**
 * This interface define the blueprint part of the Visitor Pattern that acts like a
 * series of validator to verifies if the Pico y Placa set of rules is accomplished.
 * 
 * @see <a href="https://refactoring.guru/design-patterns/visitor/java/example">Visitor Pattern</a>
 * @author christian_suarez
 *
 */
public interface TransitCheck {
	
	enum ProcessTypeEnum { CONTINUE_VERIFY, ALLOW, DISALLOW };

	/**
	 * This method verifies if the transit is valid according to the vehicle Id 
	 * (Placa) and the date.
	 * @param vehicleId	The vehicle id (placa)
	 * @param dateToGo	the date on which you plan to travel
	 * @param last	true if this visitor item is the last or false otherwise
	 * @return	CONTINUE_VERIFY if the algorithm should continue checking the next validator
	 * 			ALLOW if we want to avoid the next process and send true (is allow to go)
	 * 			DISALLOW if we want to avoid the next process and sent false (is not allow to go)
	 */
	ProcessTypeEnum isTransitValid(String vehicleId, Calendar dateToGo, boolean last);
}
