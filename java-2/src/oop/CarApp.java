package oop;

//Car 클래스를 사용해 작성된 프로그램
public class CarApp {
	public static void main(String[] args) {
		
		//Car 클래스로 객체를 생성하여 참조변수에 저장
		//하나의 클래스로 서로 다른 객체를 여러 개 생성 가능
		//객체를 생성하면 객체의 필드에는 기본 값(0, false, null)이 자동 저장된다.
		
//    클래스 참조변수 new연산자 클래스명		 ★ 참조변수를 사용한다 == 객체를 사용한다 고 표현
		Car   carOne =   new      Car();
		Car carTwo=new Car();
		Car carThree=carTwo;  // 참조변수에 저장된 객체를 다른 참조변수에 저장 할 수도 있음
		
		
		System.out.println("carOne = "+carOne);		
		System.out.println("carTwo = "+carTwo);
		System.out.println("carThree = "+carThree);
		System.out.println("\n=======================================\n");

		
//		carOne.modelName="Tico";     //필드값 변경 (필드값이 변동되면 코드가 망가짐. 그걸 막기위해 접근지정자 private 사용)
		carOne.setModelName("Tico"); //접근지정자로 막혀서 setter 메소드로 필드값 변경
		carOne.setEngineStatus(true);
		carOne.setCurrentSpeed(100);
//		System.out.println("첫번째 자동차의 모델명 = "+carOne.modelName); 
		System.out.println("첫번째 자동차의 모델명 = "+carOne.getModelName()); // 접근지정자로 막혀서 getter 메소드로 필드값 반환
		System.out.println("첫번째 자동차의 엔진상태 = "+carOne.isEngineStatus());
		System.out.println("첫번째 자동차의 현재속도 = "+carOne.getCurrentSpeed());
		System.out.println("\n=======================================\n");

		
		carTwo.setModelName("Morning");
		carTwo.setEngineStatus(false);
		carTwo.setCurrentSpeed(0);
		System.out.println("두번째 자동차의 모델명 = "+carTwo.getModelName());
		System.out.println("두번째 자동차의 엔진상태 = "+carTwo.isEngineStatus());
		System.out.println("두번째 자동차의 현재속도 = "+carTwo.getCurrentSpeed());
		System.out.println("\n=======================================\n");
		
		
//		carTwo.currentSpeed=1000;  필드값이 오류가 발생할 수 있으니 숨겨놓아야 함 - private 접근 지정자로 해결
		carTwo.startEngine();
		carTwo.speedUp(50);
		carTwo.speedUp(30);
		carTwo.speedDown(40);
		carTwo.speedZero();
		carTwo.stopEngine();
		System.out.println("\n=======================================\n");
	}
}
