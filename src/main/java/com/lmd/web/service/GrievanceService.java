package com.lmd.web.service;

import org.springframework.data.domain.Page;

import com.lmd.web.entity.GrievanceModel;

public interface GrievanceService {
		
	Page<GrievanceModel> allGrievance(int page);	
		
	//GrievanceModel grievanceData(GrievanceModel grievanceData)  throws Exception;
		
	//public List<GrivanceCounterDto> complaintCounter() throws Exception;
		
	//public Optional<GrievanceModel> findByAckno(String ackno);
		
}
	
