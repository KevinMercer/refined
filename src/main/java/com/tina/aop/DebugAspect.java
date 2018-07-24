/**
 * 
 */
package com.tina.aop;

import java.util.Date;

import org.aspectj.lang.JoinPoint;

/**
 * @author 何悟隆
 *
 */
public class DebugAspect {
	
	private String className, methodName, paraInfo;
	private Object[] parameter;

	/**
	 * 
	 */
	public DebugAspect() {
		// TODO Auto-generated constructor stub
	}

	public void startUp(JoinPoint joinPoint) {
		//获取类名(className)
		className = joinPoint.getTarget().getClass().getName();
		//获取方法名(methodName)
		methodName = joinPoint.getSignature().getName();
		System.out.println("本地时间" + new Date() + "执行了" + className + "." + methodName + "()方法。");
	}

	public void executeUp(JoinPoint joinPoint) {
		parameter = joinPoint.getArgs();
		paraInfo = "参数：  ";
		for (int i = 0; i < parameter.length; i++) {
			paraInfo += (parameter[i] + ", ");
		}
		paraInfo = paraInfo.substring(0, paraInfo.length()-2);
		System.out.println(paraInfo);
	}

	public void returnUp(JoinPoint joinPoint, Object result) {
		System.out.println("执行结果：" + result);
	}

}
