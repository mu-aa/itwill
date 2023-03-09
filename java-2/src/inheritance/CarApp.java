package inheritance;

public class CarApp {
	public static void main(String[] args) {

		Car car = new Car("산타페", "홍길동");

		System.out.println("모델명 = " + car.getModelName());
		System.out.println("소유주 = " + car.getOwnerName());
		System.out.println("\n=====================================\n");
		
/*
		  //Object.toString() : 참조변수에 저장된 객체의 해시코드가 문자열로 반환됨
		  System.out.println("Car.toString = "+car.toString()); //객체의 해시코드가 출력됨
		  
		  //참조변수만을 출력할 경우 자동으로 Object 클래스의 toString() 메소드를 호출
		  System.out.println("car="+car == car.toString() );
*/
		System.out.println("<car>\n"+car);
		System.out.println("\n=====================================\n");

		
		String test="홍길동";
		//String 클래스에서 toString() 메소드를 오버라이드 선언하여 String 클래스의 메소드 호출
		//String.toString() : String 객체에 저장된 문자열을 반환하는 메소드
		//참조변수 출력 시 toString() 메소드 호출 생략 가능  ------------┐
		System.out.println("test.toString() = "+test.toString());     // ↓
		System.out.println("test = "+test); //toString()이 기본값이라 생략되어있음
		System.out.println("\n=====================================\n");
	}// main
}// class
