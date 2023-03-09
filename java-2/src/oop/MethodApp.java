package oop;

//실행이 목적인 클래스 => main 메소드가 선언된 클래스 - 프로그램
public class MethodApp {
	public static void main(String[] args) {
		// 클래스로 객체를 생성하여 객체(의 메모리 주소)를 참조변수에 저장
		// 같은 패키지의 클래스는 패키지 표현 없이 사용할 수 있음
		// 참조변수를 사용하여 객체의 필드 또는 메소드에 접근
		
		/*oop.*/Method test=new Method();
//		ㄴ 패키지표현
		
		System.out.println("method = "+test);
//		ㄴ 참조변수에 저장된 값을 출력할 경우 "자료형@메모리주소" 형식으로 제공된 결과값 출력
		System.out.println("\n===================================\n");
		
		
//		메소드 호출 : 메소드를 호출하면 프로그램 흐름(스레드)이 객체의 메소드로 이동하여 메소드의 명령을 실행하고
//		메소드가 종료되면 다시 되돌아와 다음 명령 실행 
		test.displayOne();  // 여러 번 호출 가능
		test.displayOne();  // 여러 번 호출 가능
		System.out.println("\n===================================\n");
		
		
		test.displayTwo();
		System.out.println("\n===================================\n");

		
		test.printOne();
		test.printOne();
		System.out.println("\n===================================\n");
		
		
		test.printTwo(50);
		test.printTwo(0);
		test.printTwo(101);
		System.out.println("\n===================================\n");
		
		
//		메소드 호출 시 나열될 값이 매개변수에 차례대로 전달되어 저장
		test.printThree(1,100);
		test.printThree(77,45);
		System.out.println("\n===================================\n");
		
		
//		메소드를 호출하여 반환되는 결과값을 변수에 저장(지속적으로 사용할 경우)
		int tot= test.returnTot(1, 100);
		
//		입력과 출력은 메소드가 아닌 프로그램에 작성 ㅡ> 독립적인 프로그램
		System.out.println("합계(메소드 호출 반환 결과값) = "+tot);
		System.out.println("\n===================================\n");
		
		
//		if 구문의 조건식 대신 논리값을 반환하는 메소드를 호출하여 명령 선택 실행 가능
		if(test.isOddEven(10)) {
			System.out.println("매개변수에 전달된 값은 [짝수]입니다.");
		} else {
			System.out.println("매개변수에 전달된 값은 [홀수]입니다.");			
		}
		System.out.println("\n===================================\n");
		

		int[] array = test.returnArray(); //배열 받아서
		for(int num:array) { 
			System.out.print(num+" ");    //출력
		}
		System.out.println("\n===================================\n");
		
		
		System.out.println("sum = "+test.sumOne(10, 20, 30));
//		System.out.println("sum = "+test.sumOne(10, 20));
//		System.out.println("sum = "+test.sumOne(10));       매개변수 오류로 불가능
//		System.out.println("sum = "+test.sumOne());
		System.out.println("\n===================================\n");
		
		
		System.out.println("배열 합계 : "+test.sumTwo(new int[] {10,20,30}));
		System.out.println("배열 합계 : "+test.sumTwo(new int[] {10,20}));
		System.out.println("배열 합계 : "+test.sumTwo(new int[] {10}));  // 배열을 만들어 원하는 만큼 한 번에 전달 가능
		System.out.println("배열 합계 : "+test.sumTwo(new int[] {}));
		System.out.println("\n===================================\n");
		
		
		System.out.println("합계 = "+test.sumThree(10,20,30));
		System.out.println("합계 = "+test.sumThree(10,20));
		System.out.println("합계 = "+test.sumThree(10));  // ★배열 안만들고 원하는 만큼 한 번에 전달 가능
		System.out.println("합계 = "+test.sumThree());
		System.out.println("\n===================================\n");
	}
}
