<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SPRING</title>
</head>
<body>
	<h1>회원정보</h1>
	<hr>
	<ul>
		<li>아이디 =${hewon.id } </li>
		<li>이름 =${hewon.name } </li>
		<li>이메일 =${hewon.email } </li>
	</ul>
	
	<%-- 회원정보 변경 페이지를 요청할 수 있는 링크 제공 - 아이디 전달 --%>
	<%-- <button type="button" onclick="location.href='hewon_update?id=${hewon.id }';">회원정보변경</button> --%>
	<%-- @SessionAttributes Annotation을 사용한 경우 아이디를 전달하지 않아도 회원정보 변경 페이지의
	요청 처리 메소드에서 회원정보를 제공받아 사용 가능 --%>
	<button type="button" onclick="location.href='hewon_update?';">회원정보변경</button>
</body>
</html>