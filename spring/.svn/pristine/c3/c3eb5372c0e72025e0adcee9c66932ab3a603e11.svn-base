package xyz.itwill10.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import xyz.itwill10.dto.Userinfo;

//Interceptor 클래스 : Front Controller에 의해 요청 처리 메소드가 호출되어 실행되기 전 또는 후에
//삽입되어 실행될 기능을 제공하는 클래스
//ㄴ Interceptor 클래스는 반드시 HandlerInterceptor 인터페이스를 상속받아 작성 - 필요한 메소드만 Override 선언하여 작성
//ㄴ Spring Bean Configuration File(servlet-context.xml)에 Spring Bean으로 등록

//관리자 관련 권한 처리를 위해 작성된 Interceptor 클래스
//ㄴ 요청 처리 메소드의 명령 실행 전에 비로그인 사용자이거나 관리자가 아닌 사용자가 페이지를 요청한 경우
//에러 메세지를 출력하는 페이지의 URL 주소를 전달하는 기능 제공
public class AdminAuthInterceptor implements HandlerInterceptor {
	//★preHandle : 요청 처리 메소드의 명령이 실행되기 전에 실행될 명령을 작성하는 메소드
	//ㄴ ★권한 관련 명령을 작성하기 위한 메소드
	//ㄴ false 반환 : 요청 처리 메소드의 명령 미실행, true 반환 : 요청 처리 메소드 실행
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session=request.getSession();
		
		Userinfo loginUserinfo=(Userinfo)session.getAttribute("loginUserinfo");
		
		//비로그인 또는 관리자가 아닌 사용자인 경우 - 3가지 처리 방법
		if(loginUserinfo==null || loginUserinfo.getStatus()!=9) {
			//1. request.getRequestDispatcher("userinfo/user_error.jsp").forward(request, response); //포워드 이동
			//2. return false; //권한이 없는 경우 요청 처리 메소드 명령 미실행
			/*3.*/throw new Exception("비정상적인 요청입니다."); //인위적 예외 발생 - 예외 처리 메소드로 예외 처리
		}
		
		return true; //요청 처리 메소드 명령 실행
	}
	
	//postHandle : 요청 처리 메소드의 명령이 실행된 후 View가 생성되기 전에 실행될 명령을 작성하는 메소드
	//ㄴ ModelAndView 객체를 제공받아 ViewName 또는 Model 객체의 속성값 변경
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
	//afterCompletion : 요청 처리 메소드의 명령이 실행되고 View에 의해 최종 결과물이 생성된 후 실행될 명령을
	//작성하는 메소드 - 응답 결과를 변경할 경우 사용
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
}