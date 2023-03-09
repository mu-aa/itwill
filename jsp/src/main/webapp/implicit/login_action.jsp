<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 로그인정보 입력페이지(login_form.jsp)에서 전달된 로그인정보를 반환받아 인증 처리하고 
처리결과에 따라 다른 요청 URL 주소를 클라이언트에게 전달하는 JSP 문서 --%>
<%-- => 로그인(Login) : 인증을 통한 권한 획득 과정 --%>
<%-- 인증 실패 : 클라이언트가 입력페이지(login_form.jsp)로 이동되도록 URL 주소 전달 --%>    
<%-- 인증 성공 : 클라이언트가 출력페이지(login_user.jsp)로 이동되도록 URL 주소 전달 --%>    
<%-- => 로그인처리를 위해 session 내장객체에 권한 관련 정보를 속성값으로 저장 --%>    
<%
	//비정상적인 요청에 대한 처리
	if(request.getMethod().equals("GET")) {//JSP 문서를 [GET] 방식으로 요청한 경우
		//session 내장객체에 에러메세지를 속성값으로 저장하고 클라이언트에게 입력페이지의 URL 주소 전달
		session.setAttribute("message", "비정상적인 방법으로 페이지를 요청 하였습니다.");
		response.sendRedirect("login_form.jsp");//입력페이지 이동
		return;	
	}

	//전달값을 반환받아 저장
	String id=request.getParameter("id");	
	String passwd=request.getParameter("passwd");
	
	//아이디와 비밀번호를 비교 - 인증 처리
	if(!id.equals("muaa") || !passwd.equals("123456")) {//인증 실패
		session.setAttribute("message", "아이디 또는 비밀번호를 잘못 입력 하였습니다.");
		session.setAttribute("id", id);
		response.sendRedirect("login_form.jsp");//입력페이지 이동
		return;
	}
	
	//인증 성공
	//session 내장객체에 권한 관련 정보(아이디)를 속성값으로 저장
	session.setAttribute("loginId", id);
	response.sendRedirect("login_user.jsp");//출력페이지 이동
%>