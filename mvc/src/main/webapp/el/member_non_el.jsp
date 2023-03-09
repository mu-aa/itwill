<%@page import="xyz.itwill.el.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 요청페이지(member.jsp)의 Request Scope 속성값을 객체로 반환받아 클라이언트에게 전달하는 JSP 문서 --%>
<%-- ㄴ 요청페이지(member.jsp)에 대한 실행 결과를 제공받아 응답 처리하는 웹프로그램(View) --%>
<%-- ㄴ 응답페이지(member_non_el.jsp)를 요청한 경우 Request Scope 속성값이 없어 NullPointerException 발생 --%>
<%
	//Request Scope 속성값을 객체로 반환받아 저장
	Member member=(Member)request.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL 미사용</h1>
	<hr>
	<p>회원의 이름 = <%=member.getName() %></p>
	<p>회원의 자동차 모델명 = <%=member.getCar().getModelName() %></p>
	<p>회원의 자동차 색상 = <%=member.getCar().getCarColor() %></p>
</body>
</html>