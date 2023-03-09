package xyz.itwill.bean;

//JavaBean 클래스 : 웹프로그램 실행을 위해 WAS 프로그램에 의해 자동 생성되어 관리되는 객체를 
//생성하기 위한 클래스 - useBean 태그에서 사용하기 위한 클래스
//ㄴ 웹프로그램 요청 시 전달된 값이 저장될 객체를 생성할 목적의 클래스

//JavaBean 클래스 작성규칙
//ㄴ 반드시 전달값의 이름과 동일한 이름으로 필드 선언
//ㄴ public 접근지정자로 선언된 기본생성자(매개변수가 없는 생성자)가 반드시 존재
//ㄴ 필드값을 반환하는 메소드(Getter)와 필드값을 변경하는 메소드(Setter)를 필드명을 기반으로 작성

//회원정보를 저장하기 위한 클래스 - VO 클래스
public class User {
	private String name;
	private String phone;
	private String address;
	
	public User() {
		// TODO Auto-generated constructor stub
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}