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
	<h1>Core - URL 관리 태그</h1>
	<hr>
	<%-- 웹자원을 상대경로로 표현하여 제공 --%>
	<%-- 상대경로 : 현재 요청 웹프로그램의 경로를 기준으로 웹자원의 경로를 표현하는 방법 --%>
	<%-- 문제점) MVC 디자인 패턴을 이용한 JSP Model-2 방식으로 웹프로그램 작성시 요청 웹프로그램(Controller)의
	경로와 응답 웹프로그램(View)의 경로가 다른 경우 404 에러 발생 --%>
	<%-- 해결법) 웹자원의 경로를 절대경로로 표현하여 제공 --%>
	<img src="images/image.png" width="200">
	
	<%-- 절대경로 : 최상위 디렉토리를 기준으로 웹자원의 경로를 표현하는 방법 --%>
	<%-- ㄴ CSL(HTML, CSS, JavaScript 등)에서는 서버 디렉토리를 최상위 디렉토리로 처리 --%>
	<%-- 문제점) 컨텍스트 이름이 변경될 경우 컨텍스트 경로가 변경되어 404 에러 발생 --%>
	<%-- 해결법) request 객체의 메소드를 호출하여 컨텍스트 경로를 반환받아 사용 --%>
	<img src="/mvc/jstl/images/image.png" width="225">
	
	<%-- request.getContextPath() 메소드를 호출하여 컨텍스트 경로를 반환받아 절대경로로 표현 --%>
	<img src="<%=request.getContextPath() %>/jstl/images/image.png" width="250">
	
	<%-- EL 표현식에서 pageContext 내장객체를 사용하여 컨텍스트 경로를 제공받아 절대경로로 표현 --%>
	<img src="${pageContext.request.contextPath }/jstl/images/image.png" width="275">
	
	<%-- url 태그 : 컨텍스트 경로가 포함된 웹자원의 절대경로를 제공하는 태그 --%>
	<%-- value 속성 : 컨텍스트 경로를 제외한 웹자원의 경로를 속성값으로 설정 --%>
	<%-- JavaScript에서 url 태그가 인식이 안될경우 EL 표현식 사용 --%>
	<img src="<c:url value='/jstl/images/image.png'/>" width="300">
</body>
</html>