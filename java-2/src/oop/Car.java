package oop;

// 클래스(Class) : 객체(Object)를 만들기 위한 자료형(참조형)  ---> 클래스:붕어빵틀   객체:붕어빵   붕어빵 안에 팥:메소드,필드 등
// ㄴ객체 대신 인스턴스(Instance)로 표현 가능
// 현실 세계에 존재하는 사물 또는 관념을 클래스라는 자료형으로 표현하여 객체로 구현 --> 객체 모델링

/* ● 클래스 선언 형식
// [public] class 클래스명 {
//
// 		필드(Field) : 대상의 *속성*을 표현하기 위해 선언된 변수(멤버변수) == 클래스에 적힌 지역변수, 대충 전역변수 느낌
// 		생성자(Constructor) : *객체 생성*을 목적으로 선언된 메소드 (new 연산자 뒤에 오는 그거)
//		★메소드(Method) : 대상의 *행위*를 명령으로 표현하기 위해 선언한 함수(멤버함수) -> 모든 필드를 쓸 수 있음
// }    => 필드에 필요한 값을 저장, 메소드로 필드값을 사용해 원하는 기능을 제공
//
										//생성자 호출							//참조변수를 사용한다==객체를 사용한다
 객체 생성 방법 : 클래스명 참조변수=new 클래스명(); 		//힙 영역에 저장돼 참조변수로 주소를 저장해야함
 ㄴ new 연산자로 클래스의 생성자를 호출하여 객체를 생성하고 참조변수에 객체의 주소를 저장
 ㄴ 참조변수에 저장된 객체의 필드 또는 메소드를 . 연산자로 접근하여 프로그램 작성
 
*/

// 클래스를 선언할 때 필드 또는 메소드에 접근지정자를 선언하여 접근 가능 유무를 설정
// ㄴ 접근지정자(Access Modifier) : private, package(default), public, protected
// ㄴ 클래스, 필드, 생성자, 메소드를 선언할 때 접근 유무를 저장하기 위한 키워드

// - private : 클래스 내부에서만 접근 가능, 클래스 외부에서 절대 접근 불가능
//   ㄴ 일반적으로 필드 선언 시 사용(객체로 필드에 직접적인 접근 차단)  ㅡㅡ>  은닉화(Data Hiding) 처리
// - public : 모든 패키지의 클래스에서 접근 가능하도록 설정하는 키워드
//   ㄴ 일반적으로 메소드 선언 시 사용 : 프로그램 작성에 필요한 모든 클래스에서 접근할 수 있도록
// - package : 
// - protected : 

// 자동차를 객체 모델링하여 작성된 클래스
// ㄴ속성 : 모델명, 엔진상태, 현재속도 -> 필드
// ㄴ행위 : 시동 On Off, 속도 Up Down, 이동 중지  -> 메소드

public class Car {  //클래스명 ㅡ> 파스칼 표기법
	
	//필드
	private String modelName; // 필드명 ㅡ> 카멜 표기법
	private boolean engineStatus;
	private int currentSpeed;
	
	//생성자 : 생성자 선언을 생략하면 매개변수가 없는 기본 생성자(Default Constructor)가 존재하는 것으로 처리

	//메소드 : 필드를 활용하여 명령으로 필요한 기능을 제공
	
	public void startEngine() { //시동켜기
		if(engineStatus==true) {
			System.out.println("이미 시동이 켜져있습니다.");
			return;
		}
		
		engineStatus=true;
		System.out.println(modelName+" engine start");
	}
	
	public void stopEngine() { //시동끄기
		if(engineStatus==false) {
			System.out.println("이미 시동이 꺼져있습니다.");
			return;
		}
		
		if(currentSpeed!=0) { //자동차가 달리고 있는데 시동끄면 멈추기
			speedZero();      //클래스에 선언된 메소드를 서로 호출 가능(코드 중복 최소화)
		}
		
		engineStatus=false;
		System.out.println(modelName+" engine stop");
	}
	
	public void speedUp(int speed) { //속도증가
		if(engineStatus==false) {
			System.out.println("현재 시동이 꺼져있습니다.");
			return;
		}
		
		if(currentSpeed+speed>150) { //현재 속도와 증가된 속도의 합이 최대속도보다 클 경우
			speed=150-currentSpeed;  //무조건 150이 안넘게
		}
		
		currentSpeed+=speed;
		System.out.println(modelName+"의 속도가 "+speed+" 증가 되었습니다.\n현재속도 : "+currentSpeed);
	}
	
	public void speedDown(int speed) { //속도감소
		if(engineStatus==false) {
			System.out.println("현재 시동이 꺼져있습니다.");
			return;
		}
		
		if(currentSpeed<speed) { //현재 속도보다 감소된 속도가 큰 경우
			currentSpeed=0;      //멈추기
		}
		
		currentSpeed-=speed;
		System.out.println(modelName+"의 속도가 "+speed+" 감소 되었습니다.\n현재속도 : "+currentSpeed);
	}
	
	public void speedZero() {
		if(engineStatus==false) { 
			System.out.println("현재 시동이 꺼져있습니다.");
			return;
		}
		
		currentSpeed=0;
		System.out.println(modelName+" stop");
	}
	
	
	// 은닉화 처리된 필드를 위해 필드값을 반환하는 Getter 메소드와 필드값을 변경(설정)하는 Setter 메소드를 선언
	
	// => 캡슐화(Encapsulation) : 표현대상을 속성(필드)과 행위(메소드)로 묶어 클래스로 선언
	// => 다른 의미 : 필드를 은닉화 처리하여 보호되어 사용할 수 있도록 설정하는 작업
	// => 캡슐화/은닉화 차이 : 은닉화가 더 세부적인 개념. 외부에서 필드에 바로 접근하지 못하게 막는 것(private와 setter getter를 사용)
	//                         캡슐화는 외부에서 실제로 구현되는 내부의 일이 드러나지 않게 하는 것
	
	//Getter 메소드 : 클래스 외부(프로그램)에서 필드값을 사용할 수 있도록 반환하는 메소드
	//ㄴ 형식) public 반환형 get필드명() { return 필드명; }
	public String getModelName() {
		return modelName;
	}
	
	// Setter 메소드 : 매개변수로 값을 입력받아 필드값을 변경하는 메소드
	// ㄴ 형식) public void set필드명(자료형 매개변수) { 필드명=매개변수; } 
	// ㄴ 매개변수에 전달되어 저장된 값에 대한 검증 가능
	public void setModelName(String modelName) {
		// this : 메소드 내부에서 클래스의 객체를 표현(지역변수, 매개변수랑 이름이 같을 때 구분할 수 있게 해줌)
		// ㄴ this 키워드를 사용하여 필드 표현
		this.modelName=modelName;
	}
	
	
	// 이클립스는 은닉화 선언된 필드에 Getter와 Setter 메소드를 생성하는 기능 제공
	// ㄴ 메뉴의 source -> generate getters and setters (단축키 Alt Shift S + R -> Alt A -> Alt R)
	public boolean isEngineStatus() {  //boolean 자료형은 get이 아닌 is
		return engineStatus;
	}
	public void setEngineStatus(boolean engineStatus) {
		this.engineStatus = engineStatus;
	}
	public int getCurrentSpeed() {
		return currentSpeed;
	}
	public void setCurrentSpeed(int currentSpeed) {
		this.currentSpeed = currentSpeed;
	}
}