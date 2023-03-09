<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 로그아웃 처리 후 로그인정보 입력페이지(user_login.jsp)로 이동하기 위한 URL 주소를 전달하는 JSP 문서 --%>
<%
	//session.removeAttribute("loginUserinfo");
	session.invalidate();
	
	response.sendRedirect("user_login.jsp");
%>