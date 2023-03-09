package xyz.itwill03.spring;

public class MessagePrint {
	//MessageObject 인터페이스를 상속받은 자식클래스의 객체를 저장하기 위한 필드
	//ㄴ 필드에 객체를 저장해야만 포함관계 성립 - 포함관계의 클래스에 작성된 메소드 호출 가능
	private MessageObject object;

	public MessageObject getObject() {
		return object;
	}
	
	public void setObject(MessageObject object) {
		this.object = object;
	}
	
	public void messagePrint() {
		String message=object.getMessage();
		System.out.println("message = "+message);
	}
}