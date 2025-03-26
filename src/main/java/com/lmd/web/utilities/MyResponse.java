/**
 * 
 */
package com.lmd.web.utilities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sudhakar
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
public @Data class MyResponse<T> {
	
	private Integer statusCode;
	private String status;
	private String remarks;
	private int size;
	private T data;
	
	
}