package org.neos.aop.dao;

import java.util.List;

import org.neos.aop.domain.User;

public interface UserDao {
	
	public User getUserByName(User user);
	
	public List<User> getAllUsers();
	
	public void updateUser(User user);
	
	public void saveUser(User user);
	
	public void deleteUser(User user);
	

}
