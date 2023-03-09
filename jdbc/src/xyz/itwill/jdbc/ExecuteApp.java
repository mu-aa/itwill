package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteApp {
	public static void main(String[] args) throws SQLException {
		Connection con=ConnectionFactory.getConnection();
		
		Statement stmt=con.createStatement();
		
		/*String sql1="update student set name='임꺽정' where no=2000";
		int rows=stmt.executeUpdate(sql1);
		
		System.out.println("[결과]"+rows+"명의 학생정보를 변경 하였습니다.");
		System.out.println("\n================================================\n");
		
		
		String sql2="select * from student order by no";
		ResultSet rs=stmt.executeQuery(sql2);
		
		while(rs.next()) {
			System.out.println("학번 = "+rs.getInt("no"));
			System.out.println("이름 = "+rs.getString("name"));
			System.out.println("----------------------");
		}*/
		
		int choice=1;
		
		String sql="";
		if(choice==1) {
			sql="update student set name='임꺽정' where no=2000";
		} else {
			sql="select * from student order by no";
		}
		
		//Statement.execute(String sql) : SQL 명령을 전달하여 실행하는 메소드 - boolean 반환
		//ㄴ false 반환 : DML 명령(INSER, UPDATE, DELETE) 또는 DDL 명령(CREATE, DROP)을 전달하여 실행한 경우의 반환값
		//ㄴ true 반환 :SELECT 명령을 전달하여 실행한 경우의 반환값
		boolean result=stmt.execute(sql);
		if(result) {
			//Statement.getResultSet() : Statement 객체로 전달되어 실행된 SELECT 명령에 대한
			//							 검색결과를 저장한 ResultSet 객체를 반환하는 메소드
			ResultSet rs=stmt.getResultSet();
			
			while(rs.next()) {				
				System.out.println("학번 = "+rs.getInt("no"));
				System.out.println("이름 = "+rs.getString("name"));
				System.out.println("----------------------");
				ConnectionFactory.close(con, stmt, rs);
			}
		} else {
			//Statement.getUpdateCount() : Statement 객체로 전달되어 실행된 DML 명령에 대한
			//							   조작행의 갯수를 정수값으로 반환 - DDL은 0을 반환
			int rows=stmt.getUpdateCount();
			
			System.out.println("[결과]"+rows+"명의 학생정보를 변경 하였습니다.");			
			
			ConnectionFactory.close(con, stmt);
		}
	
		
	}
}
