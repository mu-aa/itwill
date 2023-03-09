package oop;


// ● this : 메소드에 숨겨져 있는 매개변수(키워드, 예약어)
// ㄴ this 매개변수의 자료형은 메소드가 선언된 클래스 ?
// ㄴ 메소드를 호출한 객체의 메모리 주소(HashCode)를 전달받아 저장하는 참조변수
// 형식) public 자료형 메소드명(클래스명 this) { 명령; 명령; ... }
//                              ㄴ객체의 주소를 전달받기 때문에 이 괄호안에 입력하면 객체로 매개변수 값이 전달됨
// 메소드에서 객체의 필드 또는 메소드를 사용하기 위해 this를 사용(위에랑 같은 말)
// this 키워드를 사용하지 않아도 /자동으로 객체의 필드 또는 메소드에 접근되어/ 사용 가능(안써도 된다는 말)

// 메소드 매개변수 공간 () 에 this 매개변수가 존재하는 이유(보이진 않지만)
// ㄴ 필드는 객체마다 메모리(Heap Area)에 따로 생성되지만
// ㄴ 메소드는 객체에 상관없이 메모리(Static-Method Area)에 하나만 저장된다 ㅡ 프로토타입 클래스(Prototype Class)
// ㄴ 메소드에서 필드를 접근할 때 this 키워드를 사용하여 객체를 구분 후 필드에 접근

// - this 키워드를 표현하여 사용하는 경우
// ㄴ 1. 메소드에서 매개변수의 이름이 필드의 이름과 동일할 경우 /필드를 표현/하기 위해
// ㄴ 2. 생성자에서 다른 생성자를 호출하여 초기화 작업을 하기 위해 		// 근데 거의 안함
// ㄴ 3. 이벤트 처리 프로그램 또는 다중 스레드 프로그램의 메소드에서 /객체 자체를 표현/하기 위해    <<??



// 회원정보(id,name,email)를 저장하기 위한 클래스
// VO(Value Object) 클래스 = 값 저장이 목적인 객체를 생성하기 위한 클래스
public class Member {
	
//	※필드 선언  ㅡㅡ>  기본값(0, false, null) 자동 저장
	private String id="NoId"; 
	private String name="NoName";     // 초기화 할 수 있긴한데 굳이? 기본값 쓰는게 나음
	private String email="NoEmail"; 
	
	
	
//	※생성자(Constructor) 선언
// 	ㄴ 생략 시 기본 생성자 제공, 하나라도 생성자 선언 시 기본 생성자 미제공
//	ㄴ 객체의 필드를 원하는 값으로 초기화하기 위해 선언
//	ㄴ 메소드 오버로드 가능
	
//	- 매개변수가 존재하지 않는 생성자(기본 생성자)
//	ㄴ 객체 생성 시 필드에는 기본값이 초기값으로 저장됨
//	ㄴ 기본 생성자를 선언하지 않으면 상속 시 문제가 발생함(필수)
//	ㄴ 이클립스를 사용하여 기본 생성자 자동 완성 (Ctrl + Space 맨 위에 constructor)
	public Member() {
		// TODO Auto-generated constructor stub
	  //this(값, 값, ...); this 키워드로 다른 생성자를 호출하는 명령 => 생성자에서만 사용 가능, 다른 명령보다 우선 실행 돼야함
	  //this("NoId","NoEmail","NoName"); 바로 아래에 있는 매개변수 3개짜리 생성자 호출해서 값 집어넣음  //근데 거의 안 씀
	}
	
//	- 매개변수가 존재하는 생성자(매개변수에 전달되어 저장된 값을 필드의 초기값으로 저장
//	ㄴ 객체 생성시 필드에 원하는 값이 저장되도록 생성자 작성
//	ㄴ ★★이클립스를 사용하여 매개변수가 있는 생성자 자동 완성(Alt Shift S + O)★★	
	public Member(String id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	
	
//	※ 메소드(Method) 선언 ㅡ VO 클래스라 getter setter 밖에 없음
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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	//필드값을 출력하는 메소드(임시적으로 만듦, VO 클래스엔 값만 저장돼야 함)
	public void display() {
		System.out.println("아이디 : "+id);
		System.out.println("이름 : "+name);
		System.out.println("이메일 : "+email);
	}	
}
