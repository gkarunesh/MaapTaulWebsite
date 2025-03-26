package com.lmd.web.config;

/*@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfig{
	
	@Autowired
	UserDetailsServiceImpl userDetailServiceImpl;
	
	@Autowired
	JwtAuthenticationEntryPoint unauthorizedHandler;
	
	@Autowired
	JwtAuthenticationFilter jwtAuthenticationFilter;
	
	@Bean
	public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();

	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		
	}
	
	/*@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		
		http
         .authorizeRequests()
             .anyRequest().permitAll()  // Allows all requests
             .and()
         .csrf().disable();  // Disable CSRF for APIs
		 DefaultSecurityFilterChain build= http.build();
		 return build;*/
		
		/*http.
		csrf() 
		.disable() 
		.cors() 
		.disable() 
		.authorizeRequests() 
		.antMatchers("/**","/generate-token","/user/**", "/authenticate/**", "/attachment/**","/register/**","/all/**", "/noc/**", "/rtps/**","/offense/**").permitAll()
		.antMatchers("/assets/**", "/theme/**", "/images/**", "/angularjsctrl/**", "/rating/**", "/grievance/**", "/api-test/**").permitAll()
		.antMatchers("/","/home", "/api/**").permitAll()
		//.antMatchers(HttpMethod.OPTIONS, "/**").permitAll() 
		
		.anyRequest().authenticated()
		.and() .exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	  
	  http.addFilterBefore(jwtAuthenticationFilter,UsernamePasswordAuthenticationFilter.class);
	  http.authenticationProvider(daoAuthenticationProvider());
	  DefaultSecurityFilterChain build= http.build();
	  return build;*/
		
	//}
	 
	
	/*@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		provider.setUserDetailsService(this.userDetailServiceImpl);
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}*/
	
	
//}
