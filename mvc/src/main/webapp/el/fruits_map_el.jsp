<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>EL - Map</h1>
	<hr>
	<p>과일-1 = ${fruitsMap.one }</p>
	<p>과일-2 = ${fruitsMap.two }</p>
	<p>과일-3 = ${fruitsMap.three }</p>
	<hr>
	<p>좋아하는 과일 = ${fruitsMap.two }</p>
	<p>좋아하는 과일 = ${fruitsMap["two"] }</p>
	<%-- scope 속성값이 Map 객체인 경우 Key를 이용하여 Value를 제공받아 출력 가능 --%>
	<%-- ㄴ Key에 해당하는 Value가 없는 경우 EL 미실행 --%>
	<%-- <p>좋아하는 과일 = %{fruitsMap.choice }</p> --%>
	<%-- EL 표현식에서 [] 연산자를 이용하여 다른 scope 속성값을 제공받아 Key로 표현하여
	Value 출력 가능 --%>
	<p>좋아하는 과일 = ${fruitsMap[choice] }</p><%-- == ${fruitsMap["two"] } --%>
</body>
</html>