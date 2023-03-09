<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- taglib Directive를 이용하여 JSTL의 Formatter 태그 라이브러리를 JSP 문서에 포함해야
커스텀 태그를 제공받아 사용 가능 - prefix 속성값은 [fmt]로 설정 --%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>Formatter - 날짜와 시간 변환 태그</h1>
	<hr>
	<%-- 서버 시스템의 현재 날짜와 시간이 저장된 Date 객체를 생성하여 scope 속성값으로 저장 --%>
	<c:set var="now" value="<%=new Date() %>" />
	<%-- Date 객체의 toString() 메소드를 호출하여 Date 객체에 저장된 날짜와 시간을 문자열로 출력 --%>
	<p>now = ${now }</p>
	
	<%-- formatDate 태그 : Date 객체에 저장된 날짜와 시간을 원하는 형식의 문자열로 변환하여 제공 --%>
	<%-- ㄴ SimpleDateFormat 클래스 참조 --%>
	<%-- value 속성 : Date 객체를 속성값으로 설정 - EL 사용 가능 --%>
	<%-- type 속성 : date(날짜), time(시간), both(날짜와 시간) 중 하나를 속성값으로 설정 --%>
	<%-- ㄴ 속성값이 [date]인 경우 기본적으로 [yyyy.M.d.] 형식의 문자열로 변환되어 제공 --%>
	<p>now(날짜) = <fmt:formatDate value="${now }" type="date" /></p>
	
	<%-- dateStyle 속성 : full 또는 short 중 하나를 속성값으로 설정 --%>
	<%-- ㄴ dateStyle 속성값이 [full]인 경우 [yyyy년 M월 d일 E요일] 형식의 문자열로 변환되어 제공 --%>
	<%-- ㄴ dateStyle 속성값이 [short]인 경우 [yy.M.d.] 형식의 문자열로 변환되어 제공 --%>
	<p>now(날짜) = <fmt:formatDate value="${now }" type="date" dateStyle="full" /></p>
	<p>now(날짜) = <fmt:formatDate value="${now }" type="date" dateStyle="short" /></p>
	
	<%-- type 속성 : date(날짜), time(시간), both(날짜와 시간) 중 하나를 속성값으로 설정 --%>
	<%-- ㄴ 속성값이 [time]인 경우 기본적으로 [a h:mm:ss] 형식의 문자열로 변환되어 제공 --%>
	<p>now(시간) = <fmt:formatDate value="${now }" type="time" /></p>
	
	<%-- timeStyle 속성 : full 또는 short 중 하나를 속성값으로 설정 --%>
	<%-- ㄴ timeStyle 속성값이 [full]인 경우 [a h시 mm분 ss초 z] 형식의 문자열로 변환되어 제공 --%>
	<%-- ㄴ timeStyle 속성값이 [short]인 경우 [a h:mm] 형식의 문자열로 변환되어 제공 --%>
	<p>now(시간) = <fmt:formatDate value="${now }" type="time" timeStyle="full" /></p>
	<p>now(시간) = <fmt:formatDate value="${now }" type="time" timeStyle="short" /></p>
	
	<%-- type 속성 : date(날짜), time(시간), both(날짜와 시간) 중 하나를 속성값으로 설정 --%>
	<%-- ㄴ 속성값이 [both]인 경우 [yyyy.M.d. a h:mm:ss] 형식의 문자열로 변환되어 제공 --%>
	<p>now(날짜와 시간) = <fmt:formatDate value="${now }" type="both" /></p>
	<p>now(날짜와 시간) = <fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full" /></p>
	<p>now(날짜와 시간) = <fmt:formatDate value="${now }" type="both" dateStyle="short" timeStyle="short" /></p>
	
	<%-- pattern 속성 : 날짜와 시간을 변환하기 위한 패턴문자가 포함된 문자열을 속성값으로 설정 --%>
	<p>now(패턴) = <fmt:formatDate value="${now }" pattern="yyyy-MM-dd HH:mm:ss" /></p>
	
	<%-- timeZone 태그 : 타임존을 변경하는 태그 --%>
	<%-- value 속성 : 변경할 타임존(대륙/도시)을 속성값으로 설정  --%>
	<fmt:timeZone value="Asia/Hong_Kong">
		<p>홍콩의 현재 날짜와 시간 = <fmt:formatDate value="${now }" pattern="yyyy-MM-dd HH:mm:ss"/>
	</fmt:timeZone>
</body>
</html>