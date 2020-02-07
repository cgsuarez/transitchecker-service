/*
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */
package com.capsule.transitchecker.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * The request to verify if the vehicle allows to the transit
 * @author christian_suarez
 *
 */
public class AllowTransitRequest {

	/**
	 * The vehicle id (Placa)
	 */
	@ApiModelProperty(notes = "The 'Placa' of the vehicle")
	private String vehicleId;
	
	/**
	 * The date to transit in dd/MM/yyyy format
	 */
	@ApiModelProperty(notes = "The date to transit in dd/MM/yyyy format")
	private String date;
	
	/**
	 * The time to transit in HH:mm format
	 */
	@ApiModelProperty(notes = "The time to transit in HH:mm format")
	private String time;
	
	/**
	 * The default constructor
	 */
	public AllowTransitRequest() {
		
	}
	
	/**
	 * The parametrized constructor
	 * @param vehicleId	the vehicleid
	 * @param date	the date
	 * @param time	the time
	 */
	public AllowTransitRequest(String vehicleId, String date, String time)
	{
		this.vehicleId = vehicleId;
		this.date = date;
		this.time = time;
	}
	
	/**
	 * Gets the vehicle id 
	 * @return the vehicle id 
	 */
	public String getVehicleId() {
		return vehicleId;
	}
	/**
	 * Sets the vehicle id 
	 * @param vehicleId	the vehicle id 
	 */
	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}
	/**
	 * Gets the date
	 * @return	the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * Sets the date
	 * @param date	the date
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * Gets the time
	 * @return	the time
	 */
	public String getTime() {
		return time;
	}
	/**
	 * Sets the time
	 * @param time	the time
	 */
	public void setTime(String time) {
		this.time = time;
	}
}
