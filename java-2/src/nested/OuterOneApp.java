package nested;

import nested.OuterOne.InnerOne;

public class OuterOneApp {
	public static void main(String[] args) {
		OuterOne outerOne = new OuterOne(5);

		outerOne.displayOuter();
		System.out.println("\n=====================================\n");

		// 내부 클래스로 직접 객체 생성 불가능
		// InnerOne innerOne=new InnerOne();

		// 외부 클래스의 객체를 이용하여 내부 클래스의 객체 생성 가능
		InnerOne innerOne = outerOne.new InnerOne(300); // -> 쓸 일 거의 없음

		innerOne.displayInner();
		System.out.println("\n=====================================\n");

	}// main
}// class
