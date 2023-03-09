package xyz.itwill.exception;

//회원정보를 찾을 수 없을 경우 발생될 예외를 표현하기 위한 클래스
public class UserinfoNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public UserinfoNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	
	public UserinfoNotFoundException(String message) {
		super(message);
	}
}
