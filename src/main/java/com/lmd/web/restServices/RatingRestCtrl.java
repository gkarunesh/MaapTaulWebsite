package com.lmd.web.restServices;

import java.net.InetAddress;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lmd.web.entity.RatingsModel;
//import com.lmd.web.entity.User;
import com.lmd.web.enums.Store;
import com.lmd.web.service.MessagingService;
import com.lmd.web.service.RatingService;
import com.lmd.web.utilities.Http;
import com.lmd.web.utilities.MessagingModel;
import com.lmd.web.utilities.MyResponse;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/rating")
@Slf4j
public class RatingRestCtrl {
	
	
	@Autowired
	RatingService ratingService;
	
	@Autowired
	MessagingService mSer;
	
	/***************Grievance Count API********************/
	/*@GetMapping("/view-rating") 
	  public MyResponse<?> viewRating(){
		char status = 'V'; 
		try {
			 List<RatingsModel> data = ratingService.findByStatus(status);
			 return MyResponse.builder().statusCode(Http.OK).data(data).build();
		}catch(Exception e){
			e.printStackTrace();
			return MyResponse.builder().statusCode(Http.EXCEPTION).size(0).data(null).remarks(e.getMessage()).build();
		}		
		  		 
	}*/
	@GetMapping("/view-rating")
	public MyResponse<?> viewRating() {
	    char status = 'V'; 
	    try {
	        List<RatingsModel> data = ratingService.findByStatus(status);
	        return MyResponse.builder()
	                         .statusCode(Http.OK)
	                         .data(data)
	                         .build();
	    } catch (Exception e) {
	        e.printStackTrace(); 
	        return MyResponse.builder()
	                         .statusCode(Http.EXCEPTION)
	                         .size(0)
	                         .data("Something went wrong")
	                         .remarks("Error: " + e.getMessage())
	                         .build();
	    }
	}
	
	@GetMapping("/ratingsForVerify") 
	  public MyResponse<?> verifyRating(){
		char status = 'N'; 
		try {
			List<RatingsModel> data = ratingService.findByStatus(status);
			 //System.out.println(data);
			 return MyResponse.builder().statusCode(Http.OK).data(data).build();
		}catch(Exception e){
			e.printStackTrace();
			return MyResponse.builder().statusCode(Http.EXCEPTION).size(0).data(null).remarks(e.getMessage()).build();
		}		
		  		 
	}
	
	/***************Submit rating********************/
	@PostMapping(value = "/submitRating")
	public MyResponse<?> saveRating(@RequestBody RatingsModel ratingsModel) {
		try {
			if (ratingsModel != null) {
				//Get Local IP Addredss
				InetAddress localhost = InetAddress.getLocalHost();
		        String RemoteAddress = localhost.getHostAddress().trim();
		        ratingsModel.setIpAddress(RemoteAddress);
		        ratingsModel.setDateTime(LocalDateTime.now());
		        ratingsModel.setStatus('N');
				//System.out.println("DATA : " +ratingsModel);
				ratingsModel=ratingService.ratingData(ratingsModel);
				if(ratingsModel!=null) {
					try {
						mSer.sendText(MessagingModel.builder()
								.host(Store.requestUrlSms.val())
								//.userName(Store.userName.val())
								.senderId(Store.senderIdSms.val())
								.serviceType(Store.serviceTypeSms.val())
								.password(Store.passSms.val())
								.mobileNo(ratingsModel.getMobile())
								.content(Store.rating_feedBack.val())
								.build());
//						mSer.dbtText(
//								Params.builder().arg1(grievanceData.getMobile())
//										.arg2(String.valueOf(KeyEnum.CER_APP_SUB.getTemplateId())).arg3(KeyEnum.CER_APP_SUB
//												.getMessage().replace("#", vendor.getVendorId()).replace("@", staffName))
//										.build());
					}catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
						log.error(e.getMessage());
						return MyResponse.builder().data(ratingsModel).statusCode(Http.ACCEPTED)
								.status("Rating submit successfully").build();
					}
				
				}
				return MyResponse.builder().data(ratingsModel).statusCode(Http.OK)
						.status("Rating submit successfully.").build();
			} else {
				return MyResponse.builder().data("data not saved !").statusCode(Http.EXCEPTION).status(Http.FAILURE)
						.build();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return MyResponse.builder().data(e.getMessage()).statusCode(Http.EXCEPTION).status(Http.FAILURE).build();
		}
	}
	
	/********************Change Rating Status**********************/
	@PostMapping("/change-rating-status/{id}/{status}")
	public MyResponse<?> changeRatingStatus(@PathVariable Integer id, @PathVariable char status) throws Exception {
		//System.out.println(userId);
		try {
				int data=ratingService.updateStatus(id, status);
				return MyResponse.builder().statusCode(Http.OK).data(data).remarks("Updated Successfully").build();
			}
		catch(Exception e) {
				e.printStackTrace();
				return MyResponse.builder().statusCode(Http.EXCEPTION).data("Error found").remarks(e.getMessage()).build();
		}		
	}
}
