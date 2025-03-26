/**
 * 
 */
package com.lmd.web.enums;

/**
 * @author chandan
 *
 */
public interface Message {
	
	/**
	 * {@code Load file inline}.
	 * @see #HEAD_A
	 */
	public static final String FEE_CALC = "EITHER FEE HAS NOT CALCULATED OR NOT IN VALID STATE";
	public static final String REGISTERED = "SUCCESSFULLY REGISTERED. USER ID: ";
	public static final String UPDATED = "SUCCESSFULLY UPDATED. ID: ";
	public static final String MULTIPLE = "MULTIPLE RECORD(s) FOUND.";
	public static final String CHECKSUM = "CHECKSUM MISMATCHED";
	public static final String ENCDATA = "NULL ENCDATA";
	public static final String REFERENCE_NO = "NOTE OUR REFERENCE NUMBER: ";
	
	public static final String NOT_FOUND = "NO RECORD FOUND FOR THE REQUEST. ";
	public static final String NO_PENDING = "NO PENDING RECORD FOUND. ";
	public static final String CHK_INV = "CHECKSUM INVALIDATED.";
	public static final String FILE_NOT_FOUND = "File not found. ";
	
	public static final String COULD_NOT_STORE = "Could not store file. ";
	public static final String TRY_AGAIN = "Please try again. ";
	public static final String INVALID_SESSION = "IT SEEMS SESSION HAS INVALIDATED. KINDLY LOGIN TO CONTINUE.";
	
	public static final String NO_PRIMARY = "Parent ID is missing in the request.";
	public static final String INVALID_LICENSING_STATUS = "YOUR PAYMENT IS YET TO BE DONE FOR LICENSING.";
	
	/**
	 * OTP Messages..
	 */
	public static final String USER_ALREADY_EXISTS = "User already exists with user id provided ";
}
