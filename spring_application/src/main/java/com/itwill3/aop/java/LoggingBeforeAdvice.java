package com.itwill3.aop.java;
/*
 * 메소드 호출전에 필요한 작업처리[log]를 위한 클래스
 */
public class LoggingBeforeAdvice {
	public void beforeLog() {
		System.out.println("### [사전충고] 메소드호출전에 필요한 작업처리[log]");

	}
	
}
