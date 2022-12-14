package com.mybatis3.dao;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis3.dao.mapper.StudentMapper;
import com.mybatis3.domain.Student;

public class MapperInterfaceStudentDao {
	private SqlSessionFactory sqlSessionFactory;
	
	public MapperInterfaceStudentDao() {
		try {
			InputStream mybatisConfigInputStream = 
					Resources.getResourceAsStream("mybatis-config-mapper-interface.xml");
			SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
			this.sqlSessionFactory = 
					sqlSessionFactoryBuilder.build(mybatisConfigInputStream);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**************************************************
	 * SELECT [student]
	 **************************************************/
	/*
	 select sql의결과타입이 DTO[DTO List] 객체인경우
	 resultType :  DTO
	*/
	
	public Student findStudentById(Integer studId) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
		Student student=studentMapper.findStudentById(studId);
		sqlSession.close();
		return student;
	}
	public List<Student> findAllStudents() {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		List<Student> studentList=studentMapper.findAllStudents();
		sqlSession.close();
		return studentList;
	}

	/*
	 * select sql의결과타입이 DTO[DTO List] 객체인경우
	 * resultMap :  DTO
	 */
	public Student findStudentByIdResultMap(Integer studId) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
		Student student=studentMapper.findStudentByIdResultMap(studId);
		sqlSession.close();
		return student;
	}
	public List<Student> findAllStudentsResultMap() {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
		sqlSession.close();
		return null;
	}
	/**************************************************
	 * SELECT[student + address JOIN]( 1 : 1 )
	 **************************************************/
	/*
	 * select sql의결과타입이 DTO,VO,Domain객체인경우
	 * resultMap : studentWithAddressResultMap
	 */
	public Student findStudentByIdWithAddress(Integer studId) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
		Student student=studentMapper.findStudentByIdWithAddress(studId);
		sqlSession.close();
		return student;
	}
	/*********************************************************
	 * SELECT[students + courses[course_enrollment]+course] JOIN( 1 : N )
	 ********************************************************/
	/*
	 * select sql의결과타입이 DTO,VO,Domain객체인경우
	 * resultMap : studentWithCoursesResultMap
	 */
	public Student findStudentByIdWithCourses(Integer studId) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
		Student student = studentMapper.findStudentByIdWithCourses(studId);
		sqlSession.close();
		return student;
	}
	/**************************************************
	 * INSERT
	 ***************************************************/
	/*
	parameterType: DTO,VO,Domain
	*/
	@Insert("INSERT INTO STUDENTS (STUD_ID,NAME,EMAIL,DOB) VALUES (STUDENTS_STUD_ID_SEQ.nextval,#{name},#{email},#{dob})")
	@SelectKey(statement = "select STUDENTS_STUD_ID_SEQ.currval  from dual", keyProperty = "studId", before=true, resultType=Integer.class)
	public int insertStudent(Student student) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
		int rowCount = studentMapper.insertStudent(student);
		sqlSession.close();
		return rowCount;
	}
	public int insertStudentBySequence1(Student student) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
		int rowCount = studentMapper.insertStudentBySequence1(student);
		sqlSession.close();
		return rowCount;
	}
	
	/**************************************************
	 * UPDATE
	 ***************************************************/
	/*
	  parameterType: DTO,VO,Domain
	 */
	public int updateStudentById(Student updateStudent) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
		int rowCount = studentMapper.updateStudentById(updateStudent);
		sqlSession.close();
		return rowCount;
	}
	/**************************************************
	 * DELETE
	 ***************************************************/
	/*
	 parameterType: java.lang.Integer,java.lang.String
	 */
	public int deleteStudentById(Integer studId) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		StudentMapper studentMapperProxy =sqlSession.getMapper(StudentMapper.class);
		int rowCount = studentMapperProxy.deleteStudentById(studId);
		sqlSession.close();
		return rowCount;
	}
}
