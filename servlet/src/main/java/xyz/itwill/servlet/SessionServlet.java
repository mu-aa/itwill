package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//세션(Session) : 서버(웹프로그램)와 클라이언트(브라우저)의 연결 지속성을 제공하기 위해 서버에 저장되는 값
//ㄴ 보안(권한) 관련 정보를 저장할 목적으로 사용
//ㄴ 세션 아이디(식별자)를 이용하여 클라이언트를 구분해 세션에 값(객체)을 저장하여 사용
//세션 바인딩(Session Binding) : 세션을 웹프로그램에서 사용할 수 있도록 결합하는 작업 - WAS
//클라이언트에서 [JSESSIONID] 이름의 Cookie를 제공하지 않을 경우 새로운 세션을 생성하여 바인딩 처리
//ㄴ 생성된 세션의 아이디(식별자)를 [JSESSIONID] 이름의 Cookie 값으로 저장하여 클라이언트에게 전달
//ㄴ 서버로부터 전달받은 [JSESSIONID] Cookie를 클라이언트는 브라우저 메모리에 저장 - 브라우저가 종료되면 삭제
//클라이언트에서 [JSESSIONID] 이름의 Cookie를 제공받은 경우 세션 트렉킹하여 바인딩 처리
//세션 트렉킹(Session Tracking) : [JSESSIONID] 이름의 Cookie 값을 서버에 저장된 세션의 아이디와 비교하여 검색하는 작업

//세션을 바인딩하여 클라이언트에게 바인딩된 세션정보를 전달하는 Servlet
@WebServlet("/session.itwill")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//HttpServletRequest.getSession() : 바인딩 처리된 세션(Http Session 객체)을 반환하는 메소드
		//ㄴ 새로운 세션을 생성하여 바인딩하거나 기존 세션을 트렉킹하여 바인딩 처리
		//HttpSession 객체 : 세션 관련 정보를 저장한 객체
		HttpSession session=request.getSession();
	
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>세션(Session)</h1>");
		out.println("<hr>");
		//HttpSession.isNew() : 세션을 트렉킹하여 바인딩 된 경우 [false]
		//세션을 생성하여 바인딩 한 경우 [true] 를 반환하는 메소드
		if(session.isNew()) {
			out.println("<p>세션을 생성하여 바인딩 하였습니다.</p>");
		} else {
			out.println("<p>세션을 트렉킹하여 바인딩 하였습니다.</p>");
		}
		
		//HttpSession.getId() : 세션을 구분하기 위한 식별자(세션 아이디)를 반환하는 메소드
		out.println("<p>세션 아이디 = "+session.getId()+"</p>");
		
		//HttpSession.getMaxInactiveInterval() : 바인딩된 세션의 유지시간(초)를 반환하는 메소드
		//ㄴ 기본적으로 세션의 유지시간은 1800초(30분)로 설정
		out.println("<p>세션 유지시간 = "+session.getMaxInactiveInterval()+"초</p>");
		
		//HttpSession.setAttribute(String attributeName, Object attributeValue)
		//ㄴ 바인딩 세션에 세션 속성명(문자열)과 세션 속성값(객체)을 저장(변경)하는 메소드
		//ㄴ 기존 세션에 저장된 값과 같은 이름의 속성명을 사용한 경우 속성값 변경
		//ㄴ 연결 지속성을 제공하기 위해 정보를 이름과 값의 엔트리(Entry) 형식으로 저장
		//동일한 세션을 바인딩한 모든 웹프로그램에서 세션 속성명으로 세션 속성값을 제공받아 사용
		//ㄴ 하나의 클라이언트는 세션을 통해 모든 웹프로그램에서 객체를 공유하여 사용 가능
		session.setAttribute("now", new Date()); //다른 웹프로그램에서 객체를 사용할 수 있도록
		
		//HttpSession.getAttribute(String attributeName) : 바인딩된 세션에 저장된 속성값과 속성명을 
		//전달받아 반환하는 메소드
		//ㄴ 세션에 저장된 속성값을 Object 타입으로 반환하므로 반드시 명시적 객체 형변환 후 사용
		//ㄴ 매개변수로 전달받은 속성명의 속성값이 없는 경우 null 반환
		Date now=(Date)session.getAttribute("now");
		out.println("<p>세션으로부터 제공받은 객체 = "+now+"</p>");
		
		//HttpSession.removeAttribute(String attributeName) : 바인딩된 세션에 저장된 속성값과 속성명을
		//전달받아 삭제하는 메소드
		session.removeAttribute("now");
		
		//HttpSession.invalidate() : 바인딩된 세션의 결합을 해제하는 메소드
		//ㄴ 세션의 언바인딩(UnBinding) 처리 - 세션 소멸
		session.invalidate();
		
		out.println("</body>");
		out.println("</html>");
	}
}
