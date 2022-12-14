package com.mybatis3.dao;

public class MapperInterfaceStudentDaoMain {

	public static void main(String[] args) {
		MapperInterfaceStudentDao mapperInterfaceStudentDao=
				new MapperInterfaceStudentDao();
		System.out.println("<<<<<<<<<<<<<< StudentMapper Interface를 사용한Dao메쏘드호출 >>>>>>>>>");
		System.out.println("---------findAllStudents-----------------------------");
		System.out.println(mapperInterfaceStudentDao.findAllStudents());
		System.out.println("---------findStudentById-----------------------------");
		System.out.println(mapperInterfaceStudentDao.findStudentById(3));
		System.out.println("---------findStudentByIdWithAddress-----------------------------");
		System.out.println(mapperInterfaceStudentDao.findStudentByIdWithAddress(3));
		System.out.println("---------findStudentByIdResultMap-----------------------------");
		System.out.println(mapperInterfaceStudentDao.findStudentByIdResultMap(3));
	}

}
