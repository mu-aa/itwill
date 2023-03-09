package xyz.itwill.dto;

//MYUSER 테이블 : 회원정보를 저장하기 위한 테이블
//ㄴ SQL 명령은 대소문자를 구분하지 않아 식별자를 선언할 때 스네이크 표기법 사용

/*
이름        널?       유형           
--------- -------- ------------ 
USER_ID   NOT NULL VARCHAR2(50) 
USER_NAME          VARCHAR2(50) 
*/

//Java 자료형(Class, Interface, Enum)을 선언할 경우 파스칼 표기법 사용
public class MyUser {
	//Java 자료형을 제외한 식별자를 선언할 경우에는 카멜 표기법 사용
	private String userId;
	private String userName;
	
	public MyUser() {
		// TODO Auto-generated constructor stub
	}
	
	public MyUser(String userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}