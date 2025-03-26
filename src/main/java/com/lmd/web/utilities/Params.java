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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Params {	
	private String arg1;
	private String arg2;
	private String arg3;
	private String arg4;
	private Integer arg5;
	private String arg6;
}
