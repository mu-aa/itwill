package xyz.itwill10.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import xyz.itwill10.dto.Userinfo;

//로그인 사용자 관련 권한 처리를 위해 작성된 Interceptor 클래스
//ㄴ 요청 처리 메소드의 명령 실행 전에 비로그인 사용자가 페이지를 요청한 경우 에러 메세지를 출력하는
//페이지의 URL 주소를 전달하는 기능 제공
public class LoginAuthInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session=request.getSession();
		Userinfo loginUserinfo=(Userinfo)session.getAttribute("loginUserinfo");
		if(loginUserinfo==null) {
			throw new Exception("비정상적인 요청입니다.");
		}
		
		return true;
	}
}