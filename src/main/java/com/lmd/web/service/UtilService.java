/**
 * 
 */
package com.lmd.web.service;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.lmd.web.dto.UploadedFileResponse;


/**
 * @author sudhakar
 *
 */
public interface UtilService<T> extends Serializable{

	/**
	 * Captcha generation, returns png of 5 characters
	 * @return 
	 * @throws Exception
	 */
	//CaptchaModel generateCaptcha() throws  Exception;
	
	/**
	 * Checks whether input string is equal to existing one.
	 * @param data
	 * @param input
	 * @return
	 */
	boolean isAuthentic(String data, String input);
	
	Resource loadFileAsResource(String fileName, String location);
	
	UploadedFileResponse copyFile(MultipartFile file, String uploadedFileLocation) throws IOException;
	UploadedFileResponse copyFile(MultipartFile file, String uploadedFileLocation,String uploadedFileName)throws IOException;
	/**
	 * @param obj
	 * @return
	 */
	Optional<T> castIntoOptional(Object obj);

	/**
	 * @param obj
	 * @return
	 */
	Stream<T> castIntoStream(Object obj);
	UploadedFileResponse copyFile(byte[] bytearray, String uploadedFileLocation,String uploadedFileName)throws IOException;

	/**
	 * @param data
	 * @param path
	 * @param charset
	 * @param hashMap
	 * @param height
	 * @param width
	 * @throws WriterException
	 * @throws IOException
	 */
	BufferedImage createQR(String data) throws Exception;

}
