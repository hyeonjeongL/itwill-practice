package com.itwill.hello;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HelloDao {
	@Autowired
	private javax.sql.DataSource dataSource;
	
	public List<String> hello() throws Exception{
		List<String> helloList=new ArrayList<String>();
		helloList.add("KIM");
		helloList.add("LEE");
		helloList.add("PARK");
		helloList.add(dataSource.getConnection().toString());
		return helloList;
	}
}
