package xyz.itwill10.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import xyz.itwill10.dto.Student;
import xyz.itwill10.mapper.StudentMapper;

//~ SpringMVC Framework에 Mybatis Framework를 사용하여 DAO 클래스를 작성하는 방법 ~
//●1. DataSource 관련 라이브러리와 Mybatis 관련 라이브러리를 프로젝트에 Build - maven : pom.xml
//ㄴ ojdbc11, spring-jdbc(spring-tx), mybatis, mybatis-spring
//●2. Mybatis Framework의 환경설정파일 작성 - 생략 가능
//ㄴ src/main/webapp 폴더에 작성해야 Spring Container(WebApplicationContext 객체)가 Mybatis Framework의
//환경설정파일에 접근 가능 - 환경설정에 따라 src/main/java 또는 src/main/resources 폴더에 작성 가능
//●3. DataSource 관련 클래스, SqlSessionFactory 관련 클래스, SqlSession 관련 클래스를 Spring Bean으로 등록
//ㄴ SpringMVC Framework의 Spring Container를 초기화 처리하기 위한 Spring Bean Configuration File에서
//bean Element로 해당 클래스를 Spring Bean으로 등록 - root-context.xml 또는 servlet-context.xml
////●4.테이블 생성 -> DTO 클래스 작성 -> 매퍼 파일 작성 -> DAO 클래스 작성 - 반복

//~ Mybatis Framework의 로그 팩토리에 의해 생성된 로그 이벤트를 Spring Framewokr의 로그 구현체로 기록하는 방법 ~
//●1. log4jdbc-log4j2-jdbc4 라이브러리를 프로젝트에 build - maven : pom.xml
//●2. DataSource 관련 클래스를 Spring Bean으로 등록한 Spring Bean Configuration File의
//bean Element에서 driverClassName 필드값과 url 필드값 변경 - root-context.xml
//●3. [src/main/resources] 폴더에 [log4jdbc.log4j2.properties] 파일 작성
//ㄴ Mybatis Framework의 로그 이벤트를 Spring Framework에 전달하기 위한 SpyLogDelegator 클래스를 지정하기 위한 파일
//●4. SpyLogDelegator 객체에 의해 발생된 로그 이벤트를 로그 구현체에 의해 기록되도록 환경설정파일 변경  - log4j.xml

//DAO 클래스 : 저장매체에게 행에 대한 삽입, 변경, 삭제, 검색 기능을 제공하는 객체를 생성하기 위한 클래스
//ㄴ DAO 클래스의 메소드에서는 DBMS 서버에 SQL 명령을 전달하여 실행하고 실행결과를 제공받아
//Java 객체(또는 원시값)로 변환하여 반환되도록 작성
//ㄴ DAO 클래스가 변경돼도 의존관계가 설정된 Service 클래스에 영향을 최소화하기 위해 인터페이스를 상속받아 작성

//DAO 클래스는 Service 클래스에서 객체로 제공받아 사용되도록 반드시 Spring Bean으로 등록 
//ㄴ DAO 클래스는 @Repository Annotation을 사용하여 Spring Bean으로 등록
//ㄴ @Repository Annotation을 사용하면 SQL 명령으로 발생되는 예외를 Spring 관련 예외로 제공되도록 설정
//ㄴ @Repository Annotation을 Spring Container가 Spring Bean으로 등록하기 위해서는 반드시 클래스를 작성한 패키지를
//Spring Bean Configuration File(servlet-context.xml)의 component-scan Element로 검색되도록 설정
@Repository
//final 필드만 초기화 설정하는 생성자를 만들어주는 Annotation
//ㄴ 생성자가 하나만 작성된 경우 @Autowired Annotation 생략 가능
@RequiredArgsConstructor
public class StudentDAOImpl implements StudentDAO {
	//Mybatis Framework로 DAO 클래스를 작성할 경우 Mapper에 등록된 SQL 명령을 전달하여 실행하고
	//결과를 Java 객체(또는 원시값)로 반환받기 위해 SqlSession 객체가 반드시 필요
	//ㄴ SqlSession 객체를 저장하기 위한 필드에 Spring Container에 의해 관리되는 Spring Bean 중
	//★SqlSession 관련 객체를 제공받아 필드에 Injection 처리 - DI
	//ㄴ 필드를 초기화하는 생성자를 생성하여 @Autowired Annotation을 사용하여 의존성 주입 - @RequiredArgsConstructor로 대체
	private final SqlSession sqlSession;
	
	@Override
	public int insertStudent(Student student) {
		return sqlSession.getMapper(StudentMapper.class).insertStudent(student);
	}

	@Override
	public List<Student> selectStudentList() {
		return sqlSession.getMapper(StudentMapper.class).selectStudentList();
	}
}