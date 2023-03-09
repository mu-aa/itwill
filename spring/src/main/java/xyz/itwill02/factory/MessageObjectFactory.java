package xyz.itwill02.factory;

//Factory Design Pattern을 이용해 작성된 클래스 - Factory Class, Provider Class
//ㄴ 프로그램 개발에 필요한 객체를 생성하여 제공하는 기능의 클래스 - Container
public class MessageObjectFactory {
	private static MessageObjectFactory _factory;
	
	private MessageObjectFactory() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_factory=new MessageObjectFactory();
	}
	
	public static MessageObjectFactory getFactory() {
		return _factory;
	}
	
	//Factory Class에 의해 제공될 객체를 구분하기 위한 상수(Constant)
	public static final int HELLO_MSG=1;
	public static final int HI_MSG=2;
	
	//매개변수로 전달받은 값을 비교하여 프로그램 개발에 필요한 객체를 생성하여 반환하는 메소드
	public MessageObject getMessageObject(int messageObject) {
		MessageObject object=null;
		switch (messageObject) {
		case HELLO_MSG:
			object=new HelloMessageObject();
			break;
		case HI_MSG:
			object=new HiMessageObject();
			break;
		}
		return object;
	}
}