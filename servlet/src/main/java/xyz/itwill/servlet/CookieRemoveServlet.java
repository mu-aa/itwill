package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//클라이언트에 저장된 모든 Cookie를 제거하는 Servlet
//ㄴ 클라이언트에 저장된 Cookie의 유지시간을 0으로 변경하면 Cookie 제거
@WebServlet("/remove.itwill")
public class CookieRemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//클라이언트에서 보내온 모든 Cookie를 반환받아 저장
		Cookie[] cookies=request.getCookies();
		
		if(cookies!=null) { //클라이언트에서 보내온 Cookie가 있는 경우
			for(Cookie cookie:cookies) {
				//클라이언트에서 보내온 Cookie의 유지시간을 0으로 변경하여 클라이언트에게 전달
				//ㄴ 유지시간이 지난 Cookie는 클라이언트에서 자동 소멸 - 클라이언트에 저장된 Cookie 제거
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		}
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>쿠키 삭제</h1>");
		out.println("<hr>");
		out.println("<p>쿠키 삭제 완료</p>");
		out.println("<hr>");
		out.println("<a href='read.itwill'>쿠키 읽기</a>");
		out.println("</body>");
		out.println("</html>");		
	}
}