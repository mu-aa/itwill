package bookReview;

public class InterfaceExample {
	public static void main(String[] args) {
		
		ImplementationC impl=new ImplementationC();
		
		InterfaceA ia2=impl;  // == InterfaceA ia1=new ImplementationC();
		ia2.methodA();
		System.out.println("\n=======================\n");
		
		
		InterfaceB ib=impl; // 인터페이스타입에 맞는 메소드만 사용 가능
		ib.methodB();
		System.out.println("\n=======================\n");
		
		
		InterfaceC ic=impl;  // A와 B를 상속받았으므로 전부 사용 가능
		ic.methodA();
		ic.methodB();
		ic.methodC();
		System.out.println("\n=======================\n");
		
		
		new ImplementationC().methodA(); // 일회성 호출
		new ImplementationC().methodB();
		new ImplementationC().methodC();
		System.out.println("\n=======================\n");
	}
}
