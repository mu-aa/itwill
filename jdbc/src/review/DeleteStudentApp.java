package review;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//STUDENT 테이블에 저장된 학생정보 중 학번이 [3000]인 학생정보를 삭제하는 JDBC 프로그램 작성 
public class DeleteStudentApp {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String username="scott";
			String password="tiger";
			
			con=DriverManager.getConnection(url, username, password);
			
			stmt=con.createStatement();
			
			String sql="delete from student where no=3000";
			int rows=stmt.executeUpdate(sql);
			
			System.out.println(rows+"개의 학생 정보가 삭제 되었습니다.");
			
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
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
