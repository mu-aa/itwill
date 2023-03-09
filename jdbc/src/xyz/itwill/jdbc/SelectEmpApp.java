package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//EMP 테이블에 저장된 모든 사원정보의 사원번호,사원이름,급여를 급여로 내림차순 정렬되도록
//검색하여 출력하는 JDBC 프로그램
public class SelectEmpApp {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="scott";
			String pswd="tiger";
			
			con=DriverManager.getConnection(url, user, pswd);
			
			stmt=con.createStatement();
			
			String sql="select empno, ename, sal from emp order by sal desc";
			rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println("사원번호 = "+rs.getInt("empno"));
				System.out.println("사원이름 = "+rs.getString("ename"));
				System.out.println("급여 = "+rs.getInt("sal"));
			}
				
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
				try {
					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();
					if(con!=null) con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
}