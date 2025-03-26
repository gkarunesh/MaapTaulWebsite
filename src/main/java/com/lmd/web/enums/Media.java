/**
 * 
 */
package com.lmd.web.enums;

/**
 * @author sudhakar
 *
 */
public interface Media {
	
	/**
	 * {@code Load file inline}.
	 * @see #HEAD_A
	 */
	public static final String HEAD_I = "inline; filename=\"";
	/**
	 * {@code Load file as attachment}.
	 * @see #HEAD_I
	 */
	public static final String HEAD_A = "attachment; filename=\"";
	/**
	 * {@code Base file location}.
	 */
	    //public static final String BASE_URL = "E:/LMD_DATA/";
	    public static final String BASE_URL = "/home/wmdocx/APP_DATA/";
	    //public static final String BASE_URL = "/docupload/wmdocx/LMD_DATA/";
	    //public static final String BASE_URL = "/home/wmdocx/APP_DATA_DEMO/";
	
	public static final String DOWNLOAD_URL_PRE = "/downloadFile?path=";
	
	public static final String SEPARATOR = "/";
}
