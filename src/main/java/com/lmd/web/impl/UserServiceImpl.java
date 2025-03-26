package com.lmd.web.impl;

//@Service
/*public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private RoleRepo roleRepo;
	
	//@Autowired
	//private UserService userService;

	//create user
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		User local=userRepo.findByUsername(user.getUsername());
			if(local !=null) {
				//System.err.println("User is already present");
				throw new UserFoundException();
			}
			else {
				local=userRepo.save(user);
				for(UserRole ur: userRoles) {
					ur.setUser(local);
					//System.out.println("SetUserRole: "+ur);
					roleRepo.save(ur.getRole());
				}
				///user.setUserRoles(userRoles);
				//System.out.println(user.getUserRoles());
				local.setUserRoles(userRoles);
				//System.err.println("LocalUserService" +local);
				local=userRepo.save(local);
			}
		return local;
	}

	@Override
	public User getUser(String username) {
		return userRepo.findByUsername(username);
	}
	
	/** @Override
	public void deleteUser(String username) {
		this.userRepo.findByUsername(username);
		
	} **/

	/*@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}

	@Override
	public List<User> getAllUsers(boolean enabled) {
		return userRepo.findByEnabled(enabled);
	}

	@Override
	public Optional<User> findUser(Long id) {
		return userRepo.findById(id);
	}

	@Override
	public User addUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public Optional<User> findByMobile(String mobile) {
		return userRepo.findByMobile(mobile);
	}

	@Override
	public int updatePassword(User user) {
		return userRepo.updatePassword(user.getPassword(), user.getId());
	}

	*/

	
	
	//@Override
	//public User getUser1(String mobile) {
		//return userRepo.findByMobile(mobile);
	//}
	
	
///}
