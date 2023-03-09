package nested;

import nested.OuterTwo.InnerTwo;

public class OuterTwoApp {
	public static void main(String[] args) {
		OuterTwo outerTwo=new OuterTwo();
		outerTwo.displayOuter();
		System.out.println("\n===================================\n");
		
		
		//정적 중첩 클래스(내부)는 직접 객체 생성 가능 - 일반 중첩 클래스와의 차이점   //정적 중첩 클래스로 객체 만들어 쓰기는 거의 안함
		InnerTwo innerTwo=new InnerTwo();
		innerTwo.displayInner();
		System.out.println("\n===================================\n");
	}
}
