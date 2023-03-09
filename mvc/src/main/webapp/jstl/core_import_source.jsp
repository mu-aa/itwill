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
	<p>core_import_source.jsp 문서의 응답결과</p>
	
	<%-- import 태그 : 다른 웹프로그램들을 요청하여 결과를 응답받아 포함하는 태그 --%>
	<%-- ㄴ JSP의 include 액션 태그와 유사한 기능 --%>
	<%-- url 속성 : 요청 웹프로그램의 URL 주소를 속성값으로 설정 --%>
	<%-- <c:import url="core_import_target.jsp"></c:import> --%>
	
	<%-- JSP의 include 태그는 현재 서버의 웹프로그램만 요청하여 실행 결과를 응답받아 포함 가능하지만
	import 태그는 다른 서버의 웹프로그램을 요청하여 실행결과를 응답받아 포함 가능 --%>
	<%-- ㄴ HTML의 iframe 태그와 유사한 기능 --%>
	<%-- <c:import url="https://www.naver.com"></c:import> --%>
	
	<%-- URL 관리 태그에서는 param 태그를 하위태그로 사용하여 값 전달 가능 --%>
	<c:import url="core_import_target.jsp">
		<%--param 태그 : 요청 웹프로그램에게 값을 전달하기 위한 태그 --%>
		<%-- ㄴ URL 관리 태그의 종속 태그  --%>
		<%-- ㄴ URL 관리 태그에 param 태그를 제외한 코드가 존재할 경우 에러 발생 - JSP 주석 예외 --%>
		<c:param name="name" value="홍길동" />
	</c:import>	
</body>
</html>