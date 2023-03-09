package xyz.itwill.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//클라이언트가 [/loginForm.do]로 요청한 경우 실행될 Model 클래스
//ㄴ [user_login.jsp]로 Forward 이동하기 위한 정보가 저장된 ActionForward 객체 반환
public class LoginFormModel implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ActionForward actionForward=new ActionForward();
		actionForward.setForward(true);
		actionForward.setPath("/model_two/user_login.jsp");
		return actionForward;
	}
}
