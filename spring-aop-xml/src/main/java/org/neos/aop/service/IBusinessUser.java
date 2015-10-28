package org.neos.aop.service;

import org.neos.aop.domain.User;

public interface IBusinessUser {
	
	public void processNewUser(User user);
	public void processDeleteAllUsers();

}
