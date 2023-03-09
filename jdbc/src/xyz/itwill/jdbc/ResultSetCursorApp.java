package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetCursorApp {
	public static void main(String[] args) throws SQLException {
		Connection con=ConnectionFactory.getConnection();
		
		//Connection.createStatement() : Statement 객체를 생성하여 반환하는 메소드
		//Statement 객체 : SQL 명령을 현재 접속중인 DBMS 서버에 전달하여 실행하는 기능을 제공하는 객체
		Statement stmt=con.createStatement();
		
		String sql="select * from student order by no";
		
		//Statement.executeQuery(String sql) : SELECT 명령을 전달하여 실행하고 검색결과를 ResultSet 객체로 반환하는 메소드
		//ㄴ ResultSet 객체는 내부적으로 Cursor를 사용하여 행 단위로 처리
		//ㄴ ResultSetCursor는 다음 행으로만 이동 가능하며 커서 위치의 행에 대한 조작 불가능
		ResultSet rs=stmt.executeQuery(sql);
		
		//ResultSet.next() : ResultSetCursor를 다음행으로 이동시키는 메소드
		//ㄴ 이동된 커서 위치에 처리행이 없는 경우 [false], 있는 경우 [true] 반환
		while(rs.next()) {
			//ResultSet.getRow() : ResultSetCursor가 위치한 처리행의 행 번호(RowIndex)를 반환
			//ResultSet.getXXX(string columnLabel) : ResultSetCursor가 위치한 처리행의 컬럼값을 반환
			System.out.println(rs.getRow()+"행 : 학번 = "+rs.getInt("no")+", 이름 = "+rs.getString("name"));
		}
		
		ConnectionFactory.close(con, stmt, rs);
		
		System.out.println("\n========================================================\n");
		
		
		con=ConnectionFactory.getConnection();
		
		//Connection.createStatement(int resultSetType, int resultSetConcurrency)
		//ㄴ Statement 객체를 생성하여 반환하는 메소드
		//ㄴ 매개변수에 전달되는 값에 따라 Statement 객체로 생성되는 ResultSet 객체의 사용방법을 다르게 설정 가능
		//ㄴ ResultSetCursor의 이동 또는 ResultSetCursor가 위치한 처리행에 대한 조작 가능
		//resultSetType : ResultSetCursor의 이동관련 속성값(ResultSet 인터페이스의 상수)을 전달하여 설정
		//ㄴ ResultSet.TYPE_FORWARD_ONLY : ResultSet 커서를 다음 행으로만 이동 가능
		//ㄴ ResultSet.TYPE_SCROLL_INSENSITIVE : ResultSet 커서를 원하는 행으로 이동 가능 - 데이터베이스 변경 미반영
		//ㄴ ResultSet.TYPE_SCROLL_SENSITIVE : ResultSet 커서를 원하는 행으로 이동 가능 - 데이터베이스 변경 반영
		//resultSetConcurrency : ResultSetCursor 위치의 처리행의 조작 관련 속성값(ResultSet 인터페이스의 상수)을 전달하여 설정
		//ㄴ ResultSet.CONCUR_READ_ONLY : ResultSetCursor 위치의 처리행에 대한 조작 불가능 - 기본
		//ㄴ ResultSet.CONCUR_UPDATABLE : ResultSetCursor 위치의 처리행에 대한 조작 가능
		stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); //데이터베이스 변경 불가능
		
		sql="select * from student order by no";
		//ResultSetCursor는 ResultSet 객체의 BOF(Befor Of File) 영역에 위치
		rs=stmt.executeQuery(sql);
		
		//ResultSet.first() : ResultSetCursor를 첫번째 행으로 이동하는 메소드
		rs.first();
		System.out.println(rs.getRow()+"행 : 학번 = "+rs.getInt("no")+", 이름 = "+rs.getString("name"));
		
		//ResultSet.last() : ResultSetCursor를 마지막 행으로 이동하는 메소드
		rs.last();
		System.out.println(rs.getRow()+"행 : 학번 = "+rs.getInt("no")+", 이름 = "+rs.getString("name"));
		
		//★ResultSet.absolute(int index) : ResultSetCursor를 원하는 행으로 이동하는 메소드
		rs.absolute(2);
		System.out.println(rs.getRow()+"행 : 학번 = "+rs.getInt("no")+", 이름 = "+rs.getString("name"));
		System.out.println("\n========================================================\n");

		
		//ResultSet.beforeFirst() : ResultSetCursor를 BOF 영역으로 이동하는 메소드
		rs.beforeFirst();
		while(rs.next()) {
			System.out.println(rs.getRow()+"행 : 학번 = "+rs.getInt("no")+", 이름 = "+rs.getString("name"));
		}
		System.out.println("\n========================================================\n");
		
		
		//ResultSet.afterlast() : ResultSetCursor를 EOF 영역으로 이동하는 메소드
		rs.afterLast();
		
		//ResultSet.previous() : ResultSetCursor를 이전행으로 이동하는 메소드
		while(rs.previous()) {
			System.out.println(rs.getRow()+"행 : 학번 = "+rs.getInt("no")+", 이름 = "+rs.getString("name"));
		}
		ConnectionFactory.close(con, stmt, rs);
		System.out.println("\n========================================================\n");
		
		con=ConnectionFactory.getConnection();
		
		//●ResultSet에서 행 조작 가능하게 설정 (TYPE_SCRILL_SENSITIVE, CONCUR_UPDATABLE)
		stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE); //데이터베이스 변경 가능
		
		//ResultSetCursor가 위치한 처리행에 대한 조작이 가능한 경우(CONCUR_UPDATABLE) SELECT 명령의 검색대상으로 [*] 사용 불가능
		sql="select no, name, phone, address, birthday from student order by no";
		rs=stmt.executeQuery(sql);

		/*****변경
		rs.absolute(2);
		
		//ResultSet.updateXXX(String columnLabel, XXX columnValue)
		//ㄴ ResultSetCursor가 위치한 처리행의 컬럼값을 변경하는 메소드
		//ㄴ XXX : Java 자료형
		rs.updateString("name", "임걱정");
		
		//ResultSet.updateRow() : 변경 행을 ResultSet 객체에 적용하는 메소드
		//ㄴ 실제 테이블의 행의 컬럼값도 변경됨
		rs.updateRow();
		*****/
		
		
		/*****삽입
		rs.absolute(3);
		
		//ResultSet.moveToInsertRow() : ResultSetCursor가 위치에 새로운 행을 삽입하는 메소드
		//ㄴ 삽입행 다음에 존재하는 기존행은 자동으로 다음행으로 이동
		rs.moveToInsertRow();
		
		// 빈 컬럼에 값 UPDATE
		rs.updateInt("no", 4000); 
		rs.updateString("name", "일지매");
		rs.updateString("phone", "010-9876-5432");
		rs.updateString("address", "부산시 사하구");
		rs.updateString("birthday", "2000-12-31");
		
		//ResultSet.insertRow() : 삽입행을 ResultSet 객체에 적용하는 메소드
		//ㄴ 실제 테이블의 행에 대한 삽입 처리
		rs.insertRow();
		*****/
		
		
		//삭제
		rs.absolute(4);
		//ResultSet.deleteRow() : ResultSetCursor가 위치한 처리행을 삭제하여 ResultSet 객체에
		rs.deleteRow();
		//
		
		
		//출력
		rs.beforeFirst();
		while(rs.next()) {
			System.out.println(rs.getRow()+"행 : 학번 = "+rs.getInt("no")+", 이름 = "+rs.getString("name"));
		}
		ConnectionFactory.close(con, stmt, rs);
		System.out.println("\n========================================================\n");
	}
}
