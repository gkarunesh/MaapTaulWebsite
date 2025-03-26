/**
 * 
 */
package com.lmd.web.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmd.web.dto.OfficersDtoInterface;
import com.lmd.web.entity.OfficersDto;
import com.lmd.web.repo.StaffRepo;
import com.lmd.web.service.StaffService;

/**
 * @author sudhakar
 *
 */
@Service
public class StaffServiceImpl implements StaffService{

	private static final long serialVersionUID = 1209795395422023642L;
	
	@Autowired
	private StaffRepo staffRepo;

	@Override
	public List<OfficersDtoInterface> officersByHQ() {
		return staffRepo.getStaffByHQR();
	}

	@Override
	public List<OfficersDtoInterface> officersByDiv() {
		//System.err.println("Div Off :"+staffRepo.getStaffByDIV());
		return staffRepo.getStaffByDIV();
	}

	@Override
	public List<OfficersDtoInterface> officersByDis() {
		return staffRepo.getStaffByDIS();
	}

	@Override
	public List<OfficersDtoInterface> officersBySub() {
		return staffRepo.getStaffBySUB();
	}
	
}