package com.lmd.web.restServices;

//@RestController
//@RequestMapping("/authenticate")
public class JwtTokenValidator {

	
	//@Autowired
	//JwtUtil jwtUtil;
	
	//@Autowired
	//serviceProvidersList sProviderList;
	
	//@PostMapping("/validateToken")
	/*MyResponse<?> validateToken(@RequestBody JwtResponse res){
		//System.err.print(res);
		boolean isValid=false;
		try {
		  //isValid=jwtUtil.isTokenExpired(res.getToken())?false:true;
		  //System.err.println(isValid);
		  return MyResponse.builder().statusCode(Http.OK).data(isValid).build();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MyResponse.builder().statusCode(Http.EXCEPTION).data(e.getCause()).build();
		}		
	}*/
	
	//@GetMapping("/getServiceProvidersList/{type}/{district}/{status}")
	/*public MyResponse<?> getDealerByDistrict(@PathVariable String type, @PathVariable Integer district, @PathVariable String status) {
		return sProviderList.getServiceProvidersList(type, district, status);
	}*/
	
	/*@GetMapping("/getServiceProvidersBySubdivision/{type}/{subDivId}/{status}")
		public MyResponse<?> dealersBySubdivision(@PathVariable String type, @PathVariable Integer subDivId, @PathVariable String status) {
		return sProviderList.getDealerList(type, subDivId, status);
	}*/
	
}
