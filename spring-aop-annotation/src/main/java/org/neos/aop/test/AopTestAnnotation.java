package org.neos.aop.test;

import org.neos.aop.config.AspectJAutoProxyConfig;
import org.neos.aop.dao.UserDao;
import org.neos.aop.domain.User;
import org.neos.aop.service.IBusinessUser;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopTestAnnotation {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		 
		ctx.register(AspectJAutoProxyConfig.class);
		ctx.getEnvironment().setActiveProfiles("dev"); //para activar los niveles de los aspectos
		ctx.scan("org.neos");
		ctx.refresh();
	
		UserDao userDao =   ctx.getBean(UserDao.class);
		
		User user = new User("hugo","hidalgo","hhugohm@iclloud.com");
		
		//vamos a realizar el llamado a la capa DAO
		userDao.getUserByName(user);
		//userDao.updateUser(user);
		//userDao.saveUser(user);
		//userDao.deleteUser(user);
		//userDao.getAllUsers();
		System.out.println("-----------------------------------------------------------------------------");
		
		//vamos arealizar el llamado a la capa de servicio
		IBusinessUser businessUser =  ctx.getBean(IBusinessUser.class);
		//businessUser.processNewUser(user);
		System.out.println("-----------------------------------------------------------------------------");
		businessUser.processDeleteAllUsers();
		
		ctx.close();
	}

}
