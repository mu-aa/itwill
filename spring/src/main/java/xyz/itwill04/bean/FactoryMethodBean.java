package xyz.itwill04.bean;

//Singleton Design Pattrern을 적용하여 작성된 클래스 - Singleton Class
//ㄴ 프로그램 실행에 필요한 객체를 하나만 제공하기 위한 목적의 클래스 작성 시 사용하는 Design Pattrern
public class FactoryMethodBean {
	private static FactoryMethodBean _bean;
	
	private FactoryMethodBean() {
		System.out.println("### FactoryMethodBean 클래스의 기본 생성자 호출 ###");
	}
	
	static {
		_bean=new FactoryMethodBean();
	}
	
	public static FactoryMethodBean getFactoryMethodBean() {
		return _bean;
	}
}