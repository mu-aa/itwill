package xyz.itwill.jdbc;

//Class 객체(Clazz)를 수동으로 제공받는 방법
//	1. Class.forName(String className) 메소드를 호출
//	2. Object.getClass() 메소드 호출 - 현재 사용하는 클래스에 대한 Clazz 반환
//	3. [클래스명.class] 형식으로 표현 - 직접 Clazz 호출

public class StaticBlockApp {
	public static void main(String[] args) throws ClassNotFoundException {
		
		/*
		//1. ClassLoader 프로그램에 의해 클래스(Class)를 읽어 메모리(Method area)에 저장
		//2. new 연산자가 메모리에 저장된 클래스(clazz)의 생성자(Constructor)를 호출하여
		//	 객체(Object, Instance) 생성 - Heap 영역의 메모리에 객체 생성
		//3. 생성된 객체의 메모리 주소(HashCode)를 전달받아 참조변수(Stack 영역)를 생성하여 저장
		StaticBlock staticBlock=new StaticBlock();
		
		//참조변수에 저장된 메모리 주소로 객체를 참조하여 메소드 호출 - 기능 구현
		staticBlock.display();
		*/
		
		//Class.forName(String className) : 문자열로 표현된 패키지가 포함된 클래스를 전달받아
		//ClassLoader 프로그램을 사용하여 해당 위치의 클래스를 읽어 메모리에 저장한 후 Clazz를 반환 - 수동 최초 1번
		//ㄴ ClassNotFoundException 발생 - 일반 예외이므로 반드시 예외처리해야만 에러 미발생
		Class.forName("xyz.itwill.jdbc.StaticBlock");
		
		/* 객체 생성, 메소드 호출을 정적 영역에 선언하면 최초 1회만 실행 - 싱글톤과 비슷한 효과
		StaticBlock staticBlock=new StaticBlock();
		staticBlock.display();
		*/
	}
}