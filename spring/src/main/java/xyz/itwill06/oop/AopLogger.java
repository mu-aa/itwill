package xyz.itwill06.oop;

//횡단관심모듈 : 횡단관심코드만 이용하여 메소드를 작성한 클래스 - Advice 클래스
public class AopLogger {
	public void beforeLog() {
		System.out.println("*** 메소드의 명령(핵심관심코드)이 실행되기 전에 기록될 내용 ***");
	}
}