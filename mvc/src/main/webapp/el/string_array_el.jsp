<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1></h1>
	<hr>
	<ul>
		<%-- scope 속성값이 배열인 경우 배열 요소값을 표현하기 위해 EL 표현식에서 . 연산자로
		index를 표현한 경우 ELException 발생 - . 연산자 사용 불가능 --%>
		<%-- <li>${nameArray.0 }</li> --%>
		<%-- scope 속성값이 배열인 경우 배열 요소값을 표현하기 위해 EL 표현식에서 [] 연산자로
		index를 표현하여 요소값을 제공받아 출력 --%>
		<%-- <li>${nameArray["0"] }</li> --%><%-- index는 "" 기호 생략 가능 --%>
		<li>${nameArray[0] }</li>
		<li>${nameArray[1] }</li>
		<li>${nameArray[2] }</li>
		<li>${nameArray[3] }</li>
		<li>${nameArray[4] }</li>
		<%-- EL 표현식의 index가 배열요소의 범위를 벗어난 경우 EL 미실행 - 미출력--%>
		<li>${nameArray[5] }</li>
	</ul>
</body>
</html>