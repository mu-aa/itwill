package xyz.itwill.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//PreparedStatement 객체 : 현재 접속중인 DBMS 서버에 SQL 명령을 전달하여 실행하기 위한 기능을 제공하는 객체
public class PreparedStatementApp {
	public static void main(String[] args) throws Exception {
		//키보드로 학생정보를 입력받아 STUDENT 테이블에 삽입하고
		//STUDENT 테이블에 저장된 모든 학생정보를 검색하여 출력하는 JDBC 프로그램
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		
		//키보드로 학생정보를 입력받아 저장
		System.out.println("<<학생정보 입력>>");
		
		System.out.print("학번 입력 : ");
		int no=Integer.parseInt(in.readLine()); //키보드로 입력받은 문자열을 정수로 변경해 저장
		System.out.print("이름 입력 : ");
		String name=in.readLine();
		System.out.print("전화번호 입력 : ");
		String phone=in.readLine();
		System.out.print("주소 입력 : ");
		String address=in.readLine();
		System.out.print("생년월일 입력 : ");
		String birthday=in.readLine();
		System.out.println("\n=============================================================\n");
		
		
		//입력된 학생정보를 STUDENT TABLE에 삽입 처리
		Connection con=ConnectionFactory.getConnection();
		
		//Connection.prepareStatement(String sql) : Connection 객체로부터 SQL 명령이 저장된 prepareStatement 객체를 반환하는 메소드
		//ㄴ PreparedStatement 객체에 저장된 SQL 명령에서는 ? 기호(InParameter) 사용
		//InParameter : Java 변수값을 제공받아 SQL 명령의 문자값으로 표현하기 위한 기능
		//ㄴ 반드시 모든 InParameter에 Java 변수값을 전달받아야 SQL 명령 완성
		//PreparedStatement.setXXX(int parameterIndex, XXX value)
		//ㄴ PreparedStatement 객체에 저장된 SQL 명령의 Inparameter에 Java 변수값을 전달하는 클래스
		//ㄴ XXX : Java 자료형
		//ㄴ parameterIndex : InParameter의 위치값(첨자, Index) - 1부터 1씩 증가
		//ㄴ 반드시 setXXX() 메소드를 호출하여 모든 InParameter에 Java 변수값을 전달
		String sql="insert into student values(?, ?, ?, ?, ?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		
		pstmt.setInt(1, no);
		pstmt.setString(2, name);
		pstmt.setString(3, phone);
		pstmt.setString(4, address);
		pstmt.setString(5, birthday);
		
		//PreparedStatement.executeUpdate() : DML 명령 또는 DDL 명령을 전달하여 실행하는 메소드(조작행의 갯수를 정수값으로 반환)
		int rows=pstmt.executeUpdate(); 
		
		System.out.println("[결과]"+rows+"명의 학생정보를 삽입 하였습니다.");
		System.out.println("\n=============================================================\n");
		
		
		//STUDENT 테이블에 저장된 모든 학생정보를 출력
		
		String sql2="select * from student order by no";
		pstmt=con.prepareStatement(sql2);
		
		//PreparedStatement.executeQuery() : SELECT 명령을 전달하여 실행하는 메소드(모든 검색행이 저장된 ResultSet 객체 반환)
		ResultSet rs=pstmt.executeQuery();
		
		if(rs.next()) {
			do {
				System.out.println("학번 = "+rs.getInt("no"));
				System.out.println("이름 = "+rs.getString("name"));
				System.out.println("전화번호 = "+rs.getString("phone"));
				System.out.println("주소 = "+rs.getString("address"));
				System.out.println("생일 = "+rs.getString("birthday"));
				System.out.println("-----------------------------");
			} while(rs.next());
		} else {
			System.out.println("검색 결과가 없습니다.");
		}
		
		ConnectionFactory.close(con);
	}
}
