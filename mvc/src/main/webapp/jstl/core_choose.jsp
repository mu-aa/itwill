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
	<h1>Core - 흐름 제어 태그</h1>
	<hr>
	<c:set var="choice" value="1" />
	
	<%-- choose 태그 : 조건에 의해 태그내용의 포함 여부를 선택하기 위한 상위태그 --%>
	<%-- ㄴ 하위태그를 이용하여 태그내용의 포함 여부 선택 --%>
	<%-- ㄴ 하위태그 : when 태그(1개 이상), otherwise 태그(0개 또는 1개) --%>
	<%-- ㄴ choose 태그에는 하위태그 외에 다른 코드가 존재할 경우 에러 발생 - JSP 주석은 예외 --%>
	<c:choose>
		<%-- when 태그 : 조건에 대한 결과에 태그내용의 포함 여부를 선택하기 위한 태그 --%>
		<%-- test 속성 : false 또는 true 중 하나를 속성값으로 설정 --%>
		<%-- ㄴ test 속성값이 [false]인 경우 태그내용을 포함하지 않고 다음 when 태그 또는 otherwise 태그로 이동 --%>
		<%-- ㄴ test 속성값이 [true]인 경우 태그내용을 포함 후 choose 태그 종료 --%>
		<c:when test="${choice == 1 }">
			<p>수성으로 이동합니다.</p>
		</c:when>
		<c:when test="${choice == 2 }">
			<p>금성으로 이동합니다.</p>
		</c:when>
		<c:when test="${choice == 3 }">
			<p>화성으로 이동합니다.</p>
		</c:when>
		<%-- otherwise 태그 : when 태그의 모든 조건이 false인 경우 태그내용을 무조건 포함하기 위한 태그 --%>
		<c:otherwise>
			<p>지구로 이동합니다.</p>
		</c:otherwise>
	</c:choose>
	<hr>
	<c:set var="num" value="10" />
	<c:choose>
		<c:when test="${num % 2 != 0 }">${num } = 홀수</c:when>
			<c:otherwise>${num } = 짝수</c:otherwise>
	</c:choose>
</body>
</html>