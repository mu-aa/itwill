package xyz.itwill.controller;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import xyz.itwill10.dto.Student;
import xyz.itwill10.service.StudentService;

//테스트 클래스의 메소드에서는 일반적으로 Service 클래스의 메소드 또는 Controller 클래스의
//메소드를 호출하여 메소드가 정상적으로 동작되는지를 검사할 목적으로 작성

@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration : ApplicationContext 객체가 아닌 WeppApplicationContext 객체로
//Spring Container 역할을 제공하도록 설정하기 위한 Annotation
@WebAppConfiguration
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"
		, "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
//@FixMethodOrder : 테스트 메소드의 호출 순서를 설정하기 위한 Annotation
//value 속성 : MethodSorters 자료형(Enum)의 상수 중 하나를 속성값으로 설정
//ㄴ MethodSorters.DEFAULT : JUnit 프로그램의 내부 규칙에 의해 정렬되어 메소드 호출 - 테스트마다 동일한 순서로 메소드 호출
//ㄴ MethodSorters.JVM : JVM에 의해 정렬되어 메소드 호출 - 테스트마다 변경된 순서로 메소드 호출
//ㄴ MethodSorters.NAME_ASCENDING : 테스트 메소드의 이름을 오름차순 정렬하여 메소드 호출
@FixMethodOrder(value=MethodSorters.NAME_ASCENDING)
public class StudentServiceTest {
	private static final Logger logger=LoggerFactory.getLogger(StudentServiceTest.class);
	
	@Autowired
	private StudentService studentService;
	
	@Test
	public void testAddStudent() {
		Student student=new Student();
		student.setNo(6000);
		student.setName("홍경래");
		student.setPhone("010-5133-8841");
		student.setAddress("서울시 중랑구");
		student.setBirthday("2000-09-10");
		
		studentService.addStudent(student);
	}
	
	@Test
	public void testGetStudentList() {
		List<Student> studentList=studentService.getStudentList();
		
		for(Student student:studentList) {
			//DTO 클래스의 toString() 메소드 호출 - 모든 필드값을 문자열로 변환하여 반환 
			logger.info(student.toString());
		}
	}
}