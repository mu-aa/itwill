package xyz.itwill02.factory;

//Factory Class에 의해 생성되어 제공되는 클래스는 반드시 인터페이스를 상속받아 작성
public class HelloMessageObject implements MessageObject {
	@Override
	public String getMessage() {
		return "Hello";
	}
}