package com.itwill.user;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDaoImplJdbcTemplateTestMain {

	public static void main(String[] args)throws Exception {
		System.out.println("-----Spring Container초기화시작[ApplicationContext객체생성시작]------------------");
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext("com/itwill/user/user_dao_jdbc_template.xml");
		System.out.println("-----Spring Container초기화끝[ApplicationContext객체생성끝]--------------------");
		UserDao userDao = (UserDao) applicationContext.getBean("userDao");
		System.out.println("----findUser----");
		System.out.println("findUser : "+userDao.findUser("guard3"));
		System.out.println("----findUserList----");
		System.out.println("findUserList : "+userDao.findUserList());
		System.out.println("----create----");
//		System.out.println("createUser : "+userDao.create(new User("hunnnnii", "1234", "임현정", "hunni@naver.com")));
		System.out.println("----update----");
		System.out.println("updateUser : "+userDao.update(new User("hunnnnii", "1234", "수정임", "22@dsf.com")));
		System.out.println("----remove----");
		System.out.println("removeUser : "+userDao.remove("guard2"));
		System.out.println("----existedUser----");
		
	}

}