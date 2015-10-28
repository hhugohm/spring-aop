package org.neos.aop.config;

import org.neos.aop.dao.UserDao;
import org.neos.aop.dao.UserDaoImpl;
import org.neos.aop.service.BusinessUserImpl;
import org.neos.aop.service.IBusinessUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")  //contiene el profile que sera mandatorio
@EnableAspectJAutoProxy
public class AspectJAutoProxyConfig {
	
	@Bean
	public UserDao userDao(){
		
		return new UserDaoImpl();
	}
	@Bean
	public IBusinessUser userService(){
		
		return new BusinessUserImpl();
	}
	
}
