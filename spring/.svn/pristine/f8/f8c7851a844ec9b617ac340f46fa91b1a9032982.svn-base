package xyz.itwill.controller;


import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


//Spring Framework를 사용하여 테스트 프로그램을 작성하여 단위 프로그램(모듈) 테스트 하는 방법
//ㄴ SpringMVC에서의 모듈(Component) : DAO 클래스, Service 클래스, Controller 클래스의 메소드
//●1. JUnit 라이브러리와 spring-test 라이브러리를 프로젝트에 build - maven : pom.xml
//●2. 테스트 프로그램에서 사용될 로그 구현체의 환경설정파일 변경
//ㄴ [src/test/resources] 폴더의 log4j.xml 파일의 내용 수정
//●3. [src/test/java] 폴더에 테스트 프로그램에 대한 클래스 작성
//ㄴ JUnit 라이브러리와 spring-test 라이브러리에서 Scope 속성을 주석 처리해야 테스트 프로그램
//관련 클래스 작성 가능 - 테스트 프로그램 실행 후 주석 제거
//●4. 테스트 프로그램 실행 - 모듈 테스트

//@RunWith : 테스트 프로그램을 실행하기 위해 테스트 클래스의 메소드를 호출하기 위한 클래스를
//설정하는 Annotation - 테스트 클래스를 실행하기 위한 클래스 설정
//value 속성 : 테스트 클래스를 실행하기 위한 Clazz를 속성값으로 설정
//ㄴ 다른 속성이 없는 경우 속성값만 설정 가능 - value 생략 가능
//SpringJUnit4ClassRunner 클래스를 사용하여 테스트 클래스를 실행할 경우 ApplicationContext
//객체(Spring Container)가 생성되어 제공
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration : 테스트 클래스에서 사용할 수 있는 Spring Bean을 제공하기 위한
//Spring Bean Configuration File을 설정하는 Annotation - Spring Container에 의해 관리하기 위한 객체
//locations 속성 : Spring Bean Configuration File의 경로를 요소로 저장한 배열을 속성값으로 설정 
//ㄴ Spring Bean Configuration File의 경로는 file 접두사를 사용하여 파일 시스템 형식으로 표현 
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class DataSourceTest {
	private static final Logger logger=LoggerFactory.getLogger(DataSourceTest.class);
	
	//테스트 클래스에서 사용할 객체를 저장하기 위한 필드 선언
	//ㄴ @Autowired Annotation을 사용해 필드에 의존성 주입 - 생성자 사용 불가
	@Autowired
	private DataSource dataSource;
	
	//@Test : 테스트 메소드를 설정하는 Annotation
	//ㄴ SpringJUnit4ClassRunner에 의해 호출되어 모듈 테스트를 실행할 메소드
	@Test
	public void testDataSource() throws SQLException {
		logger.info("DataSource = "+dataSource);
		Connection connection=dataSource.getConnection();
		logger.info("Connection = "+connection);
		connection.close();
	}
}