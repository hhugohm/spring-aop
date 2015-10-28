package org.neos.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.neos.aop.domain.User;
import org.neos.aop.pointcut.PointcutDefinition;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;


@Configuration 
@Profile("dev") //los profiles que se necesitan visualizar
@Aspect
@Order(0) // si hubiera mas aspectos en otras clase se van numeran el oden de ejecucion
public class UserLoggingAspect extends PointcutDefinition {
	
	@Before(value = "org.neos.aop.pointcut.PointcutDefinition.dataAccessDaoLayerArgument() && " + "args(user,..)")
	public void beforeUserDaoMethodExecution(JoinPoint jp, User user) {
		System.out.println("######################################################");
		System.out.println("Before method: " + jp.getSignature().getName()+ ". Class: " + jp.getTarget().getClass().getSimpleName());
		
		System.out.println("Se va a guardar en bitacora el acceso BEFORE.......");
		
		
		System.out.println("Logging user access. USER: " +  user.toString() );
		System.out.println("######################################################");
	}
	
	@Before("org.neos.aop.pointcut.PointcutDefinition.dataAccessDaoLayerWintoutArgument()")
	public void beforeUserDaoMethodExecution(JoinPoint jp) {
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("Before method: " + jp.getSignature().getName()+ ". Class: " + jp.getTarget().getClass().getSimpleName());
		
		System.out.println("Se va a guardar en bitacora el acceso BEFORE.......");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
	}
	
	@After("org.neos.aop.pointcut.PointcutDefinition.dataAccessServiceLayerArgument()")
	public void afterUserServiceMethodExecution(JoinPoint jp) {
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println("After method: " + jp.getSignature().getName()+ ". Class: " + jp.getTarget().getClass().getSimpleName());
		
		System.out.println("Se va a guardar en bitacora el acceso AFTER.......");
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
	}
	@Around("org.neos.aop.pointcut.PointcutDefinition.dataAccessServiceLayerWithOutArgument() && @annotation(auditable)")
	//@Around("org.neos.aop.pointcut.PointcutDefinition.dataAccessServiceLayerWithOutArgument()")
	//public void aroundUserServiceMethodExecution(ProceedingJoinPoint jp)  throws Throwable {
	public void aroundUserServiceMethodExecution(ProceedingJoinPoint jp,Auditable auditable)  throws Throwable {
		System.out.println("||||||||||||||||||||ADVISE Around|||||||||||||||||||||||||||");
		System.out.println("metodo logAround() is running!");
		System.out.println("metodo interceptado : " + jp.getSignature().getName());
		//System.out.println("parametros de entrada : " + Arrays.toString(joinPoint.getArgs()));
		System.out.println("Type of Auditable: " +auditable.value()+ ".................");
		System.out.println("Ejecucion antes del procesamiento del metodo!");
		jp.proceed(); //continue on the intercepted method
		System.out.println("Ejecucion luego del procesamiento del metodo!");
		System.out.println("Type of Auditable: " +auditable.value()+ ".................");
	 
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||||");
	}
}
