<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//비정상적인 요청 처리
	if(request.getMethod().equals("GET")) {
		response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
		return;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>회원정보확인</h1>
	<hr>
	<%-- useBean 태그를 사용하여 request 내장객체에 저장된 속성값을 객체로 반환받아 저장 --%>
	<jsp:useBean id="user" class="xyz.itwill.bean.User" scope="request"/>
	<%-- == User=user=(User).request.getAttribute("user"); --%>
	
	<%-- getProperty ActionTag : useBean 태그로 제공된 객체의 필드값을 반환받기 위한 태그 --%>
	<%-- ㄴ 객체 필드의 Getter 메소드를 호출하여 객체의 필드값을 반환받아 사용 --%>
	<%-- 형식) <jsp:getProperty name="식별자" property="필드명" value="값"/> --%>
	<%-- name 속성(필수) : useBean 태그로 제공된 객체의 식별자(id 속성값)를 속성값으로 설정 --%>
	<%-- property 속성(필수) : 값을 반환할 필드명을 속성값으로 설정 --%>
	<%-- ㄴ 필드명을 기반으로 작성된 Getter 메소드 자동 호출 - 작성된 Getter 메소드가 없는 경우 에러 발생 --%>
	<p>이름 = <jsp:getProperty name="user" property="name"/></p>
	<p>전화번호 = <jsp:getProperty name="user" property="phone"/></p>
	<p>주소 = <jsp:getProperty name="user" property="address"/></p>
</body>
</html>