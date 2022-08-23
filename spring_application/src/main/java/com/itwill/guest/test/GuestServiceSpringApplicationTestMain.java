package com.itwill.guest.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

public class GuestServiceSpringApplicationTestMain {

	public static void main(String[] args) throws Exception {
		System.out.println("----Spring Container초기화시작[ApplicationContext객체생성시작]");
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext("com/itwill/guest/test/guest_service_spring_application.xml");
		System.out.println("----Spring Container초기화끝[ApplicationContext객체생성끝]");
		System.out.println("GuestService.selectAll");
		GuestService guestService = (GuestService) applicationContext.getBean("guestService");
		System.out.println(guestService.selectAll());
		System.out.println(guestService.selectByNo(2));
		System.out.println(guestService.insertGuest(new Guest(0, "스프링", "2022/02/22" , "spring@naver.com", "www.naver.com", "제목", "내용")));
		System.out.println(guestService.updateGuest(new Guest(18, "수정프링", "2022/02/22" , "chring@naver.com", "www.naver.com", "제목수정", "내용수정")));
		System.out.println(guestService.deleteGuest(15));
		
		
		
	}

}
