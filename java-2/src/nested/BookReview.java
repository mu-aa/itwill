package nested;

import nested.Car.Engine;
import nested.Car.Tire;

@SuppressWarnings("unused")
public class BookReview {
	public static void main(String[] args) {
		
		Car myCar=new Car();
		
		Car.Tire tire=myCar.new Tire(); // 그냥 문법, 이해하지말고 외울 것(내부 클래스는 외부 클래스로 감싸야 함)
				
		Car.Engine engine=new Engine();
//		Engine engine=new Engine();        static은 외부 클래스에서 객체를 만들지 않아도 되니 상관없음
		
	}
}




