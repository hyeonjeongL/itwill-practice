package com.itwill.user.etc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.itwill.user.User;
import com.itwill.user.UserDao;
import com.itwill.user.UserSQL;

public class UserDaoImplJdbcTemplate implements UserDao{
	private JdbcTemplate jdbcTemplate;
	
	public UserDaoImplJdbcTemplate() {
		System.out.println("#### UserDaoImplJdbcTemplate() 기본생성자");
	}
	

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		System.out.println("#### GuestDaoImplJdbcTemplate : setJdbcTemplate("+jdbcTemplate+") 메쏘드호출");
		this.jdbcTemplate = jdbcTemplate;
	}


	@Override
	public int create(User user) throws Exception {
		return jdbcTemplate.update(UserSQL.USER_INSERT, new Object[] {user});
	}

	@Override
	public int update(User user) throws Exception {
		return jdbcTemplate.update(UserSQL.USER_UPDATE, new BeanPropertyRowMapper<User>(User.class));
	}

	@Override
	public int remove(String userId) throws Exception {
		return jdbcTemplate.update(UserSQL.USER_REMOVE,userId);
	}

	@Override
	public User findUser(String userId) throws Exception {
		return jdbcTemplate.queryForObject(UserSQL.USER_SELECT_BY_ID, new BeanPropertyRowMapper<User>(User.class),userId);
	}

	@Override
	public List<User> findUserList() throws Exception {
		return jdbcTemplate.query(UserSQL.USER_SELECT_ALL, new BeanPropertyRowMapper<User>(User.class));
	}

	@Override
	public boolean existedUser(String userId) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}