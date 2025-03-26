package com.lmd.web.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmd.web.entity.RatingsModel;
//import com.lmd.web.entity.User;
import com.lmd.web.repo.RatingRepository;
import com.lmd.web.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService {
	
	@Autowired
	private RatingRepository ratingRepo;
	
	@Override
	public List<RatingsModel> findByStatus(char status) throws Exception {
		List<RatingsModel> ratings = ratingRepo.findByStatus(status);
		return ratings;
	}

	@Override
	public RatingsModel ratingData(RatingsModel ratingModel) throws Exception {
		RatingsModel ratingData = ratingRepo.save(ratingModel);
		return ratingData;
	}

	@Override
	public int updateStatus(Integer id, char status) throws Exception{
		//return ratingRepo.update(id, status);
		return 0;
	}
	
}
