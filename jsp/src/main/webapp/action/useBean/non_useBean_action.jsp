<%@ page import="xyz.itwill.bean.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 입력페이지(non_useBean_form.jsp)에서 전달된 값을 반환받아 내장객체의 속성값으로 저장하고 
출력페이지(non_useBean_display.jsp)로 forward 이동 처리하는 JSP 문서 --%>
<%
//비정상적인 요청 처리
	if(request.getMethod().equals("GET")) {
		response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
		return;
	}

	//POST 방식으로 요청하여 전달된 값에 대한 Charset 변경
	response.setCharacterEncoding("utf-8");

	//전달값을 반환받아 저장
	String name= request.getParameter("name");
	String phone= request.getParameter("phone");
	String address= request.getParameter("address");
	
	//VO 클래스로 객체를 생성하여 전달값으로 필드값 변경
	User user=new User();
	user.setName(name);
	user.setName(phone);
	user.setName(address);
	
	//Java 명령을 사용하여 현재 요청 JSP 문서가 아닌 다른 JSP 문서로 응답되도록 구현하는 방법
	//ㄴ 리다이렉트 이동하여 응답, 포워드 이동하여 응답
	
	/*
	//● 리다이렉트 이동 : 클라이언트에게 URL 주소를 전달하여 다른 JSP 문서를 요청시켜 결과를 응답받아 처리
	//ㄴ 클라이언트 브라우저의 URL 주소 변경 - 클라이언트를 이용하여 JSP 문서 이동
	//ㄴ session 내장객체를 이용하여 속성값으로 저장하여 응답 JSP 문서에서 반환받아 사용
	//ㄴ 응답 JSP 문서에서는 session 내장객체에 저장된 속성값을 객체로 반환받은 후 반드시 제거
	session.setAttribute("user", user);
	response.sendRedirect("non_useBean_display.jsp"); //리다이렉트 이동
	*/
	
	//● 포워드 이동 : 요청 JSP 문서에서 응답 JSP 문서로 스레드를 이동하여 응답 처리
	//ㄴ 클라이언트 브라우저의 URL 주소 미변경 - 서버에서 JSP 문서간의 이동
	//ㄴ request 내장객체를 이용하여 객체를 속성값으로 저장하여 JSP 문서에서 반환받아 사용 가능
	//ㄴ 요청 JSP 문서 및 응답 JSP 문서를 제외한 다른 JSP 문서에서는 request 내장객체의 속성값 사용
	request.setAttribute("user", user); //request 내장객체를 이용하여 속성값 저장 - request Scope
	//포워드 이동하기위한 Java 명령 - forward 태그와 동일한 기능 제공
	//request.getRequestDispatcher(String URL) : URL 주소가 저장된 RequestDispatcher 객체를 반환
	//RequestDispatcher 객체 : 다른 웹프로그램으로 스레드를 이동하기 위한 기능을 제공하는 객체
	//RequestDispatcher.forward(ServletRequest request, ServletResponse response)
	//ㄴ 요청 웹프로그램에서 다른 웹프로그램으로 스레드를 이동하여 응답처리하기 위한 메소드 - 포워드 이동
	//ㄴ 요청 웹프로그램의 request 객체와 response 객체를 스레드가 이동되는 웹프로그램으로 전달
	request.getRequestDispatcher("non_useBean_display.jsp").forward(request, response);
%>