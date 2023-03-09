<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>JSTL(Java Standard Tag Library)</h1>
	<hr>
	<p>JSTL : JSP 문서에서 많이 사용하는 EL 함수와 커스텀 태그를 제공하기 위한 라이브러리</p>
	<p>JSP 문서에서 JSTL이 제공하는 EL 함수 또는 커스텀 태그를 사용하기 위해선 라이브러리
	파일을 다운로드 받아 /WEB-INF/lib에 build 처리</p>
	<%-- https://tomcat.apache.org -> Download -> Taglibs -> jar Files [Impl, Spec, EL, Compat] --%>
	<hr>
	<p>★Core : EL 지원 태그, 프로그램의 흐름 제어 태그, URL 주소 관리 태그 등을 제공</p>
	<p>Fomatter : 숫자 또는 날짜와 시간 형식 변경 태그, 국제화 태그, 다국어 지원 태그 등을 제공</p>
	<p>SQL : 테이블에 대한 행 삽입, 변경, 삭제, 검색 기능(CRUD)의 태그 제공 - 사용 안함(DAO로 대체 가능)</p>
	<p>XML : XML 문서에 대한 처리 기능의 태그 제공 - 거의 안 씀</p>
	<p>Functions : 문자열 처리 기능의 EL 함수 제공</p>
</body>
</html>