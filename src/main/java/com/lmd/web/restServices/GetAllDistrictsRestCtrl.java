package com.lmd.web.restServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lmd.web.entity.EstbDistrict;
import com.lmd.web.entity.SubDivision;
import com.lmd.web.service.DistrictService;
import com.lmd.web.service.SubDivService;
import com.lmd.web.utilities.Http;
import com.lmd.web.utilities.MyResponse;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/dist-list")
@Slf4j
public class GetAllDistrictsRestCtrl {
	
	@Autowired
	DistrictService districtService;
	
	@Autowired
	SubDivService subDivServ;
	
	@GetMapping("/districts")
	public MyResponse<?> getDistricts() throws Exception {
		try {
			List<EstbDistrict> data = districtService.getAllDistrictsList();
			if(!data.isEmpty()) {
				return MyResponse.builder().statusCode(Http.OK).size(data.size()).data(data).build();
			} else {
				return MyResponse.builder().statusCode(Http.EXCEPTION).size(0).data(data).build();
			}
			//return MyResponse.builder().statusCode(Http.OK).size(data.size()).data(data).build();
			
		} catch (Exception e) {
			e.printStackTrace();
			return MyResponse.builder().statusCode(Http.EXCEPTION).data("Districts not Found !").remarks(e.getMessage()).build();
		}
	}
	
		
	@GetMapping("/subdivision/{distrisctId}")
		public MyResponse<?> getSubdivision(@PathVariable Integer distrisctId) throws Exception {
			try {
					List<SubDivision> data = subDivServ.subDivByDistrict(distrisctId);
					System.out.println(data);
					return MyResponse.builder().statusCode(Http.OK).data(data).build();
				}
				catch(Exception e) {
					e.printStackTrace();
						return MyResponse.builder().statusCode(Http.EXCEPTION).data("Subdivision not Found !").remarks(e.getMessage()).build();
				}	
			}
				
	}
	

