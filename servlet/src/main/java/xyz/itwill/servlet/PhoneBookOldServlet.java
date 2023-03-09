package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//PHONEBOOK 테이블에 저장된 모든 회원정보를 검색하여 클라이언트에 전달하는 Servlet - JDBC
//ㄴ JDBC 프로그램을 작성하기 위해 JDBC 관련 라이브러리 파일(ojdbc 라이브러리)을 다운로드 받아 프로젝트에 Build 처리
//ㄴ src/main/webapp/WEB-INF/lib 에 copy 시 자동 build 처리
@WebServlet("/old.itwill")
public class PhoneBookOldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//JDBC 관련 객체를 저장하기 위한 참조변수 선언
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		try {
			//1. OracleDriver 클래스를 읽어 메모리에 저장
			//ㄴ OracleDriver 객체를 생성하여 DriverManager 클래스의 JDBC 드라이버로 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. DriverManager 클래스의 JDBC 드라이버로 DBMS 서버에 접속하여 Connection 객체를 반환받아 저장
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="scott";
			String password="tiger";
			con=DriverManager.getConnection(url, user, password);
			
			//3. 접속된 DBMS 서버에 전달되어 실행될 SQL 명령이 저장된 PreparedStatement 객체를
			//Connection 객체에게 반환받아 저장
			String sql="select * from phonebook order by phone";
			pstmt=con.prepareStatement(sql);
			
			//4. PreparedStatement 객체에 저장된 SQL 명령을 전달하여 실행하고 결과를 반환받아 저장
			rs=pstmt.executeQuery();
			
			//5. 반환받은 SQL 명령을 실행 결과를 이용하여 처리 작업
			//ㄴ SQL 명령의 실행 결과를 HTML 문서로 생성하여 클라이언트에게 전달
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset='UTF-8'>");
			out.println("<title>Servlet</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>전화번호부</h1>");
			out.println("<hr>");
			out.println("<table border='1' cellspacing='0'>");
			out.println("<tr>");
			out.println("<th width='200'>전화번호</th>");
			out.println("<th width='200'>이름</th>");
			out.println("<th width='300'>주소</th>");
			out.println("</tr>");
			//ResultSet 객체에 저장된 모든 행의 컬럼값을 클라이언트에게 전달 - 반복 처리
			while(rs.next()) { //ResultSet 커서를 다음행으로 이동하여 처리행이 존재할 경우 반복
				out.println("<tr align='center'>");
				//ResultSet 커서가 위치한 처리행의 컬럼값을 반환받아 클라이언트에게 전달
				out.println("<td>"+rs.getString("phone")+"</td>");
				out.println("<td>"+rs.getString("name")+"</td>");
				out.println("<td>"+rs.getString("address")+"</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("</body>");
			out.println("</html>");
		} catch(ClassNotFoundException e) {
			System.out.println("[ERROR]OracleDriver 클래스를 찾을 수 없습니다.");
		} catch(SQLException e) {
			System.out.println("[ERROR]JDBC 오류 = "+e.getMessage());
		} finally {
			//6. JDBC 관련 객체 제거
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch (SQLException e2) {}
		}
	}
}