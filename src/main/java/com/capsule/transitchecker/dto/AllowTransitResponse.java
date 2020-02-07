/*
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */
package com.capsule.transitchecker.dto;

/**
 * Class that holds the response of the allowed transit request
 * @author christian_suarez
 *
 */
public class AllowTransitResponse extends BaseResponse {

	/**
	 * The allow to transit
	 */
	private boolean allowToTransit;

	/**
	 * gets the allow to transit flag 
	 * @return	The allow to transit flag
	 */
	public boolean isAllowToTransit() {
		return allowToTransit;
	}

	/**
	 * Sets the allow to transit flag 
	 * @param allowToTransit	the allow to transit flag 
	 */
	public void setAllowToTransit(boolean allowToTransit) {
		this.allowToTransit = allowToTransit;
	}

	@Override
	public String toString() {
		return "AllowTransitResponse [allowToTransit=" + allowToTransit + "]";
	}
}
