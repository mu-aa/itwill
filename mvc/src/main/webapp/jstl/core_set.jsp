<%@page import="xyz.itwill.el.Student"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- taglib Directive를 이용하여 JSTL의 Core 태그 라이브러리를 JSP 문서에 포함해야만
커스텀 태그를 제공받아 사용 가능 - prefix 속성값으로 [c]로 설정 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>Core - EL 지원 태그</h1>
	<hr>
	<%-- set 태그 : 객체를 scope 속성값으로 저장(변경)하기 위한 태그 --%>
	<%-- var 속성 : scope 속성명을 속성값으로 설정 --%>
	<%-- value 속성 : scope 속성값을 속성값으로 설정 --%>
	<%-- scope 속성 : page, request, session, application 중 하나를 속성값으로 설정 --%>
	<%-- ㄴ scope 속성을 생략할 경우 [page] 속성값을 default로 사용 --%>
	<c:set var="su" value="10" scope="page" />
	<p>su = ${su }</p>
	
	<%-- scope 속성명이 같은 경우 scope 속성값 변경 처리 --%>
	<%-- value 속성 대신 태그내용으로 scope 속성값 처리 가능 --%>
	<c:set var="su">20</c:set>
	<p>su = ${su }</p>
	
	<%-- value 속성값으로 EL 사용 가능 - EL 표현식에서 EL 연산자 사용 --%>
	<c:set var="tot" value="${su+10 }" />
	<p>tot = ${tot }</p>
	
	<c:set var="name" value="홍길동" />
	<p>name = ${name }</p>
	
	<c:set var="now" value="<%=new Date() %>" />
	<%-- EL 표현식에 의해 제공받은 scope 속성값이 Java 객체인 경우 자동으로 toString() 메소드 호출 --%>
	<p>now = ${now }</p>
	<p>now.getTime() = ${now.getTime() }</p>
	<p>now.time = ${now.time }</p><%-- EL에서 getXXX 메소드는 get 없이 호출 가능 --%>
	
	<c:set var="student" value="<%=new Student() %>" />
	<%-- Student 클래스에 toString() 메소드가 오버라이드 선언되지 않아 Object 클래스의 toString() 메소드 호출 --%>
	<p>student = ${student }</p>
	<p>학번 = ${student.num }, 이름 = ${student.name }</p>
	
	<%-- set 태그를 이용하여 scope 속성값으로 제공된 객체의 필드값 변경 가능 - Setter 메소드 자동 호출 --%>
	<%-- target 속성 : 필드값을 변경할 객체(scope 속성값 - EL)를 속성값으로 설정 --%>
	<%-- property 속성 : 필드값을 변경할 객체의 필드명을 속성값으로 설정 --%>
	<c:set target="${student }" property="num" value="1000" />
	<c:set target="${student }" property="name" value="홍길동" />
	<p>학번 = ${student.num }, 이름 = ${student.name }</p>
	
	<%-- remove 태그 : 스코프 속성값을 속성명을 이용하여 삭제하는 태그 --%>
	<c:remove var="student"/>
	<p>student = ${student }</p>
</body>
</html>