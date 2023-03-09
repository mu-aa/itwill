package realization;

// ┌파스칼 표기법
//인터페이스(Interface) : 현실에 존재하는 대상을 클래스보다 추상적으로 표현하기 위한 Java 자료형(참조형)   => 개념을 제공
//ㄴ 상수 필드(Construct Field), 추상 메소드(Abstract Method)로만 선언 가능
//ㄴㄴ jdk8 이상에서는 기본 메소드(Default Method)와 정적 메소드(Static Method)도 선언 가능

//형식) public interface 인터페이스명 {
//			자료형 필드명=값;  //상수 필드(public static final 생략 가능, 모두 상수 필드이기 때문에)
//			...
//			반환형 메소드명(자료형 매개변수명, ...);  //추상 메소드(public abstract 생략 가능, 모두 추상 메소드이기 때문에)
//			...
//	}

// 인터페이스는 클래스에게 상수 필드 또는 추상 메소드를 상속 - ★다중 상속 가능
// 형식) public class 클래스명 implements 인터페이스명, 인터페이스명, ... {  }
// ㄴ ★인터페이스를 상속받은 자식 클래스는 무조건 상속받은 인터페이스의 모든 추상 메소드를 오버라이드 선언 해야함
// ㄴ 인터페이스로 객체 생성X, 참조변수는 생성O, 자식 클래스의 객체 저장O

// 인터페이스는 다른 인터페이스를 상속 받을 수 있음(다중 상속 가능)
// 형식) public interface 인터페이스명 extends 인터페이스명, 인터페이스명, ... {  }

// 클래스가 인터페이스를 상속받는 이유
//  1. 클래스의 단일 상속 관련 문제를 일부 보완
//   ex) public class 늑대인간 extends 인간, 늑대  => X
//       public class 늑대인간 extends 인간, implements 늑대  => O
//       public class 흡혈늑대인간 extends 인간, implements 늑대,흡혈귀  => O
//  2. 클래스에 대한 작업 지시서 역할
//	 ex) TV, Radio, Smart Phone => 소리 증가, 감소와 같은 겹치는 기능에 대해 인터페이스 제공
//                              => 인터페이스를 상속받은 모든 자식 클래스는 동일한 형태의 메소드가 선언되도록 규칙을 제공
//								=> 클래스 간의 결합도(연관성)를 낮춰 시스템 변경 시 유지보수의 효율성 증가

public class WolfHumanApp {
	public static void main(String[] args) {
		
		WolfHuman wolfHuman=new WolfHuman();
		
		wolfHuman.speak();
		wolfHuman.walk();
		wolfHuman.smile();
		wolfHuman.change();
		wolfHuman.cryLoudly();
		wolfHuman.fastWalk();
		System.out.println("\n==================================================\n");

		
		//부모클래스를 참조변수를 생성하여 자식 클래스의 객체 저장
		//참조변수는 기본적으로 부모클래스의 메소드만 호출 가능
		//ㄴ 객체 형변환을 이용하면 참조변수로 자식클래스의 메소드도 호출 가능
		Human human=new WolfHuman();
		
		human.smile();
		human.speak();
		human.walk();
		System.out.println("\n==================================================\n");
		
		
		//명시적 객체 형변환을 이용하여 자식 클래스의 메소드를 호출
		((WolfHuman)human).change();
		System.out.println("\n==================================================\n");
		
		
		//인터페이스로 참조변수를 선언하여 자식클래스의 객체 저장
		//Wolf wolf=new WolfHuman();
		//자식 클래스가 같은 클래스와 인터페이스(자식이 같은 부모 자료형)는 명시적 객체 형변환을 이용해 자식 클래스의 객체 저장 가능
		Wolf temp=(Wolf)human;//  ==  Wolf wolf=new WolfHuman();
		
		//묵시적 객체 형 변환에 의해 자동으로 자식 클래스의 메소드 호출
		temp.cryLoudly();
		temp.fastWalk();
		System.out.println("\n==================================================\n");
		
		
		
		
		
	}//main
}//class
