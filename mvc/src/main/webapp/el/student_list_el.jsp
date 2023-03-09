<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL - List</h1>
	<hr>
	<%-- EL 표현식에 . 연산자로 index를 표현하면 ELException 발생 --%>
	<%-- <p>학번 = ${studentList.0.num }, 이름 = ${studentList.0.name }; --%>
	<p>학번 = ${studentList[0].num }, 이름 = ${studentList[0].name }</p>
	<p>학번 = ${studentList[1].num }, 이름 = ${studentList[1].name }</p>
	<p>학번 = ${studentList[2].num }, 이름 = ${studentList[2].name }</p>
	<p>학번 = ${studentList[3].num }, 이름 = ${studentList[3].name }</p>
	<p>학번 = ${studentList[4].num }, 이름 = ${studentList[4].name }</p>
</body>
</html>