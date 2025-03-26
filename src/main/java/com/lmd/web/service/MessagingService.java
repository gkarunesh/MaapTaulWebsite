/**
 * 
 */
package com.lmd.web.service;

import java.io.Serializable;

import com.lmd.web.utilities.MessagingModel;
import com.lmd.web.utilities.MyResponse;
import com.lmd.web.utilities.Params;



/**
 * @author sudhakar
 *
 */
public interface MessagingService extends Serializable{

	/**
	 * {@code Param.arg1 is mobile no & Param.arg2 is content}
	 */
	MyResponse<?> sendText(Params p) throws Exception;
	
	MyResponse<?> testSendText(Params p) throws Exception;
	
	MyResponse<?> dbtText(Params p) throws Exception;
	
	public MyResponse<?> sendText (MessagingModel data) throws Exception;
	
	public String sendEmail(MessagingModel mModel) throws Exception;
	
}
