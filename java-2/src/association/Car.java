package association;


// ● 클래스와 클래스의 관계 : 객체 관계
// ㄴ UML을(Unified Modeling Language) 사용하여 클래스 다이어그램(Class Diagram)으로 표현 . . . starUML
//          표준화된  모델링     언어

// 1. 일반화 관계(Generalization) : 상속 관계(is a 관계, ..는 ..다) - 클래스를 선언 시 기존 클래스를 상속받아 작성
// ex) 사원클래스 와 관리자클래스 - 관리자는 사원이다(O), 사원은 관리자이다(X)

// 2. 실체화 관계(Realization) : 상속 관계(is a 관계)
// ㄴ 클래스 선언 시 인터페이스를 상속받아 작성
// ㄴ 인터페이스 : 클래스보다 좀 더 추상적으로 표현된 자료형(클래스로도 표현하기 힘든 것도 표현 가능 ex. 도형..)

//								  //명령 개체와 피명령 개체 
// ★ 3. 연관 관계(Association), 직접 연관 관계(Direct Association) : 포함 관계(has a 관계, ..는 ..의 것이다)     // 지금은 이거만 하면 됨  
// ㄴ 클래스 선언 시 필드를 참조변수로 선언하여 객체를 저장한 관계             
// ㄴ ex) Computer <-- CPU + MainBoard + Memory   직접연관관계
// ㄴ 환자 ㅡ 의사  : 서로를 필요로 함                연관관계

// 4. 집합연관관계(Aggregation) : 포함관계의 객체간의 생명주기가 다른 경우
// ㄴ ex) Computer -- Printer   컴퓨터로 프린터에 출력 명령을 줘야하지만 컴퓨터 고장나도 프린터도 바꾸진 않음

// 5. 복합연관관계(Composition) : 포함관계의 객체간의 생명주기가 같은 경우
// ㄴ ex) Game -- Character    게임 꺼지면 캐릭터도 꺼짐

// 6. 의존 관계(Dependency) : 포함관계 - 참조필드에 저장된 객체가 변경될 수 있는 관계
// ㄴ ex) TV -- Remote Controller   리모컨 바꿔도 동작은 됨, 리모컨 마다 기능의 차이가 있을 수는 있음

//자동차 정보(모델명 생산년도 엔진)를 저장하기 위한 클래스
public class Car {
	private String modelName;
	private int productionYear;
	// 엔진 정보(Engine 객체)를 저장하기 위한 참조필드 - 포함관계 중 직접연관관계(Direct Association)
	// ㄴ 포함관계가 성립되기 위해서는 반드시 생성자 또는 Setter 메소드를 이용해서 //참조필드에 객체가 저장되도록 설정//해야함   
	private Engine carEngine; //필드를 만들어서 객체를 저장하고, 메소드를 호출해야만 관계가 성립
	
	public Car() {
		// TODO Auto-generated constructor stub
	}

	public Car(String modelName, int productionYear, Engine carEngine) {
		super();
		this.modelName = modelName;
		this.productionYear = productionYear;
		this.carEngine = carEngine;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public int getProductionYear() {
		return productionYear;
	}

	public void setProductionYear(int productionYear) {
		this.productionYear = productionYear;
	}

	public Engine getCarEngine() {
		return carEngine;
	}

	public void setCarEngine(Engine carEngine) {
		this.carEngine = carEngine;
	}
	
	//필드값(자동차정보)을 출력하는 메소드
	public void displayCar() {
		System.out.println("모델명 = "+modelName);
		System.out.println("생산년도 = "+productionYear);
		//System.out.println("엔진 = "+carEngine); 값을 저장해야하는데 주소가 나와서 이렇게는 쓰는 거 아님
		//↓↓↓
		//참조필드에 저장된 객체를 사용하여 메소드 호출
		// => 참조필드에 객체가 저장되어 있지 않은 경우 메소드를 호출하면 NullPointerException 발생
		// => 포함관계로 설정된 객체의 //메소드 호출// 가능
		//System.out.println("연료타입 = "+carEngine.getFualType());
		//System.out.println("배기량 = "+carEngine.getDisplacement());
		
		carEngine.displayEngine(); // 객체로 메소드 호출하는 예시. 이렇게 사용해야 함
		                           // carEngine만 사용X
	}
	
}
