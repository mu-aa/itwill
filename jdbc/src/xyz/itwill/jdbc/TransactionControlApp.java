package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//JDBC 프로그램은 기본적으로 AutoCommit 기능이 활성화 되어있음
//ㄴ 프로그램 실행 시 예외가 발생한 경우 예외 발생전에 전달되어 실행된 SQL 명령에 대한 ROLLBACK 불가능
//JDBC 프로그램에서 AutoCommit 기능을 비활성화 처리하여 예외 발생 없이 
//프로그램이 정상적으로 실행된 경우 Commit 처리, 예외가 발생한 경우 Rollback 처리하는 것을 권장

//STUDENT 테이블에 저장된 학생정보 중 학번이 [2000]인 학생의 이름을 [임꺽정]으로 변경하는 프로그램
public class TransactionControlApp {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="scott";
			String pswd="tiger";
			con=DriverManager.getConnection(url, user, pswd);
			
			con.setAutoCommit(false); //AutoCommit 비활성화
			
			stmt=con.createStatement();
			
			String sql="update student set name='임꺽정' where no=2000";
			int rows=stmt.executeUpdate(sql);
			
			if(rows>0) { //조작된 행이 있는경우
				System.out.println("[메세지]"+rows+"명의 학생정보를 변경 하였습니다.");
			} else { //조작된 행이 없는경우
				System.out.println("[메세지]해당 학번의 학생정보를 찾을 수 없습니다");
			}
			
			con.commit(); // 예외없이 정상적으로 처리되었을 때 Commit 처리
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("[error]error");
			try {
				con.rollback(); //예외가 발생하면 Rollback 처리
			} catch (SQLException e1) {}
		} finally {
				try {
					if(stmt!=null) stmt.close();
					if(con!=null) con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}		
	}
}
