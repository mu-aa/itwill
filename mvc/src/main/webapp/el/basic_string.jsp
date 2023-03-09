<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//pageContext.setAttribute(String attributeName, Object attributeValue)
	//ㄴ pageContext 내장객체에 속성명(문자열)과 속성값(객체)을 전달받아 저장하는 메소드 - page Scope
	//Page Scope : 스코프 속성값을 저장한 웹프로그램에서만 객체를 반환받아 사용 가능
	pageContext.setAttribute("name", "홍길동");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL(Expression Language)</h1>
	<hr>
	<p>EL : Scope 속성값으로 저장된 객체를 제공받아 클라이언트에게 전달하여 출력하기 위한 언어</p>
	<hr>
	<h2>EL 미사용</h2>
	<%
		//pageContext.getAttribute(String attributeName) : pageContext 내장객체에 저장된 속성값, 속성명
		//을 이용하여 객체로 반환하는 메소드
		//ㄴ Object 타입의 객체로 반환하므로 반드시 명시적 객체 형변환 후 사용
		String name=(String)pageContext.getAttribute("name");
	
		//전달받은 속성명에 대한 속성값이 없는 경우 null 반환
		String pageName=(String)pageContext.getAttribute("pageName");
	%>
	<p>이름(name) = <%=name %></p>

	<%-- JSP 표현식에서는 출력값이 [null]인 경우 "null" 문자열로 변환되어 출력 --%>
	<p>이름(pageName) = <%=pageName %></p>
	
	<%-- if 명령을 사용하여 JSP 표현식의 값이 [null]이 아닌 경우에만 출력되도록 설정 --%>
	<p>이름(pageName) = <% if(pageName!=null) { %>  <%=pageName %> <% } %></p>
	
	
	<h2>EL 사용</h2>
	<%-- ${속성명} : EL 표현식으로 scope의 속성명을 사용하면 속성값을 제공받아 출력 --%>
	<%-- ㄴ getAttribute() 메소드를 호출하지 않아도 scope의 속성값을 제공받아 사용 가능 --%>
	<p>이름(name) = ${name }</p>
	<%-- scope 속성명으로 저장된 속성값이 없는 경우 EL 미실행 --%>
	<p>이름(pageName) = ${pageName }</p>
</body>
</html>