package com.lmd.web.ctrl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lmd.web.exceptions.UserNotFoundException;

@Controller
@RequestMapping("/user")
public class Home {

	
	//@GetMapping("/uploadDoc")
	//public String AttachmentPage() {
		//return "AttachmentEntry";
	//}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<?> exceptionHandler(UserNotFoundException ex){return null;}
	
}
