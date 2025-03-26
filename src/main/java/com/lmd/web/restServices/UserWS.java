package com.lmd.web.restServices;

//@RestController
//@RequestMapping("/register")
/*public class UserWS {
	
	//@Autowired
	//UserService uService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@PostMapping("/user-register")
	public MyResponse<?> userRegister(@RequestBody User user) throws Exception {
		try {
			//System.out.println(user);
			user.setProfile("default.png");
			user.setRegisterDate(LocalDateTime.now());
			//encoding password with bcryptpasswordencoder;
			user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
			Set<UserRole> roles=new HashSet<>();
			Role role=new Role();
			role.setRoleId(12L);
			role.setRolename("USER");
			
			UserRole userRole =new UserRole();
			userRole.setRole(role);
			userRole.setUser(user);
			
			roles.add(userRole);
			
			User data = uService.createUser(user, roles);
			return MyResponse.builder().statusCode(Http.OK).data(data).remarks("User Successfully saved").build();
		}
		catch(Exception e) {
			e.printStackTrace();
				return MyResponse.builder().statusCode(Http.EXCEPTION).data(e.getMessage()).remarks("Oops, Something Wrong").build();
		}		
	}
	
	
	@GetMapping("/all-active-user")
	public MyResponse<?> GetActiveUsers() throws Exception {
		try {
			boolean enabled = true;
			List<User> data = uService.getAllUsers(enabled);
			//System.out.println(data);
			return MyResponse.builder().statusCode(Http.OK).size(data.size()).data(data).build();
		}
		catch(Exception e) {
			return MyResponse.builder().statusCode(Http.EXCEPTION).data(e.getMessage()).build();
		}
	}
	
	@GetMapping("/{username}")
	public User getUser(@PathVariable ("username") String username) {
		return uService.getUser(username);
	}
	
	/*@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable ("userId") String userId) {
		this.uService.deleteUser(userId);
	}*/
	
	/*@PostMapping("/change-user-status/{userId}")
	public MyResponse<?> changeUserStatus(@PathVariable Long userId) throws Exception {
		//System.out.println(userId);
		try {
			User user=null;
				Optional<User> usrData = uService.findUser(userId);
				//System.out.println(usrData);
				if(usrData.isPresent()) {
					user=usrData.get();
					user.setEnabled(false);
					user=uService.addUser(user);
					return MyResponse.builder().statusCode(Http.OK).data(user).remarks("User Deactivated").build();
				}else {
					return MyResponse.builder().statusCode(Http.ACCEPTED).data(null).remarks("User not Found !").build();
				}
				
		}
		catch(Exception e) {
			e.printStackTrace();
				return MyResponse.builder().statusCode(Http.EXCEPTION).data("Error found").remarks(e.getMessage()).build();
		}		
	}
	
	@GetMapping("/getOTPForUser/{mobile}")
	public MyResponse<?> GetOtpForUsers(@PathVariable String mobile) throws Exception {
		try {
			Optional<User> usrData = uService.findByMobile(mobile);
			if(usrData.isPresent()) {
				//System.out.println(usrData);
				return MyResponse.builder().statusCode(Http.OK).data(usrData).build();
			}
			else{
				return MyResponse.builder().statusCode(Http.ACCEPTED).remarks("Incorrect Mobile No.").build();
			}
		}
		catch(Exception e) {
			return MyResponse.builder().statusCode(Http.EXCEPTION).data(e.getMessage()).build();
		}
	}
	
	
	@PostMapping("/updatePassword")
	public MyResponse<?> UpdatePasswords(@RequestBody User user) throws Exception {
		//System.out.println(user);
		try {
				user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
				uService.updatePassword(user);
				return MyResponse.builder().statusCode(Http.OK).data(user).remarks("Password Changed Successfully").build();
			}
		catch(Exception e) {
			return MyResponse.builder().statusCode(Http.EXCEPTION).data(e.getMessage()).build();
		}
	}
		 
	@ExceptionHandler(UserFoundException.class)
	public UserFoundException exceptionHandler(UserFoundException ex){
		return ex;
	}
	
}*/
