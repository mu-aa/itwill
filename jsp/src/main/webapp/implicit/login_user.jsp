<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 로그인 사용자에게 환영메세지를 전달하는 JSP 문서 --%>
<%-- ㄴ 비로그인 사용자가 JSP 문서를 요청한 경우 로그인 입력페이지(login_form.jsp)로 이동하기
위한 URL 주소 전달 - 비정상적인 요청에 대한 처리 --%>
<%-- ㄴ [로그아웃]을 클릭한 경우 로그아웃 처리페이지(logout_action.jsp)로 이동 --%>
<%-- ㄴ [메인으로]를 클릭한 경우 메인페이지(login_form.jsp)로 이동 --%>
<%
	//session 내장객체에 저장된 권한 관련 속성값(아이디)를 반환받아 저장
	String loginId=(String)session.getAttribute("loginId");

	//session 내장객체에 저장된 권한 관련 속성값이 없는 경우 - 비로그인 사용자인 경우
	if(loginId==null) {//비정상적인 방법으로 JSP 문서를 요청한 경우
		session.setAttribute("message", "로그인 사용자만 접근 가능한 페이지입니다.");
		response.sendRedirect("login_form.jsp");
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
	<h1>로그인 사용자 전용 페이지</h1>
	<hr>
	<p><%=loginId %>님, 환영합니다.&nbsp;&nbsp;
	<a href="logout_action.jsp">[로그아웃]</a>&nbsp;&nbsp;
	<a href="logout_form.jsp">[메인으로]</a>
	</p>
	<hr>
	<p>로그인 사용자만 확인 가능한 중요한 내용입니다.</p>
	<p>로그인 사용자만 확인 가능한 중요한 내용입니다.</p>
	<p>로그인 사용자만 확인 가능한 중요한 내용입니다.</p>
	<p>로그인 사용자만 확인 가능한 중요한 내용입니다.</p>
	<p>로그인 사용자만 확인 가능한 중요한 내용입니다.</p>
	<p>로그인 사용자만 확인 가능한 중요한 내용입니다.</p>
	<p>로그인 사용자만 확인 가능한 중요한 내용입니다.</p>
	<p>로그인 사용자만 확인 가능한 중요한 내용입니다.</p>
	<p>로그인 사용자만 확인 가능한 중요한 내용입니다.</p>
	<p>로그인 사용자만 확인 가능한 중요한 내용입니다.</p>
</body>
</html>