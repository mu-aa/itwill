package xyz.itwill.util;
//
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;
import xyz.itwill.dto.Member;
//
public class LoginAuthInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session=request.getSession();
		Member loginMember=(Member)session.getAttribute("loginMember");
		
		/*
		if(request.getRequestURL().toString().contains("/login")||request.getRequestURL().toString().contains("/join")){
			return true; 
		}
		*/
		
		if(loginMember==null || loginMember.getUserstatus()==0) {
			response.sendRedirect(request.getContextPath()+"/login");
			return true;
		}
		//
		return true;
	}
}