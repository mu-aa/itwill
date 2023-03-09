package bookReview;

public class ImplementationC implements InterfaceC{

	@Override   // 실체화(구현)
	public void methodA() {
		System.out.println("ImplementationC에서 InterfaceA의 methodA 실행");
	}

	@Override
	public void methodB() {
		System.out.println("ImplementationC에서 InterfaceB의 methodB 실행");
		
	}

	@Override
	public void methodC() {
		System.out.println("ImplementationC에서 InterfaceC의 methodC 실행");
		
	}

}
