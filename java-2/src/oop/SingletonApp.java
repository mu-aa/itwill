package oop;

public class SingletonApp {
	public static void main(String[] args) {
	
//		Singleton my=new Singleton();
//		my.display();
//		ㄴ new 연산자로 생성자를 호출하여 객체 생성 - 객체를 여러 개 생성해 사용 가능
//		ㄴ 생성된 객체의 해시코드를 참조변수에 저장하여 그것을 참조해 메소드 호출

		
		
//		싱글톤 클래스는 생성자가 은닉화되어 new 연산자로 객체 생성 불가능
//		클래스 생성 시 미리 생성되어 시스템 필드에 저장된 객체를 반환하는 메소드 호출
//		객체를 하나만 제공받아 사용
		/*
		Singleton my=Singleton.getInstance();
		Singleton my2=Singleton.getInstance();
		
		System.out.println("my = "+my);
		System.out.println("my2 = "+my2); // 아무리 많이 만들어도 객체는 하나라서 결과(객체의 해시코드)가 같음
		my.display();
		my2.display();
		System.out.println("\n===================================\n");
		*/
		
		// 싱글톤 클래스는 객체를 반환받아 메소드를 직접 호출하여 사용하는 것을 권장(참조변수 사용하지 않는 것을 권장)
		System.out.println("my = "+Singleton.getInstance());
		Singleton.getInstance().display();
		System.out.println("\n===================================\n");
		
	}//main
}//class
