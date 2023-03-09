<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL - Map</h1>
	<hr>
	<%-- scope 속성으로 Map 객체가 저장된 경우 Key가 EL 표현식으로 사용하기 부적절하면
	. 연산자로 Value를 제공받아 출력 불가능 --%>
	<%-- <p>이름 = ${hewonMap.first.name } ${hewonMap.second.name }</p> --%>
	
	<%-- scope 속성으로 Map 객체가 저장된 경우 Key가 EL 표현식으로 사용하기 부적절한 문자가
	존재할 경우 [] 연산자로 Key를 표현하여 Value를 제공받아 출력 --%>
	<p>이름 = ${hewonMap["first.name"] } ${hewonMap["second.name"] }</p>
</body>
</html>