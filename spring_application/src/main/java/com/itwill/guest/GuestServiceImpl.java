package com.itwill.guest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
@Service(value = "guestService")
@Scope(value = "prototype")
public class GuestServiceImpl implements GuestService {
	
	private GuestDao guestDao;
	
	public GuestServiceImpl() {
		System.out.println("1.#### GuestServiceImpl() 기본생성자");
	}
	@Autowired
	public GuestServiceImpl(@Qualifier(value = "guestDao") GuestDao guestDao) {
		System.out.println("1.#### GuestServiceImpl("+guestDao+") 생성자");
		this.guestDao=guestDao;
		
	}
	
	@Autowired(required = true)
	@Qualifier(value = "guestDao")
	public void setGuestDao(GuestDao guestDao) {
		System.out.println("#### GuestServiceImpl : setGuestDao("+guestDao+") 호출");
		this.guestDao = guestDao;
	}

	
	@Override
	public List<Guest> selectAll()throws Exception{
		System.out.println("#### GuestServiceImpl : selectAll() 호출");
		return  guestDao.selectAll();
	}
	@Override
	public Guest selectByNo(int no)throws Exception{
		System.out.println("#### GuestServiceImpl : selectByNo(int no) 호출");
		return guestDao.selectByNo(2);
	}
	@Override
	public int insertGuest(Guest insetGuest)throws Exception{
		System.out.println("#### GuestServiceImpl : insertGuest(Guest guest) 호출");
		return guestDao.insertGuest(new Guest(0, "스프링", "2022/02/22" , "spring@naver.com", "www.naver.com", "제목", "내용"));
	}
	@Override
	public int updateGuest(Guest guest)throws Exception{
		System.out.println("#### GuestServiceImpl : updateGuest(Guest guest) 호출");
		return guestDao.updateGuest(new Guest(18, "수정프링", "2022/02/22" , "chring@naver.com", "www.naver.com", "제목수정", "내용수정"));
	}
	@Override
	public int deleteGuest(int no)throws Exception{
		System.out.println("#### GuestServiceImpl : deleteGuest(int no) 호출");
		return guestDao.deleteGuest(15);
	}
	
}
