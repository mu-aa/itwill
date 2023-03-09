<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL 내장객체 - Cookie</h1>
	<hr>
	<h3>EL 미사용</h3>
	<%
		//클라이언트에서 전달된 모든 쿠키를 Cookie 객체 배열로 반환받아 저장
		Cookie[] cookies=request.getCookies();
		String userName="";
		//Cookie 객체 배열의 요소값(Cookie 객체)을 하나씩 제공받아 반복 처리
		//ㄴ Cookie 객체의 쿠키명을 반환받아 비교하여 쿠키값 저장
		for(Cookie cookie:cookies) {
			if(cookie.getName().equals("userName")) {
				userName=cookie.getValue();
			}
		}
	%>
	<p>쿠키에 저장된 사용자 이름 = <%=userName %></p>
	<hr>
	<h3>EL 사용</h3>
	<%-- EL 표현식에서 cookie 내장객체를 이용하여 쿠키명으로 쿠키값을 제공받아 출력 가능 --%>
	<%-- ㄴ 쿠키명으로 제공되는 값은 Cookie 객체이므로 쿠키값을 제공받기 위해 반드시 value 표현식 사용 --%>
	<p>쿠키에 저장된 사용자 이름 = ${cookie.userName.value }</p>
</body>
</html>