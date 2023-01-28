/**
 * 
 */
package com.mjedli.testjanvier2023.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mjedli.testjanvier2023.model.User;
import com.mjedli.testjanvier2023.user.UserController;

/**
 * @author mjedli
 *
 */
@Aspect
@Component
public class UserServiceAspect {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	// findUserByEmail
	
	/**
	 * <p>
	 * AOP before method findUserByEmail
	 * </p>
	 */
	@Before(value = "execution(* com.mjedli.testjanvier2023.user.UserService.findUserByEmail(..)) and args(user)")
	public void beforeAdvicefindUserByEmail(JoinPoint joinPoint, User user) {
		
		log.info("-");
		
		log.info("Before method:" + joinPoint.getSignature());

		log.info("Finding user with email - " + user.getEmail());
		
	}

	/**
	 * <p>
	 * AOP after method findUserByEmail
	 * </p>
	 */
	@After(value = "execution(* com.mjedli.testjanvier2023.user.UserService.findUserByEmail(..)) and args(user)")
	public void afterAdvicefindUserByEmail(JoinPoint joinPoint, User user) {
		
		log.info("After method:" + joinPoint.getSignature());

		log.info("Finding user with email - " + user.getEmail());
		
	}
	
	/**
	 * <p>
	 * AOP @AfterReturning method findUserByEmail
	 * </p>
	 */
    @AfterReturning(pointcut = "execution(* com.mjedli.testjanvier2023.user.UserService.findUserByEmail(..))", returning = "result")
    public void logAfterfindUserByEmail(JoinPoint joinPoint, Object result) {
        if (result!=null) {         
            log.info("Method returned : " + joinPoint.getSignature().getName() + ", Result : " + result.getClass().getName()+" : "+result);
        }
    }
	
	/**
	 * <p>
	 * AOP around method findUserByEmail
	 * </p>
	 */
	@Around(value = "execution(* com.mjedli.testjanvier2023.user.UserService.findUserByEmail(..))")
    public Object executionTimefindUserByEmailt(ProceedingJoinPoint point) throws Throwable {
		
		long startTime = System.currentTimeMillis();
        Object object = point.proceed();
        long endtime = System.currentTimeMillis();
        
        log.info("Class Name: "+ point.getSignature().getDeclaringTypeName() +". Method Name: "+ point.getSignature().getName() + ". Time taken for Execution is : " + (endtime-startTime) +"ms");
        
        log.info("-");
        
        return object;
    }
	
	// insert
	
	/**
	 * <p>
	 * AOP before method insert
	 * </p>
	 */
	@Before(value = "execution(* com.mjedli.testjanvier2023.user.UserService.insert(..)) and args(user)")
	public void beforeAdviceinsert(JoinPoint joinPoint, User user) {
		
		log.info("-");
		
		log.info("Before method:" + joinPoint.getSignature());

		log.info("Creating user with email - " + user.getEmail() + " and id - " + user.getId());
		
	}

	/**
	 * <p>
	 * AOP after method insert
	 * </p>
	 */
	@After(value = "execution(* com.mjedli.testjanvier2023.user.UserService.insert(..)) and args(user)")
	public void afterAdviceinsert(JoinPoint joinPoint, User user) {
		
		log.info("After method:" + joinPoint.getSignature());

		log.info("Successfully created user with email - " + user.getEmail() + " and id - " + user.getId());
		
	}
	
	/**
	 * <p>
	 * AOP @AfterReturning method insert
	 * </p>
	 */
    @AfterReturning(pointcut = "execution(* com.mjedli.testjanvier2023.user.UserService.insert(..))", returning = "result")
    public void logAfterinsert(JoinPoint joinPoint, Object result) {
        if (result!=null) {         
            log.info("Method returned : " + joinPoint.getSignature().getName() + ", Result : " + result.getClass().getName()+" : "+result);
        }
    }
	
	/**
	 * <p>
	 * AOP around method insert
	 * </p>
	 */
	@Around(value = "execution(* com.mjedli.testjanvier2023.user.UserService.insert(..))")
    public Object executionTimeinsert(ProceedingJoinPoint point) throws Throwable {
		
		long startTime = System.currentTimeMillis();
        Object object = point.proceed();
        long endtime = System.currentTimeMillis();
        
        log.info("Class Name: "+ point.getSignature().getDeclaringTypeName() +". Method Name: "+ point.getSignature().getName() + ". Time taken for Execution is : " + (endtime-startTime) +"ms");
        
        log.info("-");
        
        return object;
    }

	// findAllUsers
	
	/**
	 * <p>
	 * AOP before method findAllUsers
	 * </p>
	 */
	@Before(value = "execution(* com.mjedli.testjanvier2023.user.UserService.findAllUsers(..))")
	public void beforeAdvicefindAllUsers(JoinPoint joinPoint) {
		
		log.info("-");
		
		log.info("Before method:" + joinPoint.getSignature());
		
	}

	/**
	 * <p>
	 * AOP after method findAllUsers
	 * </p>
	 */
	@After(value = "execution(* com.mjedli.testjanvier2023.user.UserService.findAllUsers(..))")
	public void afterAdvicefindAllUsers(JoinPoint joinPoint) {
		
		log.info("After method:" + joinPoint.getSignature());		
	}
	
	/**
	 * <p>
	 * AOP @AfterReturning method findAllUsers
	 * </p>
	 */
    @AfterReturning(pointcut = "execution(* com.mjedli.testjanvier2023.user.UserService.findAllUsers(..))", returning = "result")
    public void logAfterfindAllUsers(JoinPoint joinPoint, Object result) {
        if (result!=null) {         
            log.info("Method returned : " + joinPoint.getSignature().getName() + ", Result : " + result.getClass().getName()+" : "+result);
        }
    }
	
	/**
	 * <p>
	 * AOP around method findAllUsers
	 * </p>
	 */
	@Around(value = "execution(* com.mjedli.testjanvier2023.user.UserService.findAllUsers(..))")
    public Object executionTimefindAllUsers(ProceedingJoinPoint point) throws Throwable {
		
		long startTime = System.currentTimeMillis();
        Object object = point.proceed();
        long endtime = System.currentTimeMillis();
        
        log.info("Class Name: "+ point.getSignature().getDeclaringTypeName() +". Method Name: "+ point.getSignature().getName() + ". Time taken for Execution is : " + (endtime-startTime) +"ms");
        
        log.info("-");
        
        return object;
    }
	
	// findUserById
	
	/**
	 * <p>
	 * AOP before method findUserById
	 * </p>
	 */
	@Before(value = "execution(* com.mjedli.testjanvier2023.user.UserService.findUserById(..)) and args(id)")
	public void beforeAdvicefindUserById(JoinPoint joinPoint, Long id) {
		
		log.info("-");
		
		log.info("Before method:" + joinPoint.getSignature());

		log.info("Finding user with id - " + id);
		
	}

	/**
	 * <p>
	 * AOP after method findUserById
	 * </p>
	 */
	@After(value = "execution(* com.mjedli.testjanvier2023.user.UserService.findUserById(..)) and args(id)")
	public void afterAdvicefindUserById(JoinPoint joinPoint, Long id) {
		
		log.info("After method:" + joinPoint.getSignature());

		log.info("Successfully find user with id - " + id);
		
	}
	
	/**
	 * <p>
	 * AOP @AfterReturning method findUserById
	 * </p>
	 */
    @AfterReturning(pointcut = "execution(* com.mjedli.testjanvier2023.user.UserService.findUserById(..))", returning = "result")
    public void logAfterfindUserById(JoinPoint joinPoint, Object result) {
        if (result!=null) {         
            log.info("Method returned : " + joinPoint.getSignature().getName() + ", Result : " + result.getClass().getName()+" : "+result);
        }
    }
	
	/**
	 * <p>
	 * AOP around method findUserById
	 * </p>
	 */
	@Around(value = "execution(* com.mjedli.testjanvier2023.user.UserService.findUserById(..))")
    public Object executionTimefindUserById(ProceedingJoinPoint point) throws Throwable {
		
		long startTime = System.currentTimeMillis();
        Object object = point.proceed();
        long endtime = System.currentTimeMillis();
        
        log.info("Class Name: "+ point.getSignature().getDeclaringTypeName() +". Method Name: "+ point.getSignature().getName() + ". Time taken for Execution is : " + (endtime-startTime) +"ms");
        
        log.info("-");
        
        return object;
    }
	
}
