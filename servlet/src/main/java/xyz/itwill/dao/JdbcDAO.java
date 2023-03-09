package xyz.itwill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

//JDBC 기능을 제공하는 DAO 클래스가 상속받기 위해 작성된 부모클래스
//ㄴ 객체 생성이 목적이 아닌 상속을 목적으로 작성된 클래스 - 추상 클래스로 작성 권장
//ㄴ WAS 프로그램에 등록된 자원을 얻어와 DataSource 객체를 반환받아 저장 - 정적영역을 이용해 1번만 실행
//ㄴ DataSource 객체로부터 Connection 객체를 제공받아 반환하는 메소드
//ㄴ 매개변수로 JDBC 관련 객체를 제공받아 제거하는 메소드
public abstract class JdbcDAO {
	private static DataSource dataSource;
	
	static {
		try {
			dataSource=(DataSource)new InitialContext().lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
	
	public void close(Connection con) {
		try {
			if(con!=null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void close(Connection con, PreparedStatement pstmt) {
		try {
			if(pstmt!=null) pstmt.close();
			if(con!=null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(con!=null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}