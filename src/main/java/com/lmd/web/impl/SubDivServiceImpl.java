package com.lmd.web.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmd.web.entity.SubDivision;
import com.lmd.web.repo.SubDivisionRepo;
import com.lmd.web.service.SubDivService;

@Service
public class SubDivServiceImpl implements SubDivService{
	
	@Autowired
	SubDivisionRepo subDivRepo;

	@Override
	public List<SubDivision> subDivByDistrict(Integer distId) {
		List<SubDivision> subDivList= subDivRepo.findByDistId(distId);
		//System.out.println(subDivList);
		return subDivList;
	}
	
	 
	 
	 
	
	 	
}
