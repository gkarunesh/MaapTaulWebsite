package com.lmd.web;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableTransactionManagement
public class MaapTaulWebApplication extends SpringBootServletInitializer implements CommandLineRunner{

	//implements CommandLineRunner
	//@Autowired
	//private UserService userService;
	
	//@Autowired
	//private BCryptPasswordEncoder bCryptPasswordEncoder;	
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder app){
		return app.sources(MaapTaulWebApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MaapTaulWebApplication.class, args);
		//System.err.println("Running..");
		
		/*@Override
		public void run(String... args) throws Exception {
			
			  User user=new User(); 
			  user.setFirstname("Karunesh");
			  user.setLastname("Gaurav"); 
			  user.setUsername("admin");
			  user.setPassword(this.bCryptPasswordEncoder.encode("9211")); 
			  user.setEmail("test@gmail.com");
			  user.setMobile("7677444661");
			  user.setGender("Male");
			  user.setProfile("default.png");
			  user.setRegisterDate(LocalDateTime.now());
			  
			  Role role1=new Role(); 
			  role1.setRoleId(11l); 
			  role1.setRolename("ADMIN");
			  
			  Set<UserRole> userRoleSet=new HashSet<>(); 
			  UserRole userRole = new
			  UserRole(); 
			  userRole.setRole(role1); 
			  userRole.setUser(user);
			  userRoleSet.add(userRole); 
			  //System.err.println(user);
			  
			  User adminUser=userService.createUser(user, userRoleSet);
			  System.err.println("adminUser : "+adminUser);
			 
		}*/
	}	

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.err.println("******************************************************************");                                                                                               
		System.err.println("                    LMD WEB RUNNING                               ");
		System.err.println("******************************************************************");
	}

}
