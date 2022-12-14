package com.mybatis3.dao.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis3.domain.Student;

public class MapperProxy implements StudentMapper {
	
	private SqlSession sqlSession;
	@Override
	public Student findStudentById(Integer studId) {
		String namespace = StudentMapper.class.getName();
		
		Student student=sqlSession.selectOne(namespace+".findStudentById",studId);
		sqlSession.commit();
		sqlSession.close();
		return student;
	}

	@Override
	public List<Student> findAllStudents() {
		String namespace = StudentMapper.class.getName();
		return sqlSession.selectList(namespace+".findAllStudents");
		
	}

	@Override
	public Student findStudentByIdWithAddress(Integer studId) {
		// TODO Auto-generated method stub
		return null;
	}

}