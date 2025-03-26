package com.lmd.web.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lmd.web.entity.EstbDistrict;
import com.lmd.web.repo.EstbDistrictRepository;
import com.lmd.web.service.DistrictService;

@Service
public class DistrictServiceImpl implements DistrictService {
	
	private final EstbDistrictRepository districtRepo;
	 
	public DistrictServiceImpl(EstbDistrictRepository districtRepo) {
		this.districtRepo = districtRepo;
	}

	@Override
	public List<EstbDistrict> getAllDistrictsList() {
		return districtRepo.findAll();
	}

}
