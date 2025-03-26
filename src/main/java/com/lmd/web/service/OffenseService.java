package com.lmd.web.service;

import org.springframework.data.domain.Page;

import com.lmd.web.entity.Offenses;

	public interface OffenseService{
		
		Page<Offenses> allOffense(int page);	
	}
	
