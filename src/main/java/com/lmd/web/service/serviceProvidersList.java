package com.lmd.web.service;

import com.lmd.web.utilities.MyResponse;
public interface serviceProvidersList{
	
	public MyResponse<?> getServiceProvidersList(String type, Integer district, String status);

	public MyResponse<?> getDealerList(String type, Integer subDivId, String status);
}
	
