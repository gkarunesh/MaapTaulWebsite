package com.lmd.web.ctrl;

/*@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserCtrl {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	//create user service
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception {
		//System.out.println(user);
		user.setProfile("default.png");
		user.setRegisterDate(LocalDateTime.now());
		//encoding password with bcryptpasswordencoder;
		user.setPassword(this.bCryptPasswordEncoder.encode("secret"));
		Set<UserRole> roles=new HashSet<>();
		Role role=new Role();
		role.setRoleId(12L);
		role.setRolename("USER");
		
		UserRole userRole =new UserRole();
		userRole.setRole(role);
		userRole.setUser(user);
		
		roles.add(userRole);
		
		return this.userService.createUser(user, roles);
	}
	
	@GetMapping("/{username}")
	public User getUser(@PathVariable ("username") String username) {
		return userService.getUser(username);
	}
	
	/*@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable ("userId") String userId) {
		this.userService.deleteUser(userId);
	}*/
	  
	 
	/*@ExceptionHandler(UserFoundException.class)
	public UserFoundException exceptionHandler(UserFoundException ex){
		return ex;
	}
}*/
