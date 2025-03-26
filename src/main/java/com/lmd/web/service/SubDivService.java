package com.lmd.web.service;

import java.util.List;

import com.lmd.web.entity.SubDivision;

	public interface SubDivService{
		
		List<SubDivision> subDivByDistrict(Integer distId);		 
	}
	
