package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

//DBCP(DataBase Connection Pool) : DBMS 서버에 미리 접속하여 다수의 Connection 객체를 저장하여
//제공하기 위한 기능의 클래스(객체)
//ㄴ JDBC 프로그램의 가독성 및 유지보수 효율성 증가
//ㄴ DBCP 기능을 제공하는 클래스는 일반적으로 DataSource 인터페이스를 상속받아 작성

//Apache Tomcat 라이브러리에서 제공하는 DBCP 기능의 클래스를 사용하여 Connection 미리 생성하고
//생성된 Connection 객체를 제공받아 접속정보를 클라이언트에게 전달하는 Servlet
@WebServlet("/dbcp.itwill")
public class DataSourceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//BasicDataSource 객체(DataSource 객체 - DBCP) 생성
		BasicDataSource dataSource=new BasicDataSource();
		
		//BasicDataSource 객체에 저장될 Connection 객체 생성 관련 정보를
		//메소드를 호출하여 객체 필드값 변경
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("scott");
		dataSource.setPassword("tiger");
		dataSource.setInitialSize(10); //최초 생성될 Connection 객체의 갯수 변경
		dataSource.setMaxIdle(10); //대기 상태의 Connection 객체의 최대 갯수 변경
		dataSource.setMaxTotal(10); //생성 가능한 최대 Connection 객체의 최대 갯수 변경
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1> DBCP(DataBase Conneciton Pool)</h1>");
		out.println("<hr>");
		try {
			//BasicDataSource 객체에 저장된 다수의 Connection 객체 중 하나를 반환받아 저장
			Connection con=dataSource.getConnection();
			out.println("<p>con = "+con+"</p>");
			out.println("<hr>");
			out.println("<h3>Connection 객체 제공 후</h3>");
			out.println("<p>Active Connection Number = "+dataSource.getNumActive()+"</p>");
			out.println("<p>Idle Connection Number = "+dataSource.getNumIdle()+"</p>");
			con.close();
			out.println("<hr>");
			out.println("<h3>Connection 객체 제거 후</h3>");
			out.println("<p>Active Connection Number = "+dataSource.getNumActive()+"</p>");
			out.println("<p>Idle Connection Number = "+dataSource.getNumIdle()+"</p>");

			dataSource.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		out.println("</body>");
		out.println("</html>");
	}
}