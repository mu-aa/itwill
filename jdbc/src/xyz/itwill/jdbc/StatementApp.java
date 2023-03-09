package xyz.itwill.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

//Statement 객체 : 현재 접속중인 DBMS 서버에 SQL 명령을 전달하여 실행하기 위한 기능을 제공하는 객체
//키보드로 학생정보를 입력받아 STUDENT 테이블에 삽입하고 STUDENT 테이블에 저장된 모든 학생정보를 검색하여 출력하는 JDBC 프로그램
public class StatementApp {
	public static void main(String[] args) throws Exception {
		/*
		//키보드로 학생정보를 입력받기 위한 입력스트림 생성
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
		
		Statement stmt=con.createStatement();
		
		String sql1="insert into student values("+no+", '"+name+"', '"+phone+"', '"+address+"', '"+birthday+"')";
		int rows=stmt.executeUpdate(sql1);
		
		System.out.println("[결과]"+rows+"명의 학생정보를 삽입 했습니다.");
		System.out.println("\n=============================================================\n");
		
		
		//STUDENT 테이블에 저장된 모든 학생정보를 검색하여 출력
		String sql2="select * from student order by no";
		ResultSet rs=stmt.executeQuery(sql2);
		
		System.out.println("<<학생정보 출력>>");
		
		while(rs.next()) {
			System.out.println("학번 = "+rs.getInt("no"));
			System.out.println("이름 = "+rs.getString("name"));
			System.out.println("전화번호 = "+rs.getString("phone"));
			System.out.println("주소 = "+rs.getString("address"));
			System.out.println("생일 = "+rs.getString("birthday"));
		}
		
		ConnectionFactory.close(con, stmt, rs);
		System.out.println("\n=============================================================\n");
		*/
		
		
		//키보드로 이름을 입력받아 STUDENT 테이블에 저장된 학생정보 중 해당 이름의 학생정보를 검색하여 출력하는 프로그램
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("<<학생정보 검색>>");
		
		System.out.print("이름 입력 : ");
		String name=in.readLine();
		System.out.println("\n=============================================================\n");
		
		
		//STUDENT 테이블에 저장된 학생정보 중 해당 이름의 학생정보를 검색하여 출력
		Connection con=ConnectionFactory.getConnection();
		
		Statement stmt=con.createStatement();
		
		String sql="select * from student where name='"+name+"' order by no"; //오라클 문자값 표현을 위해 ' ' 도 작성
		ResultSet rs=stmt.executeQuery(sql);
		
		System.out.println("<<검색결과>>");
		if(rs.next()) {
			do {
				System.out.println("학번 = "+rs.getInt("no"));
				System.out.println("이름 = "+rs.getString("name"));
				System.out.println("전화번호 = "+rs.getString("phone"));
				System.out.println("주소 = "+rs.getString("address"));
				System.out.println("생일 = "+rs.getString("birthday"));
			} while(rs.next());
		} else {
			System.out.println("검색 결과가 없습니다.");
		}
	
		ConnectionFactory.close(con, stmt, rs);
		System.out.println("\n=============================================================\n");
	}
}
