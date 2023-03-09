<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL 내장객체 - Context Init Parameter</h1>
	<hr>
	<h3>EL 미사용</h3>
	<%-- ServletConfig.getInitParameter(String name) : [web.xml] 파일의 context-param Element로
	제공되는 값을 얻어와 반환하는 메소드 --%>
	<p>web.xml 파일에서 제공되는 이름 = <%=config.getServletContext().getInitParameter("name") %></p>
	<hr>
	<h3>EL 사용</h3>
	<%-- EL 표현식에서 initParam 내장객체를 이용하여 [web.xml] 파일의 context-param Element로
	제공되는 값을 얻어와 출력 가능 --%>
	<p>web.xml 파일에서 제공되는 이름 = ${initParam.name }</p>
</body>
</html>