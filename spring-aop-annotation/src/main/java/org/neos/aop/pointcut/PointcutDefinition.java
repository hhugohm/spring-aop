package org.neos.aop.pointcut;

import org.aspectj.lang.annotation.Pointcut;


public abstract class PointcutDefinition {
	
	@Pointcut("within(org.neos.aop.dao..*)")
	public void dataAccessDaoLayerArgument() {
	}
	
	@Pointcut("execution(public * org.neos.aop.dao..*.get*())")
	public void dataAccessDaoLayerWintoutArgument() {
	}
	
	@Pointcut("execution(public * org.neos.aop.service..*.processNewUser(..))")
	public void dataAccessServiceLayerArgument() {
	}
	
	@Pointcut("execution(public * org.neos.aop.service..*.processDeleteAllUsers())")
	public void dataAccessServiceLayerWithOutArgument() {
	}
	
	
	
}
