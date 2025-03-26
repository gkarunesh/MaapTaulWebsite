package com.lmd.web.enums;

/**
 * 
 * @author sudhakar
 *
 */

public enum Store {

	/**
	 * Common Keys May 20, is World Metrology Day.
	 */
	//userName("postgres"), welcomeMsg(
			//"National Consumer Day 24 Dec 2021: A market without consumers will be a night sky without the stars and moon. Protect their rights and serve them the best for greater reputation and Fame."),

	/**
	 * Live Connection
	 */

	
	//connectionString("jdbc:postgresql://192.168.185.80:5432/lmdb"),
	//password("Postgres@123"),  baseUrl("/home/MAAPTAUL_DOCS/"), 
//	 

	/**
	 * Local Connection
	 */
	
//	  connectionString("jdbc:postgresql://192.168.1.20:5432/lmdb"),
//	  password("postgres"), baseUrl("/home/wmdocx/"),

	/**
	 * SMS Service
	 */

	userSms("BIHAREDISTRICT-agrilegalmetro"), passSms("abc@123"), serviceTypeSms("singlemsg"), senderIdSms("BRGOVT"),
	requestUrlSms("https://msdgweb.mgov.gov.in/esms/sendsmsrequest?"),

	/**
	 * Email 587
	 */
	host("smtp.gmail.com"), port(587), senderIdEmail("nicpatna.lmd@gmail.com"), passEmail("Yomo@2025"),

	rating_feedBack(
			"Dear Sir/Madam,\n\nWe appreciate your feedback to give our best.\nThanks for your valuable feedback.\n\nThanks & Regards\nWeights & Measures Division, Patna"),

	PASS_KEY("DMLKS");

	/**
	 * String values constructor
	 */
	private String val;

	Store(String val) {
		this.val = val;
	}

	public String val() {
		return val;
	}

	/**
	 * Integer values constructor
	 */
	private int intValue;

	Store(int val) {
		this.intValue = val;
	}

	public int iVal() {
		return intValue;
	}

	/**
	 * 
	 */
	private int status;
	/**
	 * 
	 */
	private String message;

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @param status
	 * @param message
	 */
	private Store(int status, String message) {
		this.status = status;
		this.message = message;
	}

}
