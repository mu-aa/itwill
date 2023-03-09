<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 사용자 입력값을 전달받아 클라이언트에게 전달하는 JSP 문서 --%>
<%-- Post 방식으로 요청하여 Request Message의 Body에 저장되어 전달하는 값에 대한 Charset 변경 --%>
<%-- ㄴ 인코딩 필터를 이용할 경우 필터에 의해 웹프로그램 실행 전 Charset 변경 가능 --%>
<%-- request.setCharacterEncoding("utf-8"); --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL 내장객체 - Request Parameter</h1>
	<hr>
	<h3>EL 미사용</h3>
	<ul>
		<li>이름 = <%=request.getParameter("name") %></li>
		<li>주소 = <%=request.getParameter("address") %></li>
		<%-- 같은 이름으로 전달되는 값이 여러 개 있는 경우 첫번째 전달값만 반환받아 사용 --%>
		<%--
		<li>음식-1 = <%=request.getParameter("food") %></li>
		<li>음식-2 = <%=request.getParameter("food") %></li>
		--%>
		<%-- 같은 이름으로 전달되는 값이 여러 개 있는 경우 getParameterValues() 메소드로
		모든 전달값을 문자열 배열로 반환받아 사용 가능 --%>
		<li>음식-1 = <%=request.getParameterValues("food")[0] %></li>
		<li>음식-2 = <%=request.getParameterValues("food")[1] %></li>
	</ul>
	<hr>
	<h3>EL 사용</h3>
	<ul>
		<%-- EL 표현식에서 전달값의 이름을 param 내장객체 또는 paramValues 내장객체의 MapKey로 사용하여
		전달값을 구분하여 출력 가능  --%>
		<li>이름 = ${param.name }</li>
		<li>주소 = ${param.address }</li>
		<li>음식-1 = ${paramValues.food[0] }</li>
		<li>음식-2 = ${paramValues.food[1] }</li>
	</ul>
</body>
</html>