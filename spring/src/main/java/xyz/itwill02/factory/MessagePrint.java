package xyz.itwill02.factory;

public class MessagePrint {
	public void messagePrint() {
		//객체를 직접 생성하여 메소드 호출 - 객체간의 결합도가 높음
		//MessageObject object=new HelloMessageObject();
		
		//프로그램 작성에 필요한 객체를 Factory 클래스로부터 제공받아 메소드 호출 - IOC(제어의 역행)
		//ㄴ IOC : 객체간의 결합도를 낮춰 유지보수의 효율성 증가
		//MessageObject object=MessageObjectFactory.getFactory().getMessageObject(1);
		MessageObject object=MessageObjectFactory.getFactory().getMessageObject(2);
		
		//인터페이스로 생성된 참조변수의 추상메소드를 호출한 경우 참조변수에 저장된 자식 클래스
		//객체의 Override 메소드 호출 - 묵시적 객체 형변환 : Override에 의한 다형성
		String message=object.getMessage();
		System.out.println("message = "+message);
	}
}