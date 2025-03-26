package com.lmd.web.service;

import java.util.List;

import com.lmd.web.entity.RatingsModel;

public interface RatingService {
		
	List<RatingsModel> findByStatus(char status) throws Exception;
		
	RatingsModel ratingData(RatingsModel RatingsModel)  throws Exception;

	int updateStatus(Integer id, char status) throws Exception;
}	