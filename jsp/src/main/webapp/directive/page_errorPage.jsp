<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="page_error.jsp"%> --%>
<%-- [web.xml] 파일에서 모든 웹프로그램의 요청과 실행에 의해 발생되는 에러코드(4XX, 5XX)를
클라이언트에게 전달하는 대신 에러페이지로 응답되도록 설정 가능 - 클라이언트 URL 주소 미변경 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String text="ABCDEFG";
	//String text=null; //NullPointerException 발생
	
	int num=10/0; //ArismathicException 발생
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>page Directive - errorPage 속성</h1>
	<hr>
	<p>errorPage 속성에는 JSP 문서 실행 시 에러(Exception)가 발생될 경우 클라이언트에게 500 에러코드 대신
	에러페이지로 응답하기 위한 웹문서의 URL 주소를 속성값으로 설정 - 클라이언트의 URL 주소 미변경</p>
	<hr>
	<p>문자열의 문자 갯수 = <%=text.length() %></p>
	<p>num = <%=num %></p>
</body>
</html>