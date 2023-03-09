<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//클라이언트에 쿠키가 저장되도록 Cookie 객체를 생성하여 클라이언트에게 전달
	//ㄴ Cookie 객체에 저장되는 쿠키명과 쿠키값은 한글 사용 불가능
	//ㄴ 쿠키값으로 한글을 저장하고자 하는 경우 부호화 처리하여 저장 가능
	Cookie cookie=new Cookie("userName", "HongGilDong");
	cookie.setMaxAge(60*60); //쿠키 지속시간 1시간으로 변경
	response.addCookie(cookie); //클라이언트에게 쿠키 전달 >> 클라이언트에 쿠키 저장
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL 내장객체 - Cookie</h1>
	<hr>
	<p>클라이언트에 쿠키가 저장되도록 전달 하였습니다.</p>
	<p><a href="implicit_cookie_load.jsp">쿠키값 출력</a></p>
</body>
</html>