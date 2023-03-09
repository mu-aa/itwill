package xyz.itwill.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import xyz.itwill.dto.UserinfoDTO;
import xyz.itwill.service.UserinfoService;

//클라이언트가 [/list.do]로 요청한 경우 실행될 Model Class
//ㄴ 로그인 사용자만 요청 가능하도록 권한 설정
//ㄴ USERINFO 테이블에 저장된 모든 회원정보를 검색하여 request 속성값으로 저장
//ㄴ [user_list.jsp]로 Forward 이동하기 위한 정보가 저장된 ActionForward 객체 반환
public class ListModel implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ActionForward actionForward=new ActionForward();
		
		try {
			HttpSession session=request.getSession();
			UserinfoDTO loginUserinfo=(UserinfoDTO)session.getAttribute("loginUserinfo");
			//비로그인 사용자인 경우 - 비정상적인 요청
			if(loginUserinfo==null) { 
				throw new Exception();
			}
			
			//UserinfoService 클래스의 getUserinfoList() 메소드를 호출하여 반환된 회원목록을
			//Forward 이동될 JSP에서 사용하기 위해 request 속성값으로 저장
			request.setAttribute("userinfoList", UserinfoService.getService().getUserinfoList());
			
			actionForward.setForward(true);
			actionForward.setPath("/model_two/user_list.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			actionForward.setForward(false);
			actionForward.setPath("error.do");
		}
		return actionForward;
	}
}
