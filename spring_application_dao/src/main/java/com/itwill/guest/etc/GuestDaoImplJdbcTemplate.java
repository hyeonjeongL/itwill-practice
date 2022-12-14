package com.itwill.guest.etc;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestDao;
import com.itwill.guest.GuestSQL;
import com.itwill.user.User;

public class GuestDaoImplJdbcTemplate implements GuestDao {
	private JdbcTemplate jdbcTemplate;
	public GuestDaoImplJdbcTemplate() {
		System.out.println("#### GuestDaoImplJdbcTemplate() 기본생성자");
	}
	

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		System.out.println("#### GuestDaoImplJdbcTemplate : setJdbcTemplate("+jdbcTemplate+") 메소드호출");
		this.jdbcTemplate = jdbcTemplate;
	}


	@Override
	public List<Guest> selectAll() throws Exception {
		return jdbcTemplate.query(GuestSQL.GUEST_SELECT_ALL, new BeanPropertyRowMapper<Guest>(Guest.class));
	}

	@Override
	public Guest selectByNo(int no) throws Exception {
		return jdbcTemplate.queryForObject(GuestSQL.GUEST_SELECT_BY_NO, 
										   new Object[] {no}, 
										   new BeanPropertyRowMapper<Guest>(Guest.class));
	}

	@Override
	public int insertGuest(Guest guest) throws Exception {
		return jdbcTemplate.update(GuestSQL.GUEST_INSERT, guest);
	}

	@Override
	public int updateGuest(Guest guest) throws Exception {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(GuestSQL.GUEST_UPDATE,guest);
	}

	@Override
	public int deleteGuest(int no) throws Exception {
		return jdbcTemplate.update(GuestSQL.GUEST_DELETE,no);
	}
	

}
