<%-- page Directive에서는 동일한 속성을 다른 속성값으로 중복 선언할 경우 JSP 문서 실행 시 500 에러 발생
- import 속성 제외 --%>
<%-- <%@page import="java.util.List, java.util.ArrayList" %> --%>

<%-- page Directive의 import 속성은 자동 완성 기능 사용 --%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//java.util.List<java.lang.String> nameList=new java.util.ArrayList<java.lang.String>();
	List<String> nameList=new ArrayList<String>();
	nameList.add("홍길동");
	nameList.add("임꺽정");
	nameList.add("전우치");
	nameList.add("일지매");
	nameList.add("장길산");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>page Directive - import 속성</h1>
	<hr>
	<p>import 속성에는 JSP 문서에서 사용할 클래스 또는 인터페이스를 속성값으로 설정
	- 클래스 또는 인터페이스의 패키지를 명확하게 표현하여 제공</p>
	<hr>
	<ul>
	<% for(String name:nameList) { %>
			<li><%=name %></li>
		<% } %>
	</ul>
</body>
</html>