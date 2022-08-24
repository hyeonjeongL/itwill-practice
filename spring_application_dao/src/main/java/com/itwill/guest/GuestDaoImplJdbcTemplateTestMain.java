package com.itwill.guest;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestDao;

public class GuestDaoImplJdbcTemplateTestMain {

	public static void main(String[] args) throws Exception{
		System.out.println("----Spring Container초기화시작[ApplicationContext객체생성시작]");
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext("com/itwill/guest/guest_dao_jdbc_template.xml");
		System.out.println("----Spring Container초기화끝[ApplicationContext객체생성끝]");
		GuestDao guestDao = (GuestDao) applicationContext.getBean("guestDao");
		System.out.println("1. selectAll : "+guestDao.selectAll());
		System.out.println("2. selectByNo : "+guestDao.selectByNo(4));
		System.out.println("3. insertGuest : "+guestDao.insertGuest(null));
		System.out.println("4. updateGuest : "+guestDao.updateGuest(null));
		System.out.println("5. deleteGuest : "+guestDao.deleteGuest(14));

	}

}
