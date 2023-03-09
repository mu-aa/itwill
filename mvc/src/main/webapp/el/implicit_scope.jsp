<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//JSP 내장객체에 따라 속성값을 저장하여 사용할 수 있는 범위가 다르게 구분
	//속성값 사용범위(Scope) : Page Scope, Request Scope, Session Scope, Application Scope
	pageContext.setAttribute("pageName", "홍길동"); //Page Scope - 현재 페이지
	request.setAttribute("requestName", "임꺽정"); //Request Scope - 현재 + Thread가 이동한 페이지
	session.setAttribute("sessionName", "전우치"); //Session Scope - 같은 클라이언트 브라우저
	application.setAttribute("applicationName", "일지매"); //Application Scope - 같은 서버
	
	//JSP 내장객체가 다른 경우 속성명을 동일하게 설정하여 속성값 저장 가능
	//ㄴ JSP 내장객체가 같은 경우 속성명을 동일하게 설정하면 기존 속성값 대신 새로운 속성값 저장(변경)
	pageContext.setAttribute("name", "홍길동"); 
	request.setAttribute("name", "임꺽정"); 
	session.setAttribute("name", "전우치"); 
	application.setAttribute("name", "일지매"); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL 내장객체 - Scope Attribute</h1>
	<hr>
	<h3>Scope 속성명이 서로 다른 경우</h3>
	<ul>
		<li>pageName 속성값(Page Scope) = ${pageName }</li>
		<li>requestName 속성값(Request Scope) = ${requestName }</li>
		<li>sessionName 속성값(Session Scope) = ${sessionName }</li>
		<li>applicationName 속성값(Application Scope) = ${applicationName }</li>
	</ul>
	<hr>
	<h3>Scope 속성명이 같은 경우</h3>
	<%-- EL 표현식의 속성명으로 속성값을 검색하여 제공하는 순서 존재 --%>
	<%-- ㄴ Page Scope -> Request Scope -> Session Scope -> Application Scope --%>
	<%-- ㄴ JSP 내장객체에 동일한 이름의 속성명이 존재할 경우 먼저 검색된 속성값을 제공받아 출력 --%>
	<%-- ㄴ JSP 내장객채의 속성명을 다르게 설정하는 것을 권장 --%>
	<%-- 
	<ul>
		<li>pageName 속성값(Page Scope) = ${name }</li>
		<li>requestName 속성값(Request Scope) = ${name }</li>
		<li>sessionName 속성값(Session Scope) = ${name }</li>
		<li>applicationName 속성값(Application Scope) = ${name }</li>
	</ul>
	--%>
	
	<%-- JSP 내장객체의 속성명이 동일한 경우 EL 표현식에서 EL 내장객체를 사용하여 scope 속성값을 구분하여 출력 가능
	ㄴ EL 내장객체 : pageScope, requestScope, sessionScope, applicationScope (이름을 다르게 할 것을 권장) --%>
	<ul>
		<li>pageName 속성값(Page Scope) = ${pageScope.name }</li>
		<li>requestName 속성값(Request Scope) = ${requestScope.name }</li>
		<li>sessionName 속성값(Session Scope) = ${sessionScope.name }</li>
		<li>applicationName 속성값(Application Scope) = ${applicationScope.name }</li>
	</ul>
</body>
</html>