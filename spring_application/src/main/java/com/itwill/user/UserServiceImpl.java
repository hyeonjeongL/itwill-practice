package com.itwill.user;

import java.util.List;

public class UserServiceImpl implements UserService {
	private UserDao userDao;

	public UserServiceImpl() {
		System.out.println("#### UserServiceImpl() : 디폴트생성자호출");

	}

	
	public void setUserDao(UserDao userDao) {
		System.out.println("#### UserServiceImpl : setUserDao("+userDao+") 호출");
		this.userDao = userDao;
	}


	public int create(User user) throws Exception {

		System.out.println("#### UserServiceImpl : create() 호출");

		return 0;
	}

	/*
	 * User 상세보기
	 */
	public User findUser(String userId) throws Exception {

		System.out.println("#### UserServiceImpl : findUser() 호출");

		return null;

	}

	/*
	 * 로그인
	 */
	public User login(String userId, String password) throws Exception {
		System.out.println("#### UserServiceImpl : login() 호출");
		return null;

	}

	public int update(User user) throws Exception {
		System.out.println("#### UserServiceImpl : update() 호출");
		return 0;
	}

	public int remove(String userId) throws Exception {
		System.out.println("#### UserServiceImpl : remove() 호출");
		return 0;
	}

	public List<User> findUserList() throws Exception {
		System.out.println("#### UserServiceImpl : findUserList() 호출  ");
		return null;
	}

}
