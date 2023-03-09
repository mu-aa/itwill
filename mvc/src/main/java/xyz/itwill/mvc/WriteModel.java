package xyz.itwill.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xyz.itwill.dto.UserinfoDTO;
import xyz.itwill.exception.ExistsUserinfoException;
import xyz.itwill.service.UserinfoService;

//클라이언트가 [/write.do]로 요청한 경우 실행될 Model Class
//ㄴ 회원정보를 전달받아 USERINFO 테이블에 삽입 처리
//ㄴ [loginForm.do]로 Redirect 이동하기 위한 정보가 저장된 ActionForward 객체 반환
public class WriteModel implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ActionForward actionForward=new ActionForward();
		UserinfoDTO userinfo=null;
		
		try {
			if(request.getMethod().equals("GET")) {
				throw new Exception();
			}
			
			request.setCharacterEncoding("utf-8");
			
			String userid=request.getParameter("userid");
			String password=request.getParameter("password");
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			int status=Integer.parseInt(request.getParameter("status"));
			
			userinfo=new UserinfoDTO();
			userinfo.setUserid(userid);
			userinfo.setPassword(password);
			userinfo.setName(name);
			userinfo.setEmail(email);
			userinfo.setStatus(status);
			
			//Service 클래스의 addUserinfo() 메소드 호출
			//ㄴ 전달받은 아이디가 USERINFO 테이블에 저장된 기존 회원의 아이디와 중복될 경우
			//ExistsUserinfoException 발생
			UserinfoService.getService().addUserinfo(userinfo);
			
			actionForward.setForward(false);
			actionForward.setPath("loginForm.do");
		} catch (ExistsUserinfoException e) {
			//아이디 중복 시 발생되는 예외에 대한 처리 명령 작성
			request.setAttribute("message", e.getMessage()); //requset Scope
			request.setAttribute("userinfo", userinfo); //requset Scope
			actionForward.setForward(true);
			actionForward.setPath("/model_two/user_write.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			actionForward.setForward(false);
			actionForward.setPath("error.do");
		}
		return actionForward;
	}
}