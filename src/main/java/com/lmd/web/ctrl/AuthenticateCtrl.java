package com.lmd.web.ctrl;

/*@RestController
@CrossOrigin("*")
public class AuthenticateCtrl {
	
	//@Autowired
	//private AuthenticationManager authenticationManager;
	
	//@Autowired
	//private UserDetailsServiceImpl userDetailsService;
	
	
	//@Autowired
	//private JwtUtil  jwtUtils;
	
	//@Autowired
	//BCryptPasswordEncoder bcrept;
	
	@Autowired
	UserService userSer;
	
	String username = null;
	
	@PostMapping("/generate-token")
	public MyResponse<?> generateToken(@RequestBody JwtRequest jwtRequest , @ModelAttribute("users") User user ,HttpSession session) throws Exception{
		//System.out.println(jwtRequest);
		UserDetails userDetails =null;		 
		try {
			Authentication auth=authenticationManager.authenticate(authenticate(jwtRequest.getUsername(),jwtRequest.getPassword()));
			//System.out.println(auth);
			
			if(auth.isAuthenticated()) {
				userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
				String token=this.jwtUtils.generateToken(userDetails);
				username = userDetails.getUsername();
				//session.setAttribute("username", userDetails);
				//System.out.println(session.getAttribute(getUser()));
				return MyResponse.builder().statusCode(Http.OK).data(userDetails.getAuthorities()).remarks(token).status(userDetails.getUsername()).build();
			}
			else {
				return MyResponse.builder().statusCode(Http.ACCEPTED).data("Not authenticated..!").build();
			}
		}catch (Exception e) {
			e.printStackTrace();
			return MyResponse.builder().statusCode(Http.EXCEPTION).remarks(e.getMessage()).build();
		}
	}
	
	private Authentication authenticate(String username, String password) {
		Authentication auth=null;
		try {
			//System.out.println("Username/password : "+username+" "+password);
			//System.out.println("Password : "+bcrept.encode(password));
			auth=new UsernamePasswordAuthenticationToken(username,password);
		}catch(DisabledException e) {
			e.printStackTrace();
		}catch(BadCredentialsException e) {
			e.printStackTrace();
		}
		return auth;
	}
	
	
	@RequestMapping("/getuser")
	public String getUser() {
		//System.err.println(username);
		return username;
	}
	
	@GetMapping("/current-user")
	public User getCurrentUser(Principal principal) {
		return ((User)this.userDetailsService.loadUserByUsername(principal.getName()));
	}
	
	@PostMapping("/sendOTP")
	public MyResponse<?> sendOtp(@RequestBody String mobile) {
		//4 Digit Random Number
		User user=userSer.getUser(mobile);
		if(user==null) {
			return MyResponse.builder().statusCode(Http.EXCEPTION).data("Mobile No. Not Exist").build();
		}else {
		int randomNo=(int) (Math.random()*9000)+1000;
		String otp=String.valueOf(randomNo);
		user.setPassword(bcrept.encode(otp));
		userSer.saveUser(user);
		//System.out.println(otp);
		return MyResponse.builder().statusCode(Http.OK).data(otp).remarks(user.getUsername()).build();	
		}
	}
	
	
}*/