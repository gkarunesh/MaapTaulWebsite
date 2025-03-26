package com.lmd.web.utilities;

public enum KeyEnum {
	
	/**
	 * {@code After user registration } 
	 */
	REGISTRATION(1307162245279028680L,"You have successfully register with Legal Metrology, Bihar. Your user id is #. Please sign in and go for license/certificate - Bihar Government."),
	/**
	 * {@code After Application Submission for Manufacturer/Dealer/ Repairer } 
	 */
	LIC_APP_SUB(1307162245284614904L,"Dear consumer your application is successfully submitted and transferred to controller, Legal Metrology, Bihar. Your consumer id is #. - Bihar Government."),
	/**
	 * {@codeAfter Application Submission for Trader } 
	 */
	CER_APP_SUB(1307162245288603841L,"Dear consumer your application is successfully submitted and transfer to concerning Inspector, @ Legal Metrology, Bihar. Your trader id is #. - Bihar Government."),
	/**
	 * {@codeAfter Fee Calculation (VC)  } 
	 */
	FEE_CALC(1307162245295130366L,"Dear consumer, Id #.  your verification date   is @, estimated verification n charge would be  Rs. $ - Bihar Government."),
	/**
	 * {@codeAfter Payment Transaction } 
	 */
	PAYMENT(1307162245299065455L,"Dear consumer, your payment is successful and reference Id is #. - Bihar Government"),
	/**
	 * {@codeAfter Verification for weights/ Instruments } 
	 */
	VERIFIED(1307162245307380352L,"Dear consumer, your verification for the applied instruments is done. - Bihar Government."),
	/**
	 * {@codeAfter Certificate signature } 
	 */
	DSC_SIGNED(1307162245356038422L,"Dear consumer your digitally signed certificate is now available. Kindly login and download.- Bihar Government"),
	/**
	 * {@codeAfter Registration Time (Mobile verification) } 
	 */
	OTP(1307162245360432724L,"Dear consumer, #. is your OTP - Bihar Government."),
	/**
	 * {@codeAfter Advice generation for payment against  license } 
	 */
	ADVISE_GEN(1307162245366019416L,"Dear consumer your application id # has been accepted. Visit your profile and pay  Rs. $ for licensing. Legal Metrology,- Bihar Government."),
	/**
	 * {@codeAfter inspection successfull } 
	 */
	INSPECTION_VERIFIED_OK(1307162245288603841L,"Dear consumer, your inspection has been done in which no mistake has been found to concerning Inspector, @ Legal Metrology, Bihar. Your inspection Id is #. - Bihar Government.");	
	
	private String val;

	KeyEnum(String val) {
		this.val = val;
	}

	public String val() {
		return val;
	}	
	
	/**
	 * 
	 */
	private Long templateId;
	/**
	 * 
	 */
	private String message;
	/**
	 * @return the status
	 */
	public Long getTemplateId() {
		return templateId;
	}
	/**
	 * @param status the status to set
	 */
	public void setTemplateId(Long templateId) {
		this.templateId = templateId;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	public String getMessage(Long templateId) {
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
	private KeyEnum(Long templateId, String message) {
		this.templateId = templateId;
		this.message = message;
	}
}
