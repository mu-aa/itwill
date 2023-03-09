<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SPRING</title>
<link href="<c:url value="/css/style.css"/>" type="text/css" rel="stylesheet">
</head>
<body>
	<h1 class="text">리소스 파일</h1>
	<hr>
	<%-- Resource File : 클라이언트가 HTML 문서를 해석하여 실행하기 위해 필요한 정보를 제공하는 서버에 저장된 파일 --%>
	<%-- ㄴ CSS 파일, JavaScript Source 파일, 멀티미디어 파일 등 --%>
	<%-- ㄴ resource 파일을 WEB-INF 폴더에 저장할 경우 클라이언트는 resource 파일 요청 불가능 --%>
	<%-- WEB-INF 폴더 : 웹서버에서 실행되는 프로그램(Servlet)에서만 접근 가능한 폴더 - 클라이언트에게는 은닉화 --%>
	
	<%-- Spring Mvc 프로그램에서는 클라이언트의 모든 요청을 Front Controller를 이용하여 처리되도록 설정 --%>
	<%-- ㄴ 문제점) 클라이언트가 서버의 resource 파일을 요청할 경우 Front Controller가 요청을 받아 요청 URL 주소와
	매핑된 요청 처리 메소드를 검색하지만 존재하지 않으므로 404 에러 발생 --%>
	<%-- ㄴ Front Controller를 특정 확장자로 페이지 요청하는 경우 제외 --%>
	<%-- 해결법) 클라이언트가 resource 파일을 요청한 경우 Front Controller가 요청 처리 메소드를 호출하지 않고
	resource 파일이 직접 응답되도록 Spring Bean Configuration File 설정 - servlet-context.xml --%>
	
	<%-- resource 파일을 상대경로로 표현하여 처리한 경우 페이지의 요청 URL 주소 경로와 resource 파일의 경로가
	다른 경우 404 에러 발생 - resource 파일은 절대경로로 표현하는 것을 권장 --%>
	<%-- <img src="images/image.png" width="200"> --%>
	
	<%-- context 이름이 변경될 경우 context 경로가 변경되어 404 에러 발생 --%>
	<%-- ㄴ context 경로는 직접 지정하지 않고 객체로 제공받아 사용 --%>
	<%-- <img src="/spring/images/image.png" width="200"> --%>
	
	<%-- context 경로를 EL의 pageContext 내장객체로 제공받아 사용 --%>
	<img src="${pageContext.request.contextPath }/images/image.png" width="200">
	
	<%-- context 경로를 Core 태그 라이브러리의 URL 태그로 제공받아 사용  --%>
	<img src="<c:url value="/images/image.png"/>" width="200">
	
	<%-- context 경로를 Spring 태그 라이브러리의 URL 태그로 제공받아 사용 - 비권장 --%>
	<img src="<spring:url value="/images/Koala.jpg"/>" width="200">
</body>
</html>