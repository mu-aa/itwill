package realization;

public class BoatCarRealApp {
	public static void main(String[] args) {
		
		BoatCarReal carReal=new BoatCarReal();
		BoatCar boatCar=new BoatCarReal();   //인터페이스는 객체 생성은 안되지만 참조변수는 선언 가능
		Boat boat=new BoatCarReal();
		Car car=new BoatCarReal();
		
		carReal.floating();
		carReal.navigate();  //BoatCarReal을 참조했기 때문에 BoatCarReal의 기능 사용 가능 
		carReal.run();
		
		boatCar.floating();
		boatCar.navigate();  //BoatCar를 참조했기 때문에 boatCar의 기능 사용 가능
		boatCar.run();
		
//		boat.floating();
		boat.navigate();  //Boat를 참조했기 때문에 boat의 기능만 사용 가능
//		boat.run();
		
//		car.floating();
//		car.navigate();
		car.run();  //Car를 참조했기 때문에 car의 기능만 사용 가능
		
	}//main
}//class
