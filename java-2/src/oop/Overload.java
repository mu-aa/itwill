package oop;

//메소드 오버로드(Method Overload)   오보로드
//ㄴ 클래스에 동일한 기능을 제공하는 메소드가 매개변수에 의해 여러 개 선언하는 경우 메소드의 이름을 같도록 선언
//ㄴ 결론 = 동일한 기능을 제공하는 메소드의 이름을 중복하여 정의하는 것
//ㄴ 접근 지정자와 반환형은 오버로드 선언과 무관함(ex. public void)
//ㄴ 매개변수의 자료형 또는 갯수가 같지 않도록 선언하면 오버로드됨
//ㄴㄴ 부연설명)이름이 같아도 매개변수가 1개인 메소드, 2개인 메소드가 각각 따로 존재해서
//              매개변수를 통해 입력받은 값의 갯수를 통해 어떤 메소드를 사용할 지 결정

public class Overload {
	public void display(int param) {
		System.out.println("정수값 = " + param);
	}

	public void display(boolean param) {
		System.out.println("논리값 = " + param);
	}

	public void display(String param) {
		System.out.println("문자열 = " + param);
	}

	public void review(int num1) {}
	public void review(int num1,int num2) {}
	public void review(int num1,int num2, int num3) {}
}