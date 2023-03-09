package xyz.itwill08.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//DataSource 객체 : 다수의 Connection 객체를 미리 생성하여 저장하기 위한 객체 - DBCP
//ㄴ Spring Bean Configuration File에서 DataSource 인터페이스를 상속받은 자식클래스를
//Spring Bean 등록하여 사용
//DataSource 인터페이스를 상속받은 자식클래스는 Spring Framework 그룹에서 제공하는
//라이브러리(spring-jdbc) 클래스를 build 처리하여 사용
//ㄴ DataSource 관련 라이브러리를 build하기 전에 Oracle Driver 관련 라이브러리(ojdbc)를
//프로젝트에 Build 처리 - pom.xml
public class DataSourceApp {
	public static void main(String[] args) throws SQLException {
		ApplicationContext context=new ClassPathXmlApplicationContext("07_dao.xml");
		DataSource dataSource=context.getBean("dataSource", DataSource.class);
		System.out.println("=====================================================");
		System.out.println("dataSource = "+dataSource);
		Connection connection=dataSource.getConnection();
		System.out.println("connection = "+connection);
		connection.close();
		System.out.println("=====================================================");
		((ClassPathXmlApplicationContext)context).close();
	}
}