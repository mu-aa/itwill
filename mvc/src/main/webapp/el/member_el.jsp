<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 요청페이지(member.jsp)의 Request Scope 속성값을 객체로 반환받아 클라이언트에게 전달하는 JSP 문서 --%>
<%-- ㄴ 요청페이지(member.jsp)에 대한 실행 결과를 제공받아 응답 처리하는 웹프로그램(View) --%>
<%-- ㄴ 응답페이지(member_el.jsp)를 요청한 경우 EL 미실행, NullPointerException 또한 미발생 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL 사용</h1>
	<hr>
	<p>회원 = ${member }</p>
	<p>회원의 이름 = ${member.name }</p>
	<p>회원의 자동차 = ${member.car }</p>
	<p>회원의 자동차 모델명 = ${member.car.modelName }</p>
	<p>회원의 자동차 색상 = ${member.car.carColor }</p>
	<hr>
	<%-- EL 표현식에서 . 연산자 대신 [] 연산자를 이용하여 필드명(맵키)으로 필드값(맵값)을 제공받아 출력 가능 --%>
	<%-- ㄴ [] 연산자에 필드명(맵키) 사용시 반드시 ""로 표현 --%>
	<p>회원의 이름 = ${member["name"] }</p>
	<p>회원의 자동차 모델명 = ${member["car"]["modelName"] }</p>
	<p>회원의 자동차 색상 = ${member["car"]["carColor"] }</p>
</body>
</html>