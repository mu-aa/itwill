<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String pageName=(String)pageContext.getAttribute("pageName"); //사용 불가
	String requestName=(String)request.getAttribute("requestName");
	String sessionName=(String)session.getAttribute("sessionName");
	String applicationName=(String)application.getAttribute("applicationName");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>객체의 사용범위(Scope)</h1>
	<hr>
	<p>pageName = <%=pageName %></p>
	<p>requestName = <%=requestName %></p>
	<p>sessionName = <%=sessionName %></p>
	<p>applicationName = <%=applicationName %></p>
</body>
</html>