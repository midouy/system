package org.system.web.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by wangyanming on 2016/4/28.
 */
@Component
@Aspect
public class TestAspect{

	@Pointcut("@annotation(org.system.web.annotation.aspect.SystemControllerLog)")
	private void ControllerCutMethod() {
	}

	@Pointcut("@annotation(org.system.web.annotation.aspect.SystemServiceLog)")
	private void ServiceCutMethod() {
	}

	//声明前置通知
	@Before("ControllerCutMethod()")
	public void doBefore(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature().toLongString());//打印切入点的方法名称
		System.out.println("Test Aspect : 前置通知 ...");
	}

	//声明后置通知
	@AfterReturning(pointcut = "ControllerCutMethod()", returning = "result")
	public void doAfterReturning(String result) {
		System.out.println("Test Aspect : 后置通知");
		System.out.println("---" + result + "---");
	}

	//声明例外通知
	@AfterThrowing(pointcut = "ControllerCutMethod()", throwing = "e")
	public void doAfterThrowing(Exception e) {
		System.out.println("Test Aspect : 例外通知");
		System.out.println(e.getMessage());
	}

	//声明最终通知
	@After("ControllerCutMethod()")
	public void doAfter() {
		System.out.println("Test Aspect : 最终通知");
	}

	//声明环绕通知
	@Around("ControllerCutMethod()")
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("Test Aspect : 进入方法---环绕通知");
		Object o = pjp.proceed();
		System.out.println("Test Aspect : 退出方法---环绕通知");
		return o;
	}

}