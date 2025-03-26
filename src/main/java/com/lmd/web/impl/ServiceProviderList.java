package com.lmd.web.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lmd.web.interfaces.UrlConstant;
import com.lmd.web.service.serviceProvidersList;
import com.lmd.web.utilities.MyResponse;

@Service
public class ServiceProviderList implements serviceProvidersList{
	
	
	@Autowired
	RestTemplate rTemplate;


	@Override
	public MyResponse<?> getServiceProvidersList(String type, Integer district, String status) {
		String url = UrlConstant.AppUrl+"checkAuthority/servicesByDistrict/"+type+"/"+district;
		MyResponse<?> getData = rTemplate.getForObject(url, MyResponse.class);
		return getData;
	}


	@Override
	public MyResponse<?> getDealerList(String type, Integer subDivId, String status) {
		String url = UrlConstant.AppUrl+"/checkAuthority/servicesBySubDiv/"+type+"/"+subDivId;
		MyResponse<?> getDealers = rTemplate.getForObject(url, MyResponse.class);
		return getDealers;
	}
}
