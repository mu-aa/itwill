package nested;

public class AnonymousApp{
	public static void main(String[] args) {
		//인터페이스를 이용하여 참조변수 생성은 가능하지만 객체 생성은 불가능
		//ㄴ 인터페이스는 클래스가 상속받기 위한 자료형
		//ㄴ 인터페이스를 상속받은 자식클래스는 인터페이스에 선언된 모든 추상 메소드를 반드시 오버라이드 해야함
		//ㄴ 자식클래스로 객체를 생성하여 인터페이스 참조변수에 객체 저장 가능
		//Anonymous anonymous=new Anonymous();  <- 불가능
		
		//인터페이스를 상속받은 이름이 없는 자식클래스(익명의 내부 클래스, Anonymous Inner Class)를 선언하고    
		//자식클래스로 익명객체를 생성하여 인터페이스 참조변수에 저장
		// ㄴ 익명의 내부 클래스에서는 반드시 인터페이스의 모든 추상메소드를 오버라이드 선언
		// ㄴ 인터페이스 대신 추상클래스를 이용해서도 익명의 내부클래스 선언 가능
		Anonymous anonymous=new Anonymous()			// (익명객체도 잘 안 씀, 보통 일반중첩클래스로 처리
		{ // 익명의 내부 클래스 -> 일종의 로컬 클래스
			@Override
			public void display() {
				System.out.println("익명의 내부클래스의 오버라이드 메소드 호출");
			}
		}; // 익명의 내부 클래스
		
		anonymous.display();
		
	}
}