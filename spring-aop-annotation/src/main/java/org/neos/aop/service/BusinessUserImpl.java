package org.neos.aop.service;

import org.neos.aop.aspects.Auditable;
import org.neos.aop.aspects.Auditable.AuditDestination;
import org.neos.aop.dao.UserDao;
import org.neos.aop.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class BusinessUserImpl implements IBusinessUser{
	@Autowired
	private UserDao userDao;

	public void processNewUser(User user) {
		
		System.out.println("Se realiza el Bussiness de un nuevo USER...");
		userDao.saveUser(user);
		userDao.getUserByName(user);
		
	}
	@Auditable(AuditDestination.DATABASE)
	public void processDeleteAllUsers() {
		System.out.println("Se realiza el Business de borra todos los USER...");
		
	}

}
