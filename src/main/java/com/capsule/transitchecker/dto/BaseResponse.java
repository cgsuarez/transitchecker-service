/*
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */
package com.capsule.transitchecker.dto;

/**
 * The base response for all the api calls
 * @author christian_suarez
 *
 */
public abstract class BaseResponse {
	
	/**
	 * The header
	 */
	protected HeaderResponse header;

	/**
	 * gets the header
	 * @return	the header
	 */
	public HeaderResponse getHeader() {
		return header;
	}

	/**
	 * Sets the header
	 * @param header	the header
	 */
	public void setHeader(HeaderResponse header) {
		this.header = header;
	}

	@Override
	public String toString() {
		return "BaseResponse [header=" + header + "]";
	}
}
