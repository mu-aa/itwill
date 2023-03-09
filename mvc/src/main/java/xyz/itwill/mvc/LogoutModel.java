package xyz.itwill.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//클라이언트가 [/logout.do]로 요청한 경우 실행될 Model Class
//ㄴ 로그아웃 처리
//ㄴ [loginForm.do]로 리다이렉트 이동하기 정보가 저장된 ActionForward 객체 반환
public class LogoutModel implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		session.invalidate();
		
		ActionForward actionForward=new ActionForward();
		actionForward.setForward(false);
		actionForward.setPath("loginForm.do");
		return actionForward;
	}
}