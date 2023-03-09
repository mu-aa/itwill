<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- taglib Directive를 이용하여 JSTL의 Functions 태그 라이브러리를 JSP 문서에 포함해야
EL 함수를 제공받아 사용 가능 - prefix 속성값은 [fn]으로 설정 --%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>Functions - EL 함수</h1>
	<hr>
	<c:set var="phone" value="010-1234-5678" />
	<p>전화번호 = ${phone }</p>
	<hr>
	<%-- split 함수 : 문자열을 구분자로 분리하여 배열로 반환하는 함수 --%>
	<c:set var="array" value="${fn:split(phone, '-') }" />
	<c:forEach var="num" items="${array }">
		<div>${num }</div>
	</c:forEach>
	<hr>
	<%-- substring 함수 : 문자열을 시작첨자(포함)와 종료첨자(미포함)를 사용해 분리하여 반환하는 함수 --%>
	<div>${fn:substring(phone, 0, 3) }</div>
	<div>${fn:substring(phone, 4, 8) }</div>
	<div>${fn:substring(phone, 9, 13) }</div>
	<hr>
	<c:set var="content" value="안녕하세요\n반갑습니다." />
	<div>${content }</div>
	<%-- replace 함수 : 문자열에서 원하는 문자열을 검색하여 치환 문자열로 변환하여 반환하는 함수 --%>
	<div>${fn:replace(content, '\\n', '<br>') }</div>
	<hr>
	<c:set var="html" value="<font size='7' color='red'>안녕하세요.</font>" />
	<%-- HTML 태그가 포함된 문자열이 저장된 속성값을 EL로 제공받아 출력할 경우 HTML 태그가 적용된
	문자열로 출력 --%>
	<div>${html }</div>
	<%-- HTML 태그가 포함된 문자열이 저장된 속성값을 out 태그로 제공받아 출력할 경우 HTML 태그도
	문자열로 적용되어 출력 --%>
	<div><c:out value="${html }" /></div>
	<%-- escapeXml 함수 : 속성값으로 제공된 문자열에 태그 관련 문자가 있는 경우 회피문자로 변환하여 반환하는 함수 --%>
	<div>${fn:escapeXml(html) }</div>
</body>
</html>