package xyz.itwill.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xyz.itwill.dao.GuestDAO;
import xyz.itwill.dto.GuestDTO;

//입력페이지(insert.html)에서 전달된 게시글을 반환받아 GUEST 테이블에 삽입하고 클라이언트에게
//게시글 목록 출력 페이지(select.itwill)로 이동하기 위한 URL 주소를 전달하는 Servlet - 처리 페이지
@WebServlet("/insert.itwill")
public class GuestInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//비정상적인 요청에 대한 처리
		if(request.getMethod().equals("GET")) { //클라이언트가 Servlet을 GET 방식으로 요청한 경우
			//클라이언트에게 에러코드 전달
			response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED); //405
			return;
		}
		
		//리퀘스트 메세지의 Body에 저장되어 전달되는 값에 대한 charset 변경
		request.setCharacterEncoding("utf-8");
		
		//전달값(게시글)을 반환받아 저장
		//ㄴ String.trim() 메소드를 호출하여 전달값의 앞 또는 뒤에 존재하는 모든 공백 제거
		//ㄴ String.replace() 메소드를 호출하여 XSS 공격에 대한 방어를 위해 태그관련 기호를 회피문자(Escape Character)로 변경
		//XSS(Cross Site Scripting) : 입력태그에 악의적인 스크립트를 입력하여 출력 페이지를 파괴 시키거나 개인정보를
		//특정 사이트로 유출하는 웹사이트 공격 방법
		String name=request.getParameter("name").trim().replace("<", "&lt;").replace(">", "&gt;");
		String title=request.getParameter("title").trim().replace("<", "&lt;").replace(">", "&gt;");
		String content=request.getParameter("content").trim().replace("<", "&lt;").replace(">", "&gt;");
		
		//DTO 객체를 생성하여 전달값으로 필드값 변경
		GuestDTO guest=new GuestDTO();
		guest.setName(name);
		guest.setTitle(title);
		guest.setContent(content);
		
		//게시글(GuestDTO 객체)을 전달받아 GUEST 테이블에 삽입하는 DAO 클래스의 메소드 호출
		GuestDAO.getDAO().insertGuest(guest);
		
		//클라이언트에게 301 상태코드와 URL 주소 전달
		response.sendRedirect("select.itwill"); //리다이렉트 이동(URL 주소 전달)
	}
}