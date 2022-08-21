package com.itwill.guest;

import java.util.Date;

public class GuestDaoMyBatisTestMain {

	public static void main(String[] args) throws Exception {
		GuestDaoMyBatis guestDaoMyBatis = new GuestDaoMyBatis();

		System.out.println("----selectAll---");
		System.out.println(guestDaoMyBatis.selectAll());
		System.out.println("----insertGuest---");
		System.out.println(guestDaoMyBatis
				.insertGuest(new Guest(null, "임현정", "2022/08/22", "new@naver.com", "www.naver.com", "타이틀", "컨텐츠")));
		System.out.println("----selectGuestById---");
		System.out.println(guestDaoMyBatis.selectByNo(2));
		System.out.println("----selectAll---");
		System.out.println(guestDaoMyBatis.selectAll());
		System.out.println("----updateGuest---");
		Guest guest = guestDaoMyBatis.selectByNo(10);
		guest.setGuest_name("임수정");
		guest.setGuest_date("2022/08/23");
		guest.setGuest_email("change@naver.com");
		System.out.println("update rowCount : "+guestDaoMyBatis.updateGuest(guest));
		System.out.println("----deleteGuest---");
		System.out.println(guestDaoMyBatis.deleteGuest(13));
	}

}
