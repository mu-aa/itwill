package xyz.itwill.jdbc;

public class StaticBlock {
	//정적영역(Static Block) : 클래스가 메모리에 저장된 후 자동 실행될 명령을 작성하는 영역
	static {
		System.out.println("### StaticBlock 클래스 정적 영역에 작성된 명령 실행 ###");
		
		//객체 생성, 메소드 호출을 정적 영역에 선언하면 최초 1회만 실행 - 싱글톤과 비슷한 효과
		StaticBlock staticBlock=new StaticBlock();
		staticBlock.display();
	}
	
	public StaticBlock() {
		System.out.println("### StaticBlock 클래스의 기본 생성자 호출 - 객체 생성 ###");
	}
	
	public void display() {
		System.out.println("### StaticBlock 클래스의 display() 메소드 호출 ###");
	}
}