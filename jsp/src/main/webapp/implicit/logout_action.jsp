<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 로그아웃 처리 후 클라이언트에게 로그인 정보 입력페이지(login_form.jsp)로 이동하기 위한 URL 주소를 전달하는 JSP 문서 --%>
<%-- ㄴ 로그아웃 : 권한 관련 정보를 제거하는 작업 --%>
<%
	//session 내장객체에 저장된 권한 관련 정보(아이디)의 속성값을 삭제
	//session.removeAttribute("loginId");

	//session.invalidate() : 바인딩 세션을 언바인딩 처리하는 메소드 - session 내장객체 제거
	session.invalidate();

	//클라이언트에게 URL 주소 전달
	response.sendRedirect("login_form.jsp");
%>