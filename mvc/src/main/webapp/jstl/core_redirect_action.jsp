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
	<c:choose>
		<c:when test="${!empty(param.name) }">
			<p>${param.name }님, 안녕하세요.</p>
		</c:when>
		<c:otherwise>
			<%-- redirect 태그 : 클라이언트에게 URL 주소를 전달하여 재요청하도록 응답 처리하는 태그 --%>
			<%-- url 속성 : 클라이언트에게 전달하여 재요청하기위한 URL 주소를 속성값으로 설정 --%>
			<c:redirect url="core_redirect_form.jsp" />
		</c:otherwise>
	</c:choose>
</body>
</html>