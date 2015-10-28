package org.neos.aop.test;

import org.neos.aop.dao.UserDao;
import org.neos.aop.domain.User;
import org.neos.aop.service.IBusinessUser;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class AopTestXml {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
		ctx.getEnvironment().setActiveProfiles("dev"); //para activar los niveles de los aspectos (debe coincidir con el XML)
		
		ctx.refresh();
		UserDao userDao = (UserDao) ctx.getBean("userDao");
		User user = new User("hugo","hidalgo","hhugohm@iclloud.com");
		
		
		userDao.getUserByName(user);
		//userDao.updateUser(user);
		//userDao.saveUser(user);
		//userDao.deleteUser(user);
		//userDao.getAllUsers();
		System.out.println("-----------------------------------------------------------------------------");
		
		
		//vamos arealizar el llamado a la capa de servicio
		IBusinessUser businessUser =  (IBusinessUser) ctx.getBean("userService");
		//businessUser.processNewUser(user);
		System.out.println("-----------------------------------------------------------------------------");
		businessUser.processDeleteAllUsers();
		
		ctx.close();
		
	}

}
