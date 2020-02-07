/*
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */
package com.capsule.transitchecker.dto;

/**
 * The header response of all the api calls
 * @author christian_suarez
 *
 */
public class HeaderResponse {

	/**
	 * The code
	 */
	private Integer code;
	/**
	 * The message
	 */
	private String message;
	
	/**
	 * Gets the code
	 * @return	the code
	 */
	public Integer getCode() {
		return code;
	}
	/**
	 * Sets the code
	 * @param code	the code
	 */
	public void setCode(Integer code) {
		this.code = code;
	}
	/**
	 * gets the message
	 * @return	the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * sets the message
	 * @param message	the message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "HeaderResponse [code=" + code + ", message=" + message + "]";
	}
}
