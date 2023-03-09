package oop;

public class OverloadApp {
	public static void main(String[] args) {
		
		Overload test=new Overload();
		
		test.display(100);
//		test.displayInt(12.34);   메소드 호출 시 매개변수에 값을 잘못(틀린 자료형 등..) 전달 할 경우 에러 발생
		test.display(false);
		test.display("홍길동");
		
		System.out.println("\n=======================================\n");
		
		
//		오버로드 선언된 메소드는 매개변수에 전달되는 값에 의해 메소드를 선택 호출
//		ㄴ 메소드 오버로드에 의한 다형성(Polymorphism)
//		다형성(Polymorphism) : 같은 이름의 메소드를 호출해도 상태에 따라 메소드가 선택 호출 되어지는 기능
//		ㄴ 호출되는 기능 : 메소드 오버로드, 메소드 오버라이드
		
		test.display(200);
		test.display(true);
		test.display("홍길동");
//		test.display(12.34);    전달된 값에 대한 자료형의 매개변수가 없는 경우 에러
		System.out.println("\n=======================================\n");
		
		
		test.review(1);
		test.review(1,2);
		test.review(1,2,3);  // 3개까지 설정했기 때문에 이 이상 지정하면 에러
//		test.display(1,2,3,4);  전달된 값에 대한 매개변수의 갯수가 다른 경우 에러
		System.out.println("\n=======================================\n");
		
	}//main
}//class
