package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//쿠키를 클라이언트에게 전달하는 Servlet
//쿠키 : 서버와 클라이언트의 연결 지속성을 제공하기 위해 클라이언트에 저장되는 값
//ㄴ 쿠키는 접속 서버 정보를 식별자로 구분하여 클라이언트에 저장, response message의 header에 저장
@WebServlet("/create.itwill")
public class CookieCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//Cookie 클래스로 객체 생성
		//ㄴ Cookie 객체 : Cookie 관련 정보를 저장하기 위한 객체
		//Cookie(String name, String value) : Cookie 명과 Cookie 값을 매개변수에 전달하여 객체 생성
		//ㄴ Cookie 명 : Cookie 값을 구분하기 위한 식별자
		//ㄴ Cookie 값 : 연결 지속성을 제공하기 위한 문자값
		//ㄴ Cookie 명과 Cookie 값은 영문자, 숫자, 일부 특수문자만 사용하여 작성 가능
		
		Cookie idCookie=new Cookie("id", "abc123");
		Cookie countCookie=new Cookie("count", "0");
		
		//클라이언트에게 전달되어 저장될 Cookie의 유지시간 변경
		//Cookie.setMaxAge(int expiry) : Cookie의 유지시간(초)를 변경하는 메소드
		//Cookie의 유지시간을 변경하지 않은 경우 기본값은 [-1]로 자동 설정
		//ㄴ Cookie의 유지시간이 [-1]로 설정된 경우 브라우저 종료 시 자동 소멸
		countCookie.setMaxAge(24*60*60); //Cookie 유지시간 : 1일
		
		//클라이언트에게 Cookie 전달 - Cookie를 전달받은 클라이언트는 Cookie를 저장
		//ㄴ Cookie의 유지시간을 변경하지 않은 Cookie는 브라우저 메모리에 저장 - 브라우저 종료 시 자동 소멸
		//ㄴ Cookie의 유지시간을 변경한 Cookie는 Cookie 파일에 저장 - 유지시간이 지나면 자동 소멸
		//HttpServletResponse.addCookie(Cookie cookie) : 클라이언트에거 Cookie 객체를 전달
		response.addCookie(idCookie);
		response.addCookie(countCookie);
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>쿠키 전달(생성)</h1>");
		out.println("<hr>");
		out.println("<p>쿠키 전달(생성) 완료</p>");
		out.println("<hr>");
		out.println("<a href='read.itwill'>쿠키 읽기</a>");
		out.println("</body>");
		out.println("</html>");
	}
}