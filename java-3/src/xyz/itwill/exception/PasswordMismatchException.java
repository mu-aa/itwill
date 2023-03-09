package xyz.itwill.exception;


//프로그램 개발자가 직접 선언한 예외클래스
//ㄴ 반드시 Exception 클래스를 상속받아 작성
public class PasswordMismatchException extends Exception{
	private static final long serialVersionUID = 1L;

	public PasswordMismatchException() {
		// TODO Auto-generated constructor stub
	}
	
	public PasswordMismatchException(String message) {
		//Exception 클래스에는 예외 메세지를 저장하기 위한 필드 선언
		//ㄴ super 키워드를 사용하여 Exception 클래스의 필드에 초기값(예외 메세지) 저장
		super(message); //부모클래스의 message를 받아서 매개변수 message로 반환
	}
	
	
}
