package xyz.itwill10.exception;

import lombok.Getter;
import lombok.Setter;

//로그인에 대한 인증명령 실행 시 사용자로부터 전달받은 아이디와 비밀번호에 대한
//인증이 실패한 경우 발생되어 처리하기 위한 예외 클래스
@Getter
@Setter
public class LoginAuthFailException extends Exception {
	private static final long serialVersionUID = 1L;

	//예외처리에 필요한 값을 저장하기 위한 필드
	//ㄴ 사용자로부터 입력되어 전달된 아이디를 저장하기 위한 필드  
	private String userid;
	
	public LoginAuthFailException() {
		// TODO Auto-generated constructor stub
	}
	
	public LoginAuthFailException(String message, String userid) {
		super(message);
		this.userid=userid;
	}
}