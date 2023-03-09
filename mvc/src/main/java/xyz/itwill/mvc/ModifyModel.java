package xyz.itwill.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xyz.itwill.dto.UserinfoDTO;
import xyz.itwill.service.UserinfoService;

//클라이언트가 [/modify.do]로 요청한 경우 실행될 모델 클래스
// => 회원정보를 전달받아 USERINFO 테이블에 저장된 회원정보 변경 처리
// => [view.do]로 리다이렉트 이동하기 위한 정보가 저장된 ActionForward 객체 반환 - 아이디 전달
public class ModifyModel implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward actionForward=new ActionForward();
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
			
			UserinfoDTO userinfo=new UserinfoDTO();
			userinfo.setUserid(userid);
			if(password==null || password.equals("")) {
				//비밀번호 전달값이 없는 경우 - 기존 회원의 비밀번호 사용
				userinfo.setPassword(UserinfoService.getService().getUserinfo(userid).getPassword());
			} else {
				//비밀번호 전달값이 있는 경우 - 입력된 비밀번호 사용
				userinfo.setPassword(password);
			}
			userinfo.setName(name);
			userinfo.setEmail(email);
			userinfo.setStatus(status);
			
			//UserinfoService 클래스의 modifyUserinfo() 메소드 호출
			UserinfoService.getService().modifyUserinfo(userinfo);
			
			actionForward.setForward(false);
			actionForward.setPath("view.do?userid="+userid);
		} catch (Exception e) {
			e.printStackTrace();
			actionForward.setForward(false);
			actionForward.setPath("error.do");
		}
		return actionForward;
	}
}