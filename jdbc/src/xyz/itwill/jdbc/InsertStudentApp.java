package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//JDBC(Java DataBase Connectivity) : Java를 이용하여 DBMS에 접속해 SQL 명령을 전달, 실행하기 위한 기능을 제공하는 클래스(또는 인터페이스)

//java.sql 패키지 : JDBC 기능을 작성하기 위한 인터페이스(또는 클래스)가 선언된 패키지
//ㄴ java.sql 패키지의 JDBC 기능은 인터페이스로 제공 - DBMS의 종류가 다양하므로 클래스로 제공 불가능
//ㄴ DBMS 회사의 웹사이트에서 JDBC 기능의 클래스(Driver)를 배포하여 제공
//ㄴ JDBC 드라이버가 포함된 라이브러리를 다운로드 받아 프로젝트에 빌드 처리해야만 JDBC 프로그램 작성 가능

//Oracle DBMS를 사용한 JDBC 프로그램 작성
//ㄴ 1. Oracle JDBC Driver 관련 라이브러리 파일 다운로드 - https://www.oracle.com
//	 	ㄴ ojdbc11.jar 다운로드 - JDK 버전과 호환성 주의
//ㄴ 2. Oracle JDBC Driver 관련 라이브러리 파일(ojdbc11.jar)을 프로젝트 폴더에 붙여넣기
//ㄴ 3. 프로젝트의 폴더에 저장된 라이브러리 파일을 프로젝트에서 사용할 수 있도록 연결(빌드 처리)
//	 	ㄴ 라이브러리의 클래스(또는 인터페이스)를 프로젝트에서 사용 가능하도록 설정
//	 	ㄴ 프로젝트 우클릭 -> Properties(속성) -> Java Build Path -> Libraries 탭 선택 -> classpath -> Add jars -> 파일 선택

//STUDENT 테이블 : 학번(PRIMARY KEY), 이름, 전화번호, 주소, 생년월일
//STUDENT 테이블에 학생 정보를 삽입하는 JDBC 프로그램
public class InsertStudentApp {
	public static void main(String[] args) {
		//JDBC 관련 객체를 저장하기 위한 참조변수는 try 영역 외부에 선언
		//ㄴ try 영역을 표함한 모든 영역에서 참조변수를 이용해 객체 사용 가능
		Connection con=null;		
		Statement stmt=null;
		
		try {
			//●1. OracleDriver 클래스를 객체로 생성하여 DriverManager 클래스의 JDBC 객체로 등록
			//JDBC Driver : DriverManager 클래스에 등록된 다수의 Driver 객체 
			//ㄴ Driver 객체 : DBMS 서버에 접속하여 SQL 명령을 전달하기 위한 기능을 제공하는 객체
			//DriverManager 클래스 : Driver 객체를 관리하기 위한 기능을 제공하는 클래스
			//ㄴ DriverManager.registerDriver(Driver driver) : Driver 객체를 전달받아
			//	 DriverManager 클래스가 관리할 수 있는 JDBC Driver로 등록하는 메소드
			//	 ㄴ 동일한 Driver 객체가 DriverManager 클래스에 여러 개 등록 가능 - 불필요한 드라이버 등록 가능
			//DriverManager.registerDriver(new OracleDriver()); - 비권장
			
			//Class.forName() : 메소드를 호출해 ClassLoader 프로그램을 수동으로 실행, OracleDriver 클래스를 읽어 메모리에 저장
			//ㄴ OracleDriver 클래스의 정적 영역에서 OracleDriver 클래스의 객체를 생성하여
			//	 DriverManager 클래스의 JDBC Driver로 등록 처리(최초 1회)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//●2. DriverManager 클래스에 등록된 JDBC Driver 객체를 이용하여 DBMS 서버에 접속하여 Connection 객체를 반환받아 저장
			//ㄴ Connection 객체 : DBMS 서버에 접속된 정보를 저장하기 위한 객체 == DBMS 세션
			//DriverManager.getConnection(String url, String username, String password)
			//ㄴ DriverManager 클래스에 등록된 JDBC Driver 객체를 사용하여 DBMS 서버에 접속하고,
			//ㄴ 접속된 DBMS 서버의 정보가 저장된 Connection 객체 반환
			//ㄴ 접속 URL 주소의 프로토콜을 이용하여 특정 DBMS 서버에 접속하여 SQL 명령 전달
			//URL(Uniform Resource Locator) : 인터넷에 존재하는 자원의 위치를 표현하는 주소
			//ㄴ 형식) Protocol:Servername:Port:Resource
			//Oracle DBMS 서버에 접속하기 위한 URL 주소
			//ㄴ 형식) jdbc:oracle:thin:@ServerName:Port:SID
			//JDBC 관련 클래스의 메소드를 호출하면 반드시 SQLException 발생
			//ㄴ SQLException : DBMS 서버 관련 문제가 있는 경우 발생(일반 예외 - 반드시 예외 처리)
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String username="scott";
			String password="tiger";
			con=DriverManager.getConnection(url, username, password);
			
			//●3. Connection 객체로부터 SQL 명령을 전달할 수 있는 Statement 객체를 반환받아 저장
			//Connection.createStatement() : SQL 명령을 전달할 수 있는 Statement 객체를 생성하여 반환하는 메소드
			//Statement 객체 : SQL 명령을 접속 DBMS 서버에 전달하여 실행하기 위한 객체
			stmt=con.createStatement();
			
			//●4. Statement 객체를 이용하여 SQL 명령을 전달하여 실행하고 실행 결과를 반환받아 저장
			//Statement.executeUpdate(String sql) : DML 명령 또는 DDL 명령을 전달하여 실행하기 위한 메소드(int 반환)
			//ㄴ 실행 결과로 조작행의 갯수(int) 반환
			//Statement.executeQuery(String sql) : SELECT 명령을 전달하여 실행하기 위한 메소드
			//ㄴ 실행결과로 검색행이 저장된 ResultSet 객체 반환
//			String sql="insert into student values(1000, '홍길동', '010-1234-5678','서울시 강남구', '00/01/01')";  INSERT는 중복 불가능
//			String sql="insert into student values(2000, '임꺽정', '010-2345-6789','수원시 월정구', '02/05/08')";
			String sql="insert into student values(4000, '일지매', '010-1357-2468','수원시 월정구', '01/02/03')";
			
			int rows=stmt.executeUpdate(sql);
			
			//●5. 반환받은 SQL 명령의 실행결과를 이용하여 출력 - 결과값 반환
			System.out.println("[메세지]"+rows+"명의 학생 정보를 삽입 하였습니다.");
			} catch (ClassNotFoundException e) {
				System.out.println("OracleDriver 클래스를 찾을 수 없습니다.");
			} catch (SQLException e) {
				System.out.println("JDBC 관련 오류 = "+e.getMessage());
			} finally {
				//●6. JDBC 관련 객체의 close(). 메소드를 호출하여 객체 제거
				//ㄴ 객체의 제거 순서는 생성의 역순으로 제거
				try {
					//Statement.close() : Statement 객체 제거
					//참조변수에 객체가 저장되어 있는 경우에만 close() 메소드 호출 - NullPointException 발생 방지
					if(stmt!=null) stmt.close();
					//ㄴ Connection.close() : Connection 객체 제거 - DBMS 서버 접속 종료
					//참조변수에 객체가 저장되어 있는 경우에만 close() 메소드 호출 - NullPointException 발생 방지
					if(con!=null) con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	}
}