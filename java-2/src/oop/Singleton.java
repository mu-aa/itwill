package oop;

// 싱글톤 디자인 패턴을 적용하여 작성된 클래스 == 싱글톤 클래스(Singleton Class)
// ㄴ 프로그램에 객체를 하나만 제공하기 위한 목적의 클래스를 작성하기 위해 사용
// ㄴ ★ 디자인 패턴 : 많이 쓰여지는 프로그램 패턴(공부하면 좋음)
public class Singleton {
	
	// 클래스의 객체를 저장하기 위한 시스템 필드 선언
	// ㄴ static 지정자를 사용하여 정적 필드로 선언
	// ㄴ 시스템 필드 : 클래스 내부에서만 사용될 값을 저장하기 위한 필드(==private)
	// ㄴ 그래서 Getter 메소드와 Setter 메소드를 선언하지 않음
	// ㄴ 일반적인 필드와 구분하기 위해 필드명이 언더바(_)로 시작되도록 작성하는 것을 권장
	private static Singleton _instance;
	
	//생성자를 은닉화 선언 - 클래스 외부에서 생성자에 접근하지 못하게 설정(객체 생성 불가능) == private  -->싱글톤 핵심
	private Singleton() {
		// TODO Auto-generated constructor stub
	}
											          // 최초 1회
	static {  // 정적 영역(Static Block) : 클래스가 메모리에 생성(클래스 로딩)된 후 자동으로 실행될 명령을 작성하는 영역
		      // 정적 필드 또는 정적 메소드만 사용 가능
		_instance=new Singleton(); // 클래스로 객체를 생성하여 시스템 필드에 저장 - 프로그램에서 하나의 객체만 생성하여 사용	
		}
	
	public static Singleton getInstance() {
		return _instance;  // 미리 생성되어 시스템 필드에 저장된 객체를 반환하는 정적 메소드
	}
	
	//인스턴스 메소드
	public void display() {
		System.out.println("Singleton 클래스의 display() 메소드 호출");
	}
	
	
}//class
