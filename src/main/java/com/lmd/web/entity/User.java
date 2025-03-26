package com.lmd.web.entity;

/**@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = { "userRoles"})
@Table(name = "user_registration", uniqueConstraints = {@UniqueConstraint(columnNames = {"mobile"}), 
		@UniqueConstraint(columnNames = {"email"})})
public class User implements UserDetails{
	
	
	 * 
	 */
/**private static final long serialVersionUID = 7112349275837147635L;
	
	 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	private String username;
	
	@Column(nullable = true)
	private String password; 
	
	private String fullname;
	
	private String mobile;
	
	private String email;
	
	
	private boolean enabled=true;
	
	private String profile;
	
	private String gender;
	
	private LocalDateTime registerDate;
	
	
	@ToString.Exclude
	@JsonIgnore
	@OneToMany(mappedBy = "user", cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	private Set<UserRole> userRoles=new HashSet<>(); 
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<Authority> set = new HashSet<>();
		//System.err.println(userRoles);
		userRoles.forEach(userRole ->{
			set.add(new Authority(userRole.getRole().getRolename()));
		});
		return set;	
	}



	@Override
	public String getPassword() {
		return this.password;
	}



	@Override
	public boolean isAccountNonExpired() {
		return true;
	}



	@Override
	public boolean isAccountNonLocked() {
		return true;
	}



	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	
	

}* 
	 */
