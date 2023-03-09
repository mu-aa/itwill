package xyz.itwill.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import xyz.itwill.dto.UserinfoDTO;
import xyz.itwill.service.UserinfoService;

//클라이언트가 [/remove.do]로 요청한 경우 실행될 Model Class
//ㄴ 관리자만 요청 가능하도록 권한 설정
//ㄴ 아이디를 전달받아 USERINFO 테이블에 저장된 해당 아이디의 회원정보 삭제 처리
//ㄴ [list.do]로 Redirect 이동하기 위한 정보가 저장된 ActionForward 객체 반환
//ㄴ 관리자가 자신 계정의 회원정보를 삭제한 경우 [logout.do]로 Redirect 이동하기 위한
//정보가 저장된 ActionForward 객체 반환
public class RemoveModel implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ActionForward actionForward=new ActionForward();
		
		try {
			HttpSession session=request.getSession();
			UserinfoDTO loginUserinfo=(UserinfoDTO)session.getAttribute("loginUserinfo");
			//비로그인 사용자 또는 관리자가 아닌 경우 - 비정상적인 요청
			if(loginUserinfo==null || loginUserinfo.getStatus()!=9) { 
				throw new Exception();
			}
			
			if(request.getParameter("userid")==null) {
				throw new Exception();
			}
			
			String userid=request.getParameter("userid");
			
			UserinfoService.getService().removeUserinfo(userid);
			
			actionForward.setForward(false);
			//로그인 사용자의 아이디와 삭제된 사용자의 아이디가 같은 경우
			if(loginUserinfo.getUserid().equals(userid)) { //관리자가 자신의 계정을 삭제한 경우
				actionForward.setPath("logout.do");
			} else {
				actionForward.setPath("list.do");
			}
		} catch (Exception e) {
			actionForward.setForward(false);
			actionForward.setPath("error.do");
		}
		return actionForward;
	}
}