/*
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */
package com.capsule.transitchecker.service;

import java.util.Date;

/**
 * The interface that define the method to verify if the vehicle is 
 * allowed to the transit
 * @author christian_suarez
 *
 */
public interface TransitCheckService {

	/**
	 * Checks if a vehicle is allowed to the transit
	 * @param vehicleId	The vehicle id (Placa)
	 * @param dateToTransit	The date to tranist
	 * @return	true if the vehicle is allowed to the transit or false otherwise
	 */
	boolean isVehicleAllowedTransit(String vehicleId, Date dateToTransit);
}
