<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>Formatter - 숫자 변환 태그</h1>
	<hr>
	<c:set var="price" value="1000000000"></c:set>
	<p>가격 = ${price }원</p>
	
	<%-- formatNumber 태그 : 숫자값을 원하는 형식의 문자열로 변환하여 제공하는 태그 --%>
	<%-- ㄴ DecimalFormat 클래스 참조 --%>
	<%-- value 속성 : 변환할 숫자값을 속성값으로 설정 - EL 사용 가능 --%>
	<%-- ㄴ 속성값으로 숫자가 아닌 문자가 포함된 경우 NumberFormatException 발생 --%>
	<%-- type 속성 : number(숫자) 또는 currency(화폐) 중 하나를 속성값으로 설정 --%>
	<%-- ㄴ type 속성을 생략한 경우 [number] 속성값을 기본값으로 사용하여 처리 --%>
	<%-- ㄴ type 속성값이 [number]인 경우 숫자 3자리마다 [,] 기호가 삽입된 문자열로 변환되어 제공 --%>
	<%-- ㄴ type 속성값이 [currency]인 경우 앞부분에 화폐단위가 포함되고 숫자 3자리마다 [,] 기호가 삽입된 문자열로 변환되어 제공 --%>
	<p>가격 = <fmt:formatNumber value="${price }" type="number" />원</p>
	<p>가격 = <fmt:formatNumber value="${price }" type="currency" />원</p>
	
	<%-- pattern 속성 : 숫자값을 변환하기 위한 패턴문자가 포함된 문자열을 속성값으로 설정 --%>
	<p>가격 = <fmt:formatNumber value="${price }" pattern="$##,###,###,##0.00" /></p>
</body>
</html>