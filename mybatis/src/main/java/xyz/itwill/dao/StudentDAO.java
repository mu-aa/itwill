package xyz.itwill.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import xyz.itwill.dto.Student;

//JdbcDAO 상속 받을 필요 X
public class StudentDAO {
	private static StudentDAO _dao;
	
	private StudentDAO() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new StudentDAO();
	}
	
	public static StudentDAO getDAO() {
		return _dao;
	}
	
	//SqlSessionFactory 객체를 생성하여 반환하는 메소드
	//ㄴ SqlSessionFactory 객체를 생성하기 위해서는 반드시 mybatis 환경설정 파일(mybatis-config.xml) 필요
	//SqlSessionFactory 객체 : SqlSession 객체를 생성하여 제공하기 위한 객체
	private SqlSessionFactory getSqlSessionFactory() {
		//mybatis 환경설정 파일이 특정 패키지에 작성된 경우 파일 시스템 경로로 표현
		//String resource="xyz/itwill/config/mybatis-config.xml";
		String resource="mybatis-config.xml";
		InputStream inputStream=null;

		try {
			//mybatis 환경설정 파일을 읽기 위한 입력스트림을 반환받아 저장
			//Resources.getResourceAsStream(String resource) : 
			inputStream=Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		//SqlSessionFactoryBuilder().build(InputStream inputStream) : mybatis 환경설정 파일을
		//입력스트림을 이용하여 제공받아 SqlSessionFactory 객체를 생성하여 반환하는 메소드
		return new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	//STUDENT 테이블에 저장된 모든 학생정보를 검색하여 반환하는 메소드
	//ㄴ SqlSession 객체의 메소드를 호출하여 메소드 작성 
	public List<Student> selectStudentList() {
		//SqlSessionFactory.openSession() : SqlSession 객체를 생성하여 반환하는 메소드
		//SqlSession 객체 : mapper에 등록된 정보를 이용하여 SQL 명령을 전달하여 실행하고
		//실행결과를 Java 객체로 반환받아 사용
		SqlSession sqlSession=getSqlSessionFactory().openSession();
		
		try {
			//SqlSession.selectList(String elementId) : mapper에 등록된 SELECT 명령을 제공받아 실행하고
			//처리결과를 List 객체로 반환하는 메소드
			//ㄴ elementId 매개변수는 mapper의 식별자(namespace 속성값)와 select Element의 식별자(id 속성값)
			//를 이용하여 mapper에 등록된 SQL 명령을 구분하여 사용
			return sqlSession.selectList("xyz.itwill.mapper.StudentMapper.selectStudentList");
		} finally {
			//SqlSession.close() : SqlSession 객체가 사용한 JDBC 관련 객체를 제거하는 메소드
			sqlSession.close();
		}
	}
}