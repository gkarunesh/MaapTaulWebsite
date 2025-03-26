package com.lmd.web.utilities;

//import javax.mail.Session;

import lombok.Builder;
import lombok.Data;

@Builder
public @Data class MessagingModel {

	/**
	 * Common
	 */
	private String senderId;
	private String password;	
	private String content;
	
	/**
	 * Email
	 */
	private String host;
	private int port;
	private String subject;
	private String[] receipients;
	private String[] carbonCopies;
	private String[] blindCopies;
	
	/**
	 * Text
	 */
	private String userName;
	private String serviceType;
	private String mobileNo;
	
	//private Session session;
	
	
}
