<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>Core - EL 지원 태그</h1>
	<hr>
	<c:set var="num" value="100" />
	<p>정수값 = ${num }</p>
	<%-- out 태그 : 값(EL - scope 속성값)을 클라이언트에게 전달하기 위한 출력 태그 --%>
	<p>정수값 = <c:out value="${num }" /></p>
	<hr>
	<%-- scope 속성값으로 HTML 태그가 포함된 문자열(String 객체) 저장 --%>
	<c:set var="html" value="<font size='7' color='red'>안녕하세요</font>"/>
	<%-- EL을 사용하여 HTML 태그가 포함된 속성값을 문자열로 제공받아 출력할 경우
	 HTML 태그로 처리되어 출력 --%>
	<p>html = ${html }</p>
	<%-- out 태그를 사용하여 HTML 태그가 포함된 속성값을 문자열로 제공받아 출력할 경우
	 HTML 태그도 값으로 처리되어 출력 --%>
	<p>html = <c:out value="${html }" /></p>
</body>
</html>