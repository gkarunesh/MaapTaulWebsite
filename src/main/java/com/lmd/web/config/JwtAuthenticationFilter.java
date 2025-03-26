package com.lmd.web.config;

/*@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private JwtUtil jwtutil;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		final String requestTokenHeader = request.getHeader("Authorization");
		//System.out.println();
		String username=null;
		String jwtToken=null;
		
		if(requestTokenHeader !=null && requestTokenHeader.startsWith("Bearer")) {
			jwtToken = requestTokenHeader.substring(7);
			try {
				username=jwtutil.extractUsername(jwtToken);
			}catch(ExpiredJwtException e) {
				e.printStackTrace();
				System.out.println("Jwt Token has expired");
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("Error");
			}
			
		}
		else {
			//System.out.println("Invalid Token, not start with bearer string");
		}
		//validate token
		if(username !=null && SecurityContextHolder.getContext().getAuthentication()==null) {
			final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
			if(this.jwtutil.validateToken(jwtToken, userDetails)) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthentication=new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthentication);
			}
		}
		else {
			//System.out.println("Token is not valid");
		}
		filterChain.doFilter(request, response);
	}
	
}*/
