/**
 * 
 */
package com.lmd.web.utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * @author karunesh
 *
 */
@Component
public class LmdWebSequnce {

	@Autowired
	JdbcTemplate JdbcTemplate;

	
	public String getAttachmentId() {
		return JdbcTemplate.queryForObject("SELECT nextval('hibernate_sequence')", String.class);
	}
		
}
