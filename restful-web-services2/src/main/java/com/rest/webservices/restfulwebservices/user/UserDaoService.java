package com.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDaoService {

	private static List<User> users = new ArrayList<>();
	
	private static int usersCount = 4;

	static {
		users.add(new User(1001, "Subhasiw", new Date()));
		users.add(new User(1002, "Avilipsha", new Date()));
		users.add(new User(1003, "Atiksh", new Date()));
		users.add(new User(1004, "Nata", new Date()));
	}

	
	public List<User> findAll(){
		
		return users;
		
	}
	
	public User save(User user) {
		
		if (user.getId() == null) {
			
			user.setId((usersCount++));
			
		}
		
		users.add(user);
		return user;
	}
	
	public User findOne(int id) {
		
		for (User user : users) {
			
			if (user.getId() == id) {
				return user;
			}
		}
		
		return null;
		
	}
	
	
}
