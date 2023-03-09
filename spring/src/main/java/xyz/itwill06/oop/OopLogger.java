package xyz.itwill06.oop;

public class OopLogger {
	public void beforeLog() { //중복되는 코드 메소드화
		System.out.println("*** 메소드의 명령(핵심관심코드)이 실행되기 전에 기록될 내용 ***"); //횡단관심코드
	}
}