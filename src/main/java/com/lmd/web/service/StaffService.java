/**
 * 
 */
package com.lmd.web.service;

import java.io.Serializable;
import java.util.List;

import com.lmd.web.dto.OfficersDtoInterface;
import com.lmd.web.entity.OfficersDto;

/**
 * @author sudhakar
 *
 */
public interface StaffService extends Serializable {

	/*public List<OfficersDto> officersByHQ();

	public List<OfficersDto> officersByDiv();
	
	public List<OfficersDto> officersByDis();

	public List<OfficersDto> officersBySub();*/
	
	public List<OfficersDtoInterface> officersByHQ();

	public List<OfficersDtoInterface> officersByDiv();
	
	public List<OfficersDtoInterface> officersByDis();

	public List<OfficersDtoInterface> officersBySub();
	
	
	
}
