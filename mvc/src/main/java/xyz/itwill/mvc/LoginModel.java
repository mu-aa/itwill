package xyz.itwill.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import xyz.itwill.exception.AuthFailException;
import xyz.itwill.service.UserinfoService;

//클라이언트가 [/login.do]로 요청한 경우 실행될 Model Class
//ㄴ 로그인정보를 전달받아 USERINFO 테이블에 저장된 회원정보와 비교하여 인증 처리
//ㄴ 인증 성공 : 세션에 권한 관련 정보를 저장하고 [/loginForm.do]로 Redirect 이동하기 위한 
//정보가 저장된 ActionForward 객체 반환
//ㄴ 인증 실패 : [user_login.jsp]로 Forward 이동하기 위한 정보가 저장된 ActionForward 객체 반환,
//에러메세지와 아이디를 request 속성값으로 저장하여 JSP 문서에 제공
public class LoginModel implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ActionForward actionForward=new ActionForward();
		
		//요청을 처리하면서 발생되는 모든 예외를 처리하기 위한 기능 구현
		try {
			if(request.getMethod().equals("GET")) { //비정상적인 요청인 경우
				throw new Exception(); //인위적 예외 발생
			}
			
			//전달값을 반환받아 저장
			String userid=request.getParameter("userid");
			String password=request.getParameter("password");
			
			//Model Class의 요청 처리 메소드에서는 Service 객체로 메소드를 호출하여 DB에 관련된 작업이 처리되도록 작성
			//UserinfoService 클래스의 auth() 메소드를 호출하여 인증 처리
			//ㄴ AuthFailException 발생 = 인증실패
			UserinfoService.getService().auth(userid, password);
			
			//인증이 성공한 경우 세션에 권한 관련 정보(회원정보) 저장
			//ㄴ 세션을 바인딩하여 HttpSession 객체를 반환받아 저장
			HttpSession session=request.getSession();
			//Session Scope : 동일한 세션을 사용하는 모든 웹프로그램에서 속성값을 반환받아 사용 가능
			//ㄴ 웹브라우저가 종료되면 클라이언트에 바인딩된 세션(jsessionid cookie)은 자동으로 제거
			session.setAttribute("loginUserinfo", UserinfoService.getService().getUserinfo(userid));
			
			actionForward.setForward(false);
			actionForward.setPath("loginForm.do");
		} catch (AuthFailException e) {
			//인증 실패에 의해 발생된 예외에 대한 처리 명령 작성
			//Request Scope : Thread가 이동된 웹프로그램(JSP)에서만 속성값을 반환받아 사용 가능 
			request.setAttribute("message", e.getMessage());
			request.setAttribute("userid", request.getParameter("userid"));
			actionForward.setForward(true);
			actionForward.setPath("/model_two/user_login.jsp");
		} catch (Exception e) {
			//모든 예외에 대한 처리 명령 작성
			//ㄴ [user_error.jsp]로 Forward 이동하기 위한 정보가 저장된 ActionForward 객체 반환
			e.printStackTrace(); //서버 콘솔에 에러메세지 출력(에러 확인용)
			actionForward.setForward(false);
			actionForward.setPath("error.do");
		}
		return actionForward;
	}

}
