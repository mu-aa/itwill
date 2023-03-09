package xyz.itwill.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

//키보드로 SQL 명령을 입력받아 DBMS 서버에 전달하여 실행하고 결과를 출력하는 JDBC 프로그램 작성
// => 키보드로 입력 가능한 SQL 명령은 INSERT,UPDATE,DELETE,SELECT 명령만 가능하도록 작성
// => SQL 명령을 반복적으로 입력받아 실행되도록 작성
// => SQL 명령 대신 [EXIT]를 입력하면 프로그램 종료 - 대소문자 미구분
// => 키보드로 입력한 SQL 명령이 잘못된 경우 에러 메세지 출력
public class SqlMinusApp {
	public static void main(String[] args) throws Exception {
		//키보드로 SQL 명령(문자열)을 입력받기 위한 입력스트림 생성
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		
		Connection con=ConnectionFactory.getConnection();
		Statement stmt=con.createStatement();
		ResultSet rs=null;
		
		System.out.println("SQLMinus 프로그램을 실행합니다.(종료 : exit)");
		
		while(true) {
			//키보드로 SQL 명령을 입력받아 저장
			System.out.print("SQL> ");
			String sql=in.readLine().trim();
		
			//키보드 입력값이 없는 경우 반복문을 처음부터 다시 실행
			if(sql==null || sql.equals("")) continue;
						
			//키보드 입력값이 [EXIT]인 경우 반복문 종료 - 프로그램 종료
			if(sql.equalsIgnoreCase("exit")) break; //String.equalsIgnoreCase() : 대소문자 구분없이 비교
			
			try {
				if(stmt.execute(sql)) {//SELECT 명령을 전달하여 실행한 경우
					rs=stmt.getResultSet();
					
					if(rs.next()) {//검색행이 있는 경우
						ResultSetMetaData rsmd=rs.getMetaData();
						//SELECT 명령에 대한 검색대상의 갯수를 반환받아 저장
						int columnCount=rsmd.getColumnCount();
						
						System.out.println("============================================================");
						//SELECT 명령에 대한 검색대상의 이름을 반환받아 출력
						for(int i=1;i<=columnCount;i++) {
							System.out.print(rsmd.getColumnLabel(i)+"\t");
						}
						System.out.println();
						System.out.println("============================================================");
						//반복문을 사용하여 검색행의 컬럼값을 반환받아 저장
						do {
							for(int i=1;i<=columnCount;i++) {
								String columnValue=rs.getString(i);
								//컬럼의 오라클 자료형이 [DATE]인 경우
								if(rsmd.getColumnTypeName(i).equals("DATE")) {
									columnValue=columnValue.substring(0,10);
								}
								//컬럼값이 없는 경우
								if(columnValue==null) {
									columnValue="  ";
								}
								//컬럼값 출력
								System.out.print(columnValue+"\t");
							}
							System.out.println();
						} while(rs.next());
					} else {//검색행이 없는 경우
						System.out.println("검색된 결과가 없습니다.");
					}
				} else {//INSERT,UPDATE,DELETE 명령을 전달하여 실행한 경우
					int rows=stmt.getUpdateCount();
					System.out.println(rows+"개의 행을 "+sql.substring(0,6).toUpperCase()+" 하였습니다.");
				}
				
				System.out.println();
			} catch (SQLException e) {
				//키보드로 입력받아 전달해 실행된 SQL 명령에 문제가 있는 경우 SQLException 발생
				System.out.println("SQL 오류 = "+e.getMessage());
			}
		}
				
		ConnectionFactory.close(con, stmt, rs);
		System.out.println("[메세지]SQLMinus 프로그램을 종료합니다.");
	}
}