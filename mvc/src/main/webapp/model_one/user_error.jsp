<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 에러메세지를 전달하는 JSP 문서 --%>
<%-- ㄴ [로그인 페이지 이동] 태그를 클릭한 경우 로그인 정보 입력페이지(user_login.jsp)로 이동 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
<style type="text/css">

body {text-align: center;}
.message {color: red; font-size: 1.5em;}

</style>
</head>
<body>
	<h1>에러페이지</h1>
	<hr>
	<p class="message">프로그램 실행에 예기치 못한 오류가 발생하였거나 비정상적인 방법으로
	프로그램을 요청하여 오류가 발생 하였습니다.</p>
	<button type="button" onclick="location.href='user_login.jsp';">로그인 페이지 이동</button>
</body>
</html>