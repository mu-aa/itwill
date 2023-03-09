package xyz.itwill02.factory;

//인터페이스를 상속받은 클래스는 반드시 인터페이스에 작성된 모든 추상메소드를 Override 선언
//ㄴ 인터페이스를 상속받은 클래스에 메소드 작성 규칙 제공 - 인터페이스 : 작업지시서 역할
//인터페이스로 참조변수를 생성하면 참조변수에는 인터페이스를 상속받은 모든 자식 클래스 객체 저장 가능
//ㄴ 인터페이스로 생성된 참조변수로 추상메소드를 호출하면 참조변수에 저장된 자식클래스 객체의
//Override 메소드 호출 - Override에 의한 다형성 : 객체간의 결합도 감소
public interface MessageObject {
	String getMessage();
}