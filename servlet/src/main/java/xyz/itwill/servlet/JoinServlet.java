package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//입력페이지(form.html)에서 전달된 입력값(회원정보)을 반환받아 클라이언트(원래는 DB와 연동)에게 전달하는 Servlet

@WebServlet("/join.itwill")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//현재 실행되는 Servlet(웹프로그램)은 입력페이지(join.html)의 form 태그를 이용하여 POST 방식으로 요청
		//ㄴ Servlet을 GET 방식으로 요청한 경우 비정상적인 요청
		//★ 클라이언트가 웹프로그램을 비정상적으로 요청한 경우 클라이언트에게 에러코드를 전달하거나
		//에러페이지(또는 입력페이지)로 이동되도록 처리 - **권한 유무에 따른 기능 제한 등으로 활용**
		//HttpServletRequest.getMethod() : 클라이언트의 요청방식(GET/POST)을 반환하는 메소드
		if(request.getMethod().equals("GET")) { //클라이언트가 GET 방식으로 요청한 경우
			
			//1. 상태코드 전달
			//HttpServletResponse.sendError(int sc) : 클라이언트에게 에러코드(4XX or 5XX 상태코드)를 전달하는 메소드
			//상태코드(Status Code - sc) : 요청에 대한 응답 관련 정보를 제공하기 위한 정수값
			//ㄴ 1XX:처리중, 2XX:처리완료(정상응답), 3XX:재요청, 4XX:잘못된 요청, 5XX:실행 오류
			//ㄴ Servlet에서는 HttpServletResponse 인터페이스의 상수(Constant)를 이용하여 상태코드 제공
			//response.sendError(400);
			//response.sendError(HttpServletResponse.SC_BAD_REQUEST); //sc:400
			//response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED); //sc:405
			
			//2. 에러페이지로 이동(리다이렉트) - 권장
			//★★★ HttpServletResponse.sendRedirect(String url) : 클라이언트에게 URL 주소를 전달하는 메소드
			//ㄴ 클라이언트에게 처리결과를 파일로 응답하지 않고 301 상태코드와 URL 주소를 전달하여 응답
			//301 상태코드와 URL 주소를 전달받은 클라이언트는 브라우저의 URL 주소를 변경하고 
			//변경된 URL 주소의 웹프로그램을 요청하여 처리결과를 응답받아 출력 - 리다이렉트 이동
			//response.sendRedirect("/servlet/error.html"); //에러페이지(URL) 반환
			//return;
			
			//3. JavaScript로 처리
			out.println("<script type='text/javascript'>");
			out.println("alert('비정상적인 접근입니다.');");
			out.println("location.href='form.html';");
			out.println("</script>");
		}
		
		//Servlet을 POST 방식으로 요청한 경우 사용자 입력값이 Request Message의 Body에 저장되어 전달
		//ㄴ Request Message의 Body에 저장되어 전달된 값의 Charset은 기본적으로 서유럽어(ISO-8859-1)로 설정
		//Request Message의 Body에 저장되어 전달된 값을 원하는 Charset으로 읽기 위해 HttpServletRequest 객체의
		//Charset을 변경
		//형식) HttpServletRequest.setCharacterEncoding(String encoding) : HttpServletRequest 객체의 Charset을
		//변경하는 메소드
		request.setCharacterEncoding("utf-8"); //POST 방식만 Charset 설정
		
		//웹프로그램 요청 시 전달된 값을 반환받아 저장
		//★★★ 형식) HttpServletRequest.getParameter(String name) : 전달값을 반환하는 메소드
		//ㄴ 전달값은 반드시 문자열(String 객체)로 반환 
		//ㄴ 전달값을 매개변수에 전달된 이름(식별자)으로 구분하여 값 반환
		//ㄴ 이름(식별자)으로 전달된 값이 없는 경우 null 반환
		String id=request.getParameter("id");
		String pass=request.getParameter("pass");
		String name=request.getParameter("name");
		String addr=request.getParameter("addr");
		String gender=request.getParameter("gender");
		String job=request.getParameter("job");
		//같은 이름으로 전달되는 값이 있는 경우 첫번째 전달값만 반환받아 저장
		//String hobby=request.getParameter("hobby");
		//형식) HttpServletRequest.getParameterValues(String name) : 같은 이름으로 전달된 모든 값을
		//얻어와 문자열 배열(String[])로 반환하는 메소드
		String[] hobby=request.getParameterValues("hobby");
		String profile=request.getParameter("profile");
		
		//입력값 검증 - 생략 가능(비권장)
		/*
		if(id==null || id.equals("")) {
			response.sendRedirect("error.html");
			return;
		}
		
		String idReg="^[a-zA-Z]\\w{5,19}$";
		if(Pattern.matches(idReg, id)) { //입력 형식이 맞지 않은 경우 - 비정상적인 접근
			response.sendRedirect("error.html");
			return;
		}
		*/
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>회원정보확인</h1>");
		out.println("<hr>");
		out.println("<p>아이디 = "+id+"</p>");
		out.println("<p>비밀번호 = "+pass+"</p>");
		out.println("<p>이름 = "+name+"</p>");
		out.println("<p>주소 = "+addr+"</p>");
		out.println("<p>성별 = "+gender+"</p>");
		out.println("<p>직업 = "+job+"</p>");
		//out.println("<p>취미 = "+hobby+"</p>");
		if(hobby==null) {
			out.println("<p>취미 = 미선택</p>");
		} else {
			out.println("<p>취미 = ");
			for(int i=0;i<hobby.length;i++) {
				out.println(hobby[i]);
				if(i<hobby.length-1) {
					out.println(", ");
				}
			}
		}
		//엔터(Enter)는 브라우저에서 동작되지 않으므로 <br> 태그로 변환하여 출력
		out.println("<p>자기소개 = "+profile.replace("\n", "<br>")+"</p>");
		out.println("</body>");
		out.println("</html>");
	}
}