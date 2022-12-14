package com.mybatis3.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Delete;

import com.mybatis3.domain.Student;

public class StudentDaoMain {

	public static void main(String[] args) {
		StudentDao studentDao = new StudentDao();
		/**************************************************
	 	 SELECT 
		 **************************************************/
		/*
		  select sql의결과타입이 DTO[DTO List] 객체인경우
		  resultType :  Dto
		 */
		System.out.println("---------findStudentById-----------------------------");
		System.out.println(studentDao.findStudentById(7));
		System.out.println("---------findAllStudents-----------------------------");
		System.out.println(studentDao.findAllStudents());
		/*
		  select sql의결과타입이 DTO[DTO List] 객체인경우
		  resultMap :  DTO
		 */
		
		System.out.println("---------findStudentByIdResultMap--------------------");
		System.out.println(studentDao.findStudentByIdResultMap(5));
		System.out.println("---------findAllStudentsResultMap--------------------");
		System.out.println(studentDao.findAllStudentsResultMap());
		
		/**************************************************
	 	 SELECT[student + address JOIN]( 1 : 1 )
		 **************************************************/
		/*
		 * select sql의결과타입이 DTO,VO,Domain객체인경우
		 * resultMap : studentWithAddressResultMap
		 */
		System.out.println("---------findStudentByIdWithAddress------------------");
		System.out.println(studentDao.findStudentByIdWithAddress(1));
		System.out.println(studentDao.findStudentByIdWithAddress(2));
		System.out.println(studentDao.findStudentByIdWithAddress(3));
		System.out.println(studentDao.findStudentByIdWithAddress(4));
		System.out.println(studentDao.findStudentByIdWithAddress(5));
		System.out.println(studentDao.findStudentByIdWithAddress(6));
		System.out.println(studentDao.findStudentByIdWithAddress(7));
		System.out.println("---------findStudentByIdWithCourses------------------");
		System.out.println(studentDao.findStudentByIdWithCourses(1));
		
		/**************************************************
		INSERT
		***************************************************/
		/*
		parameterType: DTO,VO,Domain
		*/
		System.out.println("---------insertStudent(Dto)--------------------------");
		System.out.println(studentDao.insertStudent(new Student(null, "김", "kangkang@naver.com", new Date(), null)));
		System.out.println("---------insertStudentBySequence1--------------------");
		Student insertStudent = new Student(null, "시퀀스", "sequence@naver.com", new Date(), null);
		System.out.println("insert row Count : "+studentDao.insertStudentBySequence1(insertStudent));
		System.out.println("insert Sequence : " + insertStudent.getStudId());
		System.out.println("---------insertStudentBySequence2--------------------");
		System.out.println("insert Sequence : " + studentDao.insertStudentBySequence2(insertStudent));
		/**************************************************
		 UPDATE
		 ***************************************************/
		/*
		 parameterType: DTO,VO,Domain
		 */
		System.out.println("---------updateStudentById---------------------------");
		Student student = studentDao.findStudentById(1);
		student.setDob(new Date());
		student.setEmail("change@gmail.com");
		student.setName("김윤수");
		System.out.println("update row count:"+studentDao.updateStudentById(student));
		/**************************************************
		 DELETE
		 ***************************************************/
		/*
		parameterType: java.lang.Integer,java.lang.String
		*/
		System.out.println("---------deleteStudentById---------------------------");
		System.out.println("delete rowCount:"+studentDao.deleteStudentById(13));
		
		
	}
}
