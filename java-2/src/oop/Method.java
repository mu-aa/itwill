package oop;

/*
 메소드(Method) : 필드를 사용하여 필요한 기능을 제공하기 위한 명령들의 모임 . . . 카멜 표기법으로 작성
 
		                  //반환형(ReturnType)
 자료형(int 등..) 메소드명(자료형 변수명, 자료형 변수명, ...){
				명령;
				명령; (값을 입력, 출력하지 않음) -> 프로그램마다 입 출력 방식이 달라서 호환이 안 됨
				명령;
				...
	}
*/
//  ┌ 메소드의 출력기능
// 반환형(ReturnType) : 메소드를 호출하여 얻을 수 있는 결과값의 자료형
// ※ void(무 반환형) : 메소드를 호출하여 얻을 수 있는 결과값이 없는 경우 사용하는 자료형 
// 매개변수(Parameter == 인자 : Argument) : 메소드의 명령을 실행하기 위해 메소드를 호출 시 값을 전달받아 저장하기 위한 변수
//  ㄴ 메소드의 입력기능

// return : 메소드를 종료하는 키워드(제어문)
// 형식1) if(조건식) return; => 조건식의 결과가 참인 경우 메소드를 종료, 반환형=void(==break)
// 형식2) return 대상;  => 메소드 종료 시 대상의 값을 반환하여 메소드를 호출한 명령에게 제공
// ㄴ 메소드의 반환형과 반환되는 대상의 자료형이 반드시 동일해야함

// 메소드 호출(Method Invoke) : 메소드를 호출해야 메소드의 명령이 실행되어 기능 제공 가능
// ㄴ형식 : 객체.메소드명(값,값...)
// ㄴ 객체가 저장된 참조변수를 이용하여 메소드에 접근 후 메소드 호출
// ㄴ 메소드 호출 시 나열된 값이 매개변수에 차례대로 전달되어 저장된다.
// ㄴ 매개변수에 값이 정상적으로 전달되지 않은 경우 메소드 호출 불가능(에러)
// ㄴ 

public class Method {
//	객체 생성(참조)이 목적인 클래스
	
	void displayOne() { // 메소드 머리 부
		System.out.println("### Method 클래스의 displayOne() 메소드 호출 ###"); //메소드 몸체 부
	}
	
	
	void displayTwo() {
		System.out.println("### Method 클래스의 displayTwo() 메소드 호출 ###");		
	}
	
	void printOne() {
		int tot=0;
		for(int i=1;i<=100;i++) {
			tot+=i;
		}
		System.out.println("1~100 정수 합 : "+tot);
	}
	
	// 메소드 호출 시 매개변수의 값이 정상적으로 전달되어 저장돼야만 메소드의 명령 실행
	// 매개변수에 값이 저장되지 않을 경우 메소드 호출 불가능 - 에러 발생
	void printTwo(int num) {
		//매개변수에 저장된 값에 대한 검증
		
		if(num<1 || num>100) {
			System.out.println("out of bounds");
			return;  // 메소드(만) 강제종료
		}
		
		
		int tot=0;
		for(int i=1;i<=num;i++) {
			tot+=i;
		}
		System.out.println("1~"+num+" 정수 합 : "+tot);
	}
	
	void printThree(int num1, int num2) {
		int tot=0;
		if(num1>=num2) {  // 검증
			System.out.println("out of bounds");
			return; // 메소드 강제종료
		}
		for(int i=num1;i<=num2;i++) { // 연산
			tot+=i;
		}
		System.out.println(num1+"~"+num2+" 정수 합 : "+tot);
	}
	
	
	int returnTot(int num1,int num2) {
		if(num1>num2) {
			int temp=num1;
			num1=num2;
			num2=temp;
		}
		int tot=0;
		for(int i=num1;i<=num2;i++) {
			tot+=i;
		}
		return tot; // 반환하는 값의 자료형과 메소드의 반환형이 반드시 동일해야 함
	}
	
	//매개변수로 정수값을 전달받아 홀수와 짝수를 구분하여 반환하는 메소드
	boolean isOddEven(int num) { // boolean타입의 메소드 명은 is 로 시작하는 경우가 대다수
		if(num%2==0) {
			return true;
		} else {
			return false;
		}
	}
	
	//배열(의 메모리 주소)을 반환하는 메소드 -> 값 여러개 반환
	int[] returnArray() {
		/*
		 * int[] array= {10,20,30,40,50}; 
		 * return array;
		 */
		return new int[] {10,20,30,40,50};
	}
	
	//3개의 매개변수의 정수값을 전달받아 합계를 계산하여 반환하는 메소드
	int sumOne(int num1, int num2, int num3) {
		return num1+num2+num3;
	}
	
	//배열을 전달받아 배열의 모든 요소값의 합계를 반환
	int sumTwo(int[] array) {
		int tot=0;
		for(int num:array) {
			tot+=num;
		}
		return tot;
	}
	
	//매개변수 생략 기호(...)를 사용하여 매개변수를 선언한 경우 값을 0개 이상 전달받아 저장 가능
	//ㄴ매개변수로 값들을 전달받아 내부적으로 배열을 생성하여 요소값으로 저장
	int sumThree(int...array) { // 배열로 처리됨
		int tot=0;
		for(int num:array) {
			tot+=num;
		}
		return tot;
	}
	
	
	
}//class
