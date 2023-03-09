package xyz.itwill.io;

import java.io.Serializable;

//객체 직렬화(Object Serialization) : 객체를 Byte 배열(원시데이터의 모임)로 변환하여
//                                    입력 또는 출력 처리하기 위한 기능을 제공

//객체 직렬화 클래스 선언 방법
//  1. Serializable 인터페이스를 상속받아 선언
//    ㄴ 객체의 //모든 필드값//을 byte 배열로 변환하여 입력 또는 출력 처리
//  2.Externalizable 인터페이스를 상속받아 선언
//    ㄴ writeExternal(ObjectOutput out) 메소드와 readExternal(ObjectInput in) 메소드를 오버라이드 하여 사용
//    ㄴ 오버라이드 선언된 메소드에서 //원하는 필드값//을 byte 배열로 변환하여 입력 또는 출력 처리
 
//회원정보(ID 이름 전화번호)를 저장하기 위한 클래스
//ㄴ 객체 단위로 입력 또는 출력 처리하는 클래스는 반드시 객체 직렬화 클래스로 선언
public class Member implements Serializable{
	private static final long serialVersionUID = 1L; //객체를 구분짓기 위한 식별자(시리얼UID)를 설정
	private String id;
	private String name;
	private String phone;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String id, String name, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "아이디 = "+id+", 이름 = "+name+", 전화번호 = "+phone;
	}	
}
