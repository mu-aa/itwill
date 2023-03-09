package xyz.itwill.dbcp;

import java.sql.Connection;

//DBCP(DataBase Connection Pool)
//ㄴ 다수의 Connection 객체를 미리 생성하여 저장하고 Connection 객체를 반환하는 기능을 제공하는 클래스
//ㄴ Connection 객체를 미리 생성하여 사용하므로 JDBC 프로그램에 실행 속도 증가
//ㄴ Connection 객체를 생성하기 위한 정보의 변경 용이 - 유지보수의 효율성 증가
//ㄴ Connection 객체의 갯수를 제한 가능
public class ConnectionPoolApp {
	public static void main(String[] args) throws Exception {
		//ConnectionPool 클래스의 생성자가 Private 접근자를 사용해(은닉화) new 생성자를 이용한 객체 생성이 불가능
		//ConnectionPool cp=new ConnectionPool();
		
		//ConnectionPool 객체를 반환받아 저장
		//ㄴ ConnectionPool 객체에는 다수의 Connection 객체가 미리 생성되어 저장
		//ㄴ 프로그램에서 ConnectionPool 객체가 하나만 제공되도록 Singleton Class로 작성 되어있음
		ConnectionPool cp=ConnectionPool.getInstance();
		
		//ConnectionPool 객체에 저장된 Connection 객체 중 하나를 반환받아 저장
		Connection con1=cp.getConnection();
		System.out.println("con1 = "+con1);
		
		//사용한 Connection 객체를 ConnectionPool 객체에게 다시 반납 처리
		cp.freeConnection(con1);		
	}
}
