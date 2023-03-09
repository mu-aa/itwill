package xyz.itwill06.oop;

//OOP 단점 : 모듈화가 너무 강력하여 핵심관심코드와 횡단관심코드를 분리하여 프로그램 작성이 어려움
//ㄴ 코드의 중복성이 높아 프로그램의 생산성 및 유지보수 효율성 감소
public class OopOne {
	/*
	private void beforeLog() { //중복되는 코드 메소드화
		System.out.println("*** 메소드의 명령(핵심관심코드)이 실행되기 전에 기록될 내용 ***"); //횡단관심코드
	}
	*/
	
	//OOP의 캡슐화를 위반함(주요기능이 아닌 보조기능을 중요 목적 없이(단순히 중복을 피할 목적으로) 모듈화 한 것)
	private OopLogger logger=new OopLogger();
	
	public void display1() {
		//횡단관심코드 : 프로그램 실행에 보조적인 기능을 제공하는 명령
		//ㄴ 로그 처리, 권한 처리, 트랜젝션 처리, 예외 처리 등
		//beforeLog();
		logger.beforeLog();
		
		//핵심관심코드 : 프로그램 실행에 핵심적인 기능을 제공하는 명령
		//ㄴ 데이터 처리 명령
		System.out.println("### OopOne 클래스의 display1() 메소드 호출 ###"); //핵심관심코드
	}
	public void display2() {
		//beforeLog();
		logger.beforeLog();
		System.out.println("### OopOne 클래스의 display2() 메소드 호출 ###");
	}
	public void display3() {
		//beforeLog();
		logger.beforeLog();
		System.out.println("### OopOne 클래스의 display3() 메소드 호출 ###");
	}
}