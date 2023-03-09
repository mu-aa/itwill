package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

//STUDENT 테이블에 저장된 모든 학생정보를 검색하여 출력하는 JDBC 프로그램
public class ResultSetMetaDataApp {
	public static void main(String[] args) throws SQLException {
		Connection con=ConnectionFactory.getConnection();
		
		Statement stmt=con.createStatement();
		
		String sql="select * from student order by no";
		ResultSet rs=stmt.executeQuery(sql);
		
		while(rs.next()) {
			System.out.println("학번 = "+rs.getInt("no"));
			System.out.println("이름 = "+rs.getString("name"));
		}
		System.out.println("============================================================");
		
		
		//ResultSet.getMetaData() : 검색결과(ResultSet 객체)에 대한 부가적인 정보를
		//							저장하는 ResultSetMetaData 객체를 반환하는 메소드
		ResultSetMetaData rsmd=rs.getMetaData();
		
		//ResultSetMetaData.getColumnCount() : 검색행의 컬럼갯수를 반환하는 메소드
		int columnCount=rsmd.getColumnCount();
		System.out.println("검색행에 대한 컬럼 갯수 = "+columnCount);
		System.out.println("============================================================");

		
		for(int i=1; i<=columnCount;i++) {
			//ReslutSetMetaData.getColumnLabel(int columnIndex) : columnIndex 위치의 칼럼명을 반환
			String columnLabel=rsmd.getColumnLabel(i);
			
			//ReslutSetMetaData.isNullable(int column index) : columnIndex 위치의 컬럼에 대한 NULL 허용 유무값(0 or 1)을 반환
			int isNull=rsmd.isNullable(i);
			String nullResult="NULL";
			
			//ResultSetMetaData.columnNoNulls : NULL을 허용하지 않는 값을 표현하는 상수(Constant) : 0 또는 1 반환
			if(isNull==ResultSetMetaData.columnNoNulls) {
				nullResult="NOT NULL";
			}
			//ResultSetMetaData.getColumnTypeName(int columnIndex) : columnIndex 위치의 컬럼에 대한 오라클 자료형을 반환
			String columnTypename=rsmd.getColumnTypeName(i);
			
			//ResultSetMetaData.getColumnDisplaySize(int columnIndex) : columnIndex 위치의 컬럼에 대한 출력크기를 반환
			int columnDisplaySize=rsmd.getColumnDisplaySize(i);
			
			System.out.println("컬럼명 = "+columnLabel);
			System.out.println("NULL 허용 유무 = "+nullResult);
			System.out.println("컬럼 자료형 = "+columnTypename);
			System.out.println("컬럼 출력크기 = "+columnDisplaySize);			
			System.out.println("-----------------------------------------------");
		}
		
		
		ConnectionFactory.close(con, stmt, rs);
	
	}
}
