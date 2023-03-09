package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//STUDENT 테이블에 저장된 모든 학생정보를 검색하여 출력하는 JDBC 프로그램
public class SelectStudentApp {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="scott";
			String password="tiger";
			con=DriverManager.getConnection(url, user, password);
			
			stmt=con.createStatement();
			
			String sql="select * from student order by no";
			//Statement.executeQuery(String sql) : SELECT 명령을 전달하여 실행하기 위한 메소드
			//ㄴ SELECT 명령의 실행결과를 ResultSet 객체로 반환
			//ResultSet 객체 : 검색결과를 테이블 형식(2차원 배열)의 객체로 저장하여 표현한 객체
			rs=stmt.executeQuery(sql);
			
			//ResultSet 객체에 저장된 검색행을 행단위로 처리하기 위해 내부적인 커서(Cursor) 제공
			//ㄴ ResultSet 커서는 최초 BOF(Before Of File) 영역에 위치
			//ResultSet.next() : ResultSet 커서를 다음 행으로 이동하는 메소드 - boolean 반환
			//ㄴ false 반환 : ResultSet 커서 위치에 처리행이 없는 경우 - EOF(End Of File)
			//ㄴ true 반환 : ResultSet 커서 위치에 처리행이 있는 경우
			
			if(rs.next()) {		//ResultSet 커서가 다음행으로 이동하여 처리행이 존재하는 경우
				
				//검색된 다수의 학생정보가 저장된 ResultSet 객체를 처리하기 위한 반복문
				//ㄴ ResultSet 객체에 저장된 학생정보의 갯수가 불확실하므로 while 반복문 사용 
				//ㄴ ResultSet 커서를 첫번째 행 처리 후에 다음행으로 이동하기 위해 do~while문 사용
				do {
					//ResultSet 커서가 위치한 처리행의 컬럼값을 반환받아 저장
					//ResultSet.getXXX(int columnIndex) 또는 ResultSet.getXXX(int columnLabel)
					//ㄴ ResultSet 커서가 위치한 처리행의 컬럼값을 반환하는 메소드
					//ㄴ XXX : 컬럼값을 반환받기 위한 Java 자료형
					//ㄴ columnIndex : 검색행의 검색대상 위치값(첨자, Index : 1부터 1씩 증가)을 표현하여 컬럼값 표현
					//ㄴ columnLabel : 검색행의 검색대상 이름(컬럼명 또는 별칭)으로 컬럼값 표현
//					int no=rs.getInt(1);  //컬럼 인덱스
					int no=rs.getInt("no");  //컬럼 라벨
					String name=rs.getString("name");
					String phone=rs.getString("phone");
					String address=rs.getString("address");
//					Date birthday=rs.getDate("birthday");
					//처리행의 컬럼값은 오라클 자료형에 상관없이 getString() 메소드를 호출하여 문자열로 변환 가능
					String birthday=rs.getString("birthday");
					
					System.out.println("학번 = "+no);
					System.out.println("이름 = "+name);
					System.out.println("전화번호 = "+phone);
					System.out.println("주소 = "+address);
					System.out.println("생년월일 = "+birthday.substring(0, 10)); //substring으로 연 월 일만 출력 
					System.out.println("\n=================================================\n");
					
				} while(rs.next()); //ResultSet 커서 위치에 처리행이 없을 때 까지 반복
			} else { 	 //ResultSet 커서가 다음행으로 이동하여 처리행이 존재하지 않는 경우
				System.out.println("[message]검색된 학생정보가 있습니다.");
			}
		} catch(ClassNotFoundException e) {
			System.out.println("[error]OracleDriver 클래스를 찾을 수 없습니다.");
		} catch(SQLException e) {
			System.out.println("[error]JDBC 관련 오류 발생 = "+e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
				e.getStackTrace();
			}
		}
	}
}
