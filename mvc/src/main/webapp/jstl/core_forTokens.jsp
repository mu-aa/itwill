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
	<h1>Core - 흐름 제어 태그</h1>
	<hr>
	<c:set var="phone" value="010-1234-5678" />
	<p>전화번호 = ${phone }</p>
	<hr>
	<%-- forTokens 태그 : scope 속성값으로 저장된 문자열(String 객체)을 특정 문자열로 
	분리하여 반복처리하는 태그 --%>
	<%-- items 속성 : 분리 처리하기 위한 문자열을 속성값으로 설정 - EL 사용 가능 --%>
	<%-- delims 속성 : 문자열을 분리하기 위한 구분자를 속성값으로 설정 --%>
	<%-- var 속성 : 분리된 문자열을 하나씩 얻어와 scope 속성값으로 저장하기 위한
	 scope 속성명을 속성값으로 설정 --%>
	<c:forTokens items="${phone }" delims="-" var="num">
		<div>${num }</div>
	</c:forTokens>
</body>
</html>