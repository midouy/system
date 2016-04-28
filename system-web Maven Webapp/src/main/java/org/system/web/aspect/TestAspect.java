package org.system.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by wangyanming on 2016/4/28.
 */
@Component
@Aspect
public class TestAspect{

	@Pointcut("@annotation(org.system.web.annotation.SystemControllerLog)")
	private void pointCutMethod() {
	}

	//声明前置通知
	@Before("pointCutMethod()")
	public void doBefore() {
		System.out.println("Test Aspect : 前置通知 ...");
	}

	//声明后置通知
	@AfterReturning(pointcut = "pointCutMethod()", returning = "result")
	public void doAfterReturning(String result) {
		System.out.println("Test Aspect : 后置通知");
		System.out.println("---" + result + "---");
	}

	//声明例外通知
	@AfterThrowing(pointcut = "pointCutMethod()", throwing = "e")
	public void doAfterThrowing(Exception e) {
		System.out.println("Test Aspect : 例外通知");
		System.out.println(e.getMessage());
	}

	//声明最终通知
	@After("pointCutMethod()")
	public void doAfter() {
		System.out.println("Test Aspect : 最终通知");
	}

	//声明环绕通知
	@Around("pointCutMethod()")
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("Test Aspect : 进入方法---环绕通知");
		Object o = pjp.proceed();
		System.out.println("Test Aspect : 退出方法---环绕通知");
		return o;
	}

}