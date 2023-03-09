package xyz.itwill.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import xyz.itwill.dto.UserinfoDTO;

//클라이언트가 [/writeForm.do]로 요청한 경우 실행될 Model Class
//ㄴ 관리자만 요청 가능하도록 권한 설정
//ㄴ [user_write.jsp]로 포워드 이동하기 위한 정보가 저장된 ActionForward 객체 반환
public class WriteFormModel implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ActionForward actionForward=new ActionForward();

		try {
			HttpSession session=request.getSession(); //세션 바인딩
			UserinfoDTO loginUserinfo=(UserinfoDTO)session.getAttribute("loginUserinfo");
			//비로그인 사용자거나 관리자가 아닌 경우 - 비정상적인 요청
			if(loginUserinfo==null || loginUserinfo.getStatus()!=9) { 
				throw new Exception();
			}
			
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
