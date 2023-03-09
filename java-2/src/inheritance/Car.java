package inheritance;

//자동차 정보(모델명, 소유주)를 저장하기 위한 클래스
// ㄴ 클래스 선언 시 상속받은 부모클래스가 없는 경우 기본적으로 Object 클래스를 자동으로 상속
// ㄴㄴ 모든 Java 클래스는 무조건 Object 클래스를 상속받아 사용 가능
//Object : 모든 클래스의 최 선조 클래스
// ㄴ ★Object 클래스로 생성된 참조변수에는 모든 클래스로 생성된 객체를 저장 가능(Object==All)


//     				   기본값
public class Car /* extends Object */{
	private String modelName;
	private String ownerName;
	
	public Car() {
		// TODO Auto-generated constructor stub
	}

	public Car(String modelName, String ownerName) {
		super();
		this.modelName = modelName;
		this.ownerName = ownerName;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	
	//Object 클래스의 toString() 메소드를 오버라이드 선언
	// ㄴ Object 클래스의 toString() 메소드는 숨겨지고 Car 클래스의 toString() 메소드 호출
	// ㄴ VO 클래스에서는 필드값을 문자열로 반환 처리 - 필드값 확인을 위해(임시 출력 메소드인 display 대신)
	@Override
	public String toString() {
		return "모델명 = "+modelName+"\n소유주 = "+ownerName;
	}
	
}//class
