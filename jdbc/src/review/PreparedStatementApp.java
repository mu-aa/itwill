package review;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import xyz.itwill.jdbc.ConnectionFactory;

public class PreparedStatementApp {
	public static void main(String[] args) throws Exception {
		//키보드로 학생정보를 입력받아 STUDENT 테이블에 삽입하고
		//STUDENT 테이블에 저장된 모든 학생정보를 검색하여 출력하는 JDBC 프로그램
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		
		//키보드로 학생정보를 입력받아 저장
		System.out.print("학번 : ");
		int no=Integer.parseInt(in.readLine());
		
		System.out.print("이름 : ");
		String name=in.readLine();

		System.out.print("전화번호 : ");
		String phone=in.readLine();
		
		System.out.print("주소 : ");
		String address=in.readLine();
		
		System.out.print("생년월일(YYYY-MM-DD) : ");
		String birthday=in.readLine();
		System.out.println("\n=============================================================\n");
		
		
		//입력된 학생정보를 STUDENT TABLE에 삽입 처리
		Connection con=ConnectionFactory.getConnection();
		
		String sql="insert into student values(?, ?, ?, ?, ?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		
		pstmt.setInt(1, no);
		pstmt.setString(2, name);
		pstmt.setString(3, phone);
		pstmt.setString(4, address);
		pstmt.setString(5, birthday);
		
		int rows=pstmt.executeUpdate();
		System.out.println("[메시지]"+rows+"명의 정보 삽입 완료");
		System.out.println("\n=============================================================\n");
		
		
		//STUDENT 테이블에 저장된 모든 학생정보를 출력
		String sql2="select * from student order by no";
		pstmt=con.prepareStatement(sql2);
		
		ResultSet rs=pstmt.executeQuery();
		
		while(rs.next()) {
			System.out.println("학번 = "+rs.getInt("no"));
			System.out.println("이름 = "+rs.getString("name"));
			System.out.println("전화번호 = "+rs.getString("phone"));
			System.out.println("주소 = "+rs.getString("address"));
			System.out.println("생년월일 = "+rs.getString("birthday"));
		}
		
		ConnectionFactory.close(con, pstmt, rs);
		
		
		
	}
}


/*
package review;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import xyz.itwill.jdbc.ConnectionFactory;

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
		
		String sql="insert into student values(?, ?, ?, ?, ?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		
		pstmt.setInt(1, no);
		pstmt.setString(2, name);
		pstmt.setString(3, phone);
		pstmt.setString(4, address);
		pstmt.setString(5, birthday);
		
		int rows=pstmt.executeUpdate(); 
		
		System.out.println("[결과]"+rows+"명의 학생정보를 삽입 하였습니다.");
		System.out.println("\n=============================================================\n");
		
		
		//STUDENT 테이블에 저장된 모든 학생정보를 출력
		String sql2="select * from student order by no";
		pstmt=con.prepareStatement(sql2);
		
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

*/