package com.itwill.guest.test;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestDao;

public class GuestDaoImplMyBatisTestAnnotationMain {

	public static void main(String[] args) throws Exception{
		System.out.println("----Spring Container초기화시작[ApplicationContext객체생성시작]");
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext("com/itwill/guest/guest_dao_mybatis_annotation.xml");
		System.out.println("----Spring Container초기화끝[ApplicationContext객체생성끝]");
		GuestDao guestDao = (GuestDao) applicationContext.getBean("guestDaoImplmyBatis");
		System.out.println("selectAll : " + guestDao.selectAll());
		Guest guest = guestDao.selectByNo(10);
		System.out.println("selectByNo(10) : "+ guest);
		System.out.println("deleteGuest : "+guestDao.deleteGuest(17));
		Guest updatGuest = guestDao.selectByNo(18);
		updatGuest.setGuest_name("임업뎃");
		updatGuest.setGuest_date("2022/10/25");
		updatGuest.setGuest_email("upda232@naver.com");
		System.out.println(updatGuest);
		
		Guest newGuest = new Guest(0, "대하", "2022/02/02", "deaha@naver.com", "http://www.dada.com", "대하소금구이", "대하대하");
		System.out.println("insertGuest : "+guestDao.insertGuest(newGuest));
		System.out.println(newGuest);

	}

}
