package association;

public class CarApp {
	public static void main(String[] args) {
		//엔진 생성
		Engine engine=new Engine();
		//engine.displayEngine(); 
		engine.setFualType("경유"); //초기값
		engine.setDisplacement(2000); //초기값
		
		//자동차 생성
		Car carOne=new Car();
		//★ CarOne.displayCar(); --> 포함관계가 성립되지 않은 상태로 호출해서 NullPointerException 발생
		
		carOne.setModelName("쏘렌토"); // 이름 초기값 설정
		carOne.setProductionYear(2018); // 연도 초기값 설정
		
		carOne.setCarEngine(engine); // 자동차에 엔진 포함 - Setter 메소드를 이용하여 참조필드에 객체 저장 : 포함 관계 성립
		carOne.displayCar(); //  --> 포함관계가 성립되어 예외 발생X
		System.out.println("===============================================================");
		
		
		//자동차 생성 >> 엔진 포함 - 생성자를 이용하여 참조필드에 객체 저장 : 포함 관계 성립
		Car carTwo=new Car("싼타페", 2022, new Engine("휘발유", 3000));
		carTwo.displayCar();
		System.out.println("===============================================================");
		
		
		System.out.println(carOne.getModelName()+"의 엔진정보 >> ");
		engine.displayEngine();
		System.out.println("===============================================================");
		
		
		System.out.println(carTwo.getModelName()+"의 엔진정보 >> ");
		//자동차(Car 객체)에서 엔진정보(Engine 객체)를 반환받아 메소드 호출 
		carTwo.getCarEngine().displayEngine();
		System.out.println("===============================================================");
	}
}







