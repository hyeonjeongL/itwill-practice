package com.itwill.dao;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.itwill.guest.Guest;

public class SpringJDbcTemplateMain {

	public static void main(String[] args) {
		System.out.println("----Spring Container초기화시작[ApplicationContext객체생성시작]");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"com/itwill/dao/spring_jdbctemplate.xml");
		System.out.println("----Spring Container초기화끝[ApplicationContext객체생성끝]");
		JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean(JdbcTemplate.class);
		System.out.println("1. JdbcTemplate객체얻기 : " + jdbcTemplate);
		/*
		 * SELECT ==> queryForObject 반환타입[String, wrapper]
		 */
		/*
		 * queryForObject [반환타입 DTO]
		 */

		String selectDtoDql = "select * from guest where guest_no=?";

		BeanPropertyRowMapper<Guest> guestBeanPropertyRowMapper = new BeanPropertyRowMapper<Guest>(Guest.class);

		Guest guest = jdbcTemplate.queryForObject(selectDtoDql, new Object[] { 10 }, guestBeanPropertyRowMapper);
		System.out.println(guest);

		/*
		 * query [반환타입 List<Guest> = List<Dto>]
		 */
		String selectDtoListSql = "select * from guest";
		List<Guest> guestList = jdbcTemplate.query(selectDtoListSql, guestBeanPropertyRowMapper);
		System.out.println("query[List<Guest>] : " + guestList);

		List<Map<String, Object>> mapList = jdbcTemplate.queryForList(selectDtoListSql);
		System.out.println("queryForList[List<Map>] : " + mapList);

		/*
		 * queryForObject [반환타입 String]
		 */
		String selectStringSql = "select guest_name from guest where guest_no=?";
		String guest_name = jdbcTemplate.queryForObject(selectStringSql, new Object[] { 11 }, String.class);
		System.out.println("guestForObject[String] --> " + guest_name);

		/*
		 * query [반환타입 List<String>]
		 */
		String selectStringListSql = "select guest_name from guest";
		List<String> guest_nameList = jdbcTemplate.queryForList(selectStringListSql, String.class);
		System.out.println("queryForList[List<String>] : " + guest_nameList);

		/*
		 * queryForObject [반환타입 Integer]
		 */
		String selectIntegerSql = "select guest_no from guest where guest_no=?";
		Integer guest_no = jdbcTemplate.queryForObject(selectIntegerSql, new Object[] { 10 }, Integer.class);
		System.out.println("guestForObject[Integer] --> " + guest_no);

		/*
		 * query [반환타입 List<Integer>]
		 */
		String selectIntegerListSql = "select guest_no from guest";
		List<Integer> guest_noList = jdbcTemplate.queryForList(selectIntegerListSql, Integer.class);
		System.out.println("queryForList[List<Integer>] : " + guest_noList);

		/********************************************************
		 * update, delete, insert ==> update[rowCount(int)
		 */
		String insertSql = "insert into guest values(guest_no_seq.nextval,?,sysdate,?,?,?,?)";
		int rowCount = jdbcTemplate.update(insertSql,"김수미", "sumi@gmail.com","http://www.naver.com","타티을","내용");
		System.out.println("insert rowcount : "+rowCount);
		
		String updateSql = "update guest set  guest_name=?, guest_email=?, guest_homepage=?, guest_title=?, guest_content=? where guest_no=?";
		rowCount = jdbcTemplate.update(updateSql,"김변경", "change@naver.com","http:www.change.com", "chatge", "쉬는시간", 17);
		System.out.println("update rowCount : "+rowCount);
		
		String deleteSql = "delete from guest where guest_no=?";
		rowCount = jdbcTemplate.update(deleteSql,13);
		System.out.println("delete rowCount : "+rowCount);
	}

}
